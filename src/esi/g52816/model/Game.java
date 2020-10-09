package esi.g52816.model;

import esi.g52816.controller.Controller;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bilal
 */
public class Game extends Observable {
    
    private final Dungeon dungeon;
    private Position posPlayer;
    private int nbMovement = 0;
    private int nbStorageSlot = 0;
    private int nbStorageFull = 0;
    private final Controller controller;
    
    private UndoManager _undoManager = new UndoManager();
    private final ObservableList<HistoryMove> hlist;

    /**
     * Create a game in a level
     *
     * @param level the level where start
     */
    public Game(int level, Controller c) {
        this.controller = c;
        dungeon = new Dungeon();
        dungeon.DungeonLoader(level);
        posPlayer = dungeon.playerFinder();
        nbStorageSlot = dungeon.StorageFinder();
        hlist = FXCollections.observableArrayList();
    }
    
    public Game(int level){
        controller = null;
        dungeon = new Dungeon();
        dungeon.DungeonLoader(level);
        posPlayer = dungeon.playerFinder();
        nbStorageSlot = dungeon.StorageFinder();
        hlist = FXCollections.observableArrayList();
    }

    /**
     * Allow to execute a Move if the command can be done.
     *
     * @param d the direction of the Move
     */
    public void moveExecute(Direction d) {
        
        Command c = new MoveCommand(this, d);
        
        if (c.canExecute()) {
            _undoManager.doIt(new MoveCommand(this, d));
        }
    }

    /**
     * Move the Player in a specific direction
     *
     * @param d the direction where the Player will be done
     * @return true or false if done or not
     */
    public boolean move(Direction d) {
        boolean b = false;
        Position nextPos = new Position(posPlayer);
        nextPos.move(d.getRow(), d.getColumn());
        Position doubleNextPos = new Position(nextPos);
        doubleNextPos.move(d.getRow(), d.getColumn());
        conditionsMoveChecker(nextPos, doubleNextPos, d);
        checkOver();
        return b;
    }
    
    public void conditionsMoveChecker(Position nextPos, Position doubleNextPos, Direction d) {
        HistoryMove historyMove = new HistoryMove(new Position(posPlayer), new Position(nextPos), false, d);
        boolean b = false;
        if (canPushBox(nextPos, doubleNextPos)) {
            dungeon.changeToVoid(posPlayer);
            dungeon.changeToPlayer(nextPos);
            dungeon.changeToBox(doubleNextPos);
            posPlayer = new Position(nextPos);
            historyMove.setPushedBox(true);
            hlist.add(historyMove);
            if (dungeon.isStorage(nextPos)) {
                decNbStorageFulled();
            }
            if (dungeon.isStorage(doubleNextPos)) {
                incNbStorageFulled();
            }
            incNbMovement();
            b = true;
        } else if (dungeon.isVoidGround(nextPos)) {
            dungeon.changeToPlayer(nextPos);
            dungeon.changeToVoid(posPlayer);
            posPlayer = new Position(nextPos);
            hlist.add(historyMove);
            incNbMovement();
            b = true;
        } else if (dungeon.isStorage(nextPos) && dungeon.isVoid(nextPos)) {
            dungeon.changeToPlayer(nextPos);
            dungeon.changeToVoid(posPlayer);
            posPlayer = new Position(nextPos);
            hlist.add(historyMove);
            incNbMovement();
            b = true;
        }
    }
    
    public void checkOver() {
        if (isOver()) {
            controller.isOver();
            nextLevel();
            setChanged();
            notifyObservers();
        }
    }

    /**
     * Allow to undo a action
     */
    public void undo() {
        if (hlist.size() > 0) {
            hlist.remove(hlist.size() - 1);
        }
        _undoManager.undo();
    }

    /**
     * Allow to redo a action
     */
    public void redo() {
        _undoManager.redo();
    }

