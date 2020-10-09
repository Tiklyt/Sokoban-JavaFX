package esi.g52816.model;

import java.util.Observable;

/**
 * class representing a Square of the Dungeons
 *
 * @author bilal
 */
public class Square extends Observable {

    private SquareType typeSquare;
    private EntityType typeEntity;

    /**
     * Create a default Square with a ground SquareType and a void typeEntity
     */
    public Square() {
        this.typeSquare = SquareType.GROUND;
        this.typeEntity = EntityType.VOID;
    }

    /**
     * Constructor allowing to do defensive copy with another Square
     *
     * @param square the square that will be copied
     */
    public Square(Square square) {
        this.typeSquare = square.typeSquare;
        this.typeEntity = square.typeEntity;
    }

    public Square(SquareType typeSquare, EntityType typeEntity) {
        this.typeSquare = typeSquare;
        this.typeEntity = typeEntity;
    }

    /**
     * Allow to get entity type from the class
     *
     * @return the EntityType
     */
    public EntityType getTypeEntity() {
        return typeEntity;
    }

    /**
     * Allow to get the type Square from the class
     *
     * @return the Square Type
     */
    public SquareType getTypeSquare() {
        return typeSquare;
    }

    /**
     * check if the square is a wall
     *
     * @return true or false
     */
    public boolean isWall() {
        return typeSquare == SquareType.WALL;
    }

    /**
     * check if the square contains a box
     *
     * @return true or false
     */
    public boolean isBox() {
        return typeEntity == EntityType.BOX;
    }

    /**
     * check if the square contains the Players
     *
     * @return true or false
     */
    public boolean isPlayer() {
        return typeEntity == EntityType.PLAYER;
    }

    /**
     * check if the square is void and Ground
     *
     * @return
     */
    public boolean isVoidGround() {
        return typeEntity == EntityType.VOID && typeSquare == SquareType.GROUND;
    }

    /**
     * Check if the entityType is Void
     *
     * @return true or false
     */
    public boolean isVoid() {
        return typeEntity == EntityType.VOID;
    }

    /**
     * Check if the typeSquare is a ground
     *
     * @return true or false
     */
    public boolean isGround() {
        return typeSquare == SquareType.GROUND;
    }

    /**
     * Check if the square is a Storage
     *
     * @return true or false
     */
    public boolean isStorage() {
        return typeSquare == SquareType.STORAGE;
    }

    /**
     * Allow to change the type entity to the new Entity type received in
     * parameter
     *
     * @param typeEntity the entity type that will be copied.
     */
    public void setTypeEntity(EntityType typeEntity) {
        this.typeEntity = typeEntity;
        setChanged();
        notifyObservers();
    }

    /**
     * Allow to change the type square to the new Square type receive din
     * parameter
     *
     * @param typeSquare
     */
    public void setTypeSquare(SquareType typeSquare) {
        this.typeSquare = typeSquare;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a Box
     */
    public void changeToBox() {
        typeEntity = EntityType.BOX;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a player
     */
    public void changeToPlayer() {
        typeEntity = EntityType.PLAYER;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a void
     */
    public void changeToVoid() {
        typeEntity = EntityType.VOID;
        setChanged();
        notifyObservers();
    }

    public void changeToGround() {
        typeSquare = SquareType.GROUND;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a void Ground
     */
    public void changeToVoidGround() {
        typeEntity = EntityType.VOID;
        typeSquare = SquareType.GROUND;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a Wall
     */
    public void changeToWall() {
        typeSquare = SquareType.WALL;
        typeEntity = EntityType.VOID;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to storage
     */
    public void changeToStorage() {
        typeSquare = SquareType.STORAGE;
        setChanged();
        notifyObservers();
    }
}
