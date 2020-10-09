package esi.g52816.model;

/**
 * represent a command that store data of the game
 *
 * @author bilal
 */
public class MoveCommand implements Command {

    private final Game game;
    private final Direction direction;
    private final Position posPlayer;
    private final Square currentSquare;
    private Square nextSquare;
    private Square doubleNextSquare;
    private int nbMoves = 0;
    private int nbSquareFilled = 0;

    /**
     * Allow to create a Move Command The class store information about the game
     * like number of moves, of squareFilled, etc...
     *
     * @param game the game where the move will be applied
     * @param direction the direction where the move will be done
     */
    public MoveCommand(Game game, Direction direction) {
        this.game = game;
        this.posPlayer = new Position(game.getPosPlayer());
        this.direction = direction;
        Position nextPos = new Position(posPlayer);
        nextPos.move(direction.getRow(), direction.getColumn());

        Position doubleNextPos = new Position(nextPos);
        doubleNextPos.move(direction.getRow(), direction.getColumn());

        nbMoves = game.getNbMovement();
        nbSquareFilled = game.getNbStorageFull();
        currentSquare = new Square(game.getPlate()[posPlayer.getX()][posPlayer.getY()]);

        if (game.isInside(nextPos)) {
            nextSquare = new Square(game.getPlate()[nextPos.getX()][nextPos.getY()]);
        }
        if (game.isInside(doubleNextPos)) {
            doubleNextSquare = new Square(game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()]);
        }

    }

    /**
     * Check the Position of the next's Pos is inside the Board
     *
     * @return true or false
     */
    public boolean isInside() {
        Position NextPos = new Position(posPlayer);
        NextPos.move(direction.getRow(), direction.getColumn());

        Position doubleNextPos = new Position(NextPos);
        doubleNextPos.move(direction.getRow(), direction.getColumn());
        return game.isInside(NextPos) && game.isInside(doubleNextPos);
    }

    /**
     * Execute the command
     */
    @Override
    public void execute() {
        game.move(direction);
    }

    /**
     * unexecute the command , we have the old data to "rollback" to the
     * previous scene , so the function restore The square characteristics and
     * number of movements done and number of filled Storage
     */
    @Override
    public void unexecute() {

        Position currentPos = new Position(posPlayer);
        Position NextPos = new Position(posPlayer);
        NextPos.move(direction.getRow(), direction.getColumn());
        Position doubleNextPos = new Position(NextPos);
        doubleNextPos.move(direction.getRow(), direction.getColumn());

        game.setNbStorageFull(nbSquareFilled);
        game.setNbMovement(nbMoves);

        if (game.isInside(NextPos) && game.isInside(doubleNextPos)) {
            rollbackAction(currentPos, NextPos, doubleNextPos);
        }

    }

    /**
     * check if the command can be executed
     *
     * @return
     */
    @Override
    public boolean canExecute() {
        return isInside();
    }

    private void rollbackAction(Position currentPos, Position NextPos, Position doubleNextPos) {
        game.getPlate()[posPlayer.getX()][posPlayer.getY()].setTypeEntity(currentSquare.getTypeEntity());
        game.getPlate()[posPlayer.getX()][posPlayer.getY()].setTypeSquare(currentSquare.getTypeSquare());

        game.getPlate()[NextPos.getX()][NextPos.getY()].setTypeEntity(nextSquare.getTypeEntity());
        game.getPlate()[NextPos.getX()][NextPos.getY()].setTypeSquare(nextSquare.getTypeSquare());

        game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()].setTypeEntity(doubleNextSquare.getTypeEntity());
        game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()].setTypeSquare(doubleNextSquare.getTypeSquare());

        game.setPosPlayer(new Position(posPlayer));
    }
}