    /**
     * allow to back to the previous level
     *
     * @return true if done , false if not
     */
    public boolean previousLevel() {
        if (dungeon.getCurrentLevel() > 0) {
            dungeon.DungeonLoader(dungeon.getCurrentLevel() - 1);
            posPlayer = dungeon.playerFinder();
            _undoManager = new UndoManager();
            clearInfo();
            nbStorageSlot = dungeon.StorageFinder();
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Allow to play the next Level
     *
     * @return true if done, false if not
     */
    public boolean nextLevel() {
        if (dungeon.getCurrentLevel() < dungeon.getNbLevel()) {
            dungeon.DungeonLoader(dungeon.getCurrentLevel() + 1);
            posPlayer = dungeon.playerFinder();
            _undoManager = new UndoManager();
            clearInfo();
            nbStorageSlot = dungeon.StorageFinder();
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Restart the current level
     */
    public void restart() {
        dungeon.restartLevel();
        _undoManager = new UndoManager();
        posPlayer = dungeon.playerFinder();
        clearInfo();
    }

    /**
     * Allow to clear nbMovement nBStorageFull and the historyList
     */
    public void clearInfo() {
        nbMovement = 0;
        nbStorageFull = 0;
        hlist.clear();
        setChanged();
        notifyObservers();
    }

    /**
     * set nb movement to int passed in parameter
     *
     * @param nbMovement the int that will be copied
     */
    public void setNbMovement(int nbMovement) {
        this.nbMovement = nbMovement;
        setChanged();
        notifyObservers();
    }

    /**
     * set nb Storage to int passed in parameter
     *
     * @param nbStorageFull the int that will be copied
     */
    public void setNbStorageFull(int nbStorageFull) {
        this.nbStorageFull = nbStorageFull;
        setChanged();
        notifyObservers();
    }

    /**
     * set the position of the Player
     *
     * @param pos the position where the player will be
     */
    public void setPosPlayer(Position pos) {
        posPlayer = new Position(pos);
    }

    /**
     * Increment of 1 nbStorageFull
     */
    public void incNbStorageFulled() {
        nbStorageFull++;
        setChanged();
        notifyObservers();
    }

    /**
     * Increment of 1 nbMovement
     */
    public void incNbMovement() {
        nbMovement++;
        setChanged();
        notifyObservers();
    }

    /**
     * Decrement by 1 nbMovement
     */
    public void decNbMovement() {
        if (nbMovement > 0) {
            nbMovement--;
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Decrement by 1 nbStorageFull
     */
    public void decNbStorageFulled() {
        if (nbStorageFull > 0) {
            nbStorageFull--;
            setChanged();
            notifyObservers();
        }
    }

    /**
     * get the dungeons
     *
     * @return Dungeon
     */
    public Dungeon getDungeons() {
        return dungeon;
    }

    /**
     * get the list of historyMove
     *
     * @return hlist
     */
    public ObservableList<HistoryMove> getHlist() {
        return hlist;
    }

    /**
     * get the number of move done
     *
     * @return integer
     */
    public int getNbMovement() {
        return nbMovement;
    }

    /**
     * get the number of slot storage
     *
     * @return integer
     */
    public int getNbStorage() {
        return nbStorageSlot;
    }

    /**
     * get the number of storage full
     *
     * @return Integer
     */
    public int getNbStorageFull() {
        return nbStorageFull;
    }

    /**
     * get the current position of the player
     *
     * @return a position
     */
    public Position getPosPlayer() {
        return posPlayer;
    }

    /**
     * get the plate of the Dungeons
     *
     * @return a arrays of arrays of Square
     */
    public Square[][] getPlate() {
        return dungeon.getPlate();
    }

    /**
     * get the current level of dungeons
     *
     * @return a int
     */
    public int getCurrentLevel() {
        return dungeon.getCurrentLevel();
    }

    /**
     * check if a Position isInside the Dungeons
     *
     * @param p the position p
     * @return true or false
     */
    public boolean isInside(Position p) {
        return dungeon.isInside(p);
    }

    /**
     * Check if the Player can push the box
     *
     * @param p1 the Position front of the player
     * @param p2 the Position front of front of the player
     * @return true or false
     */
    public boolean canPushBox(Position p1, Position p2) {
        return dungeon.isBox(p1)
                && (dungeon.isVoidGround(p2)
                || (dungeon.isStorage(p2) && dungeon.isVoid(p2)));
    }

    /**
     * check if dungeons is over
     *
     * @return true or false
     */
    public boolean isOver() {
        return nbStorageSlot == nbStorageFull;
    }
}
