package esi.g52816.model;

/**
 * Represent a class who store data from Game
 *
 * @author braro
 */
public class HistoryMove {

    private String startPosition;
    private String endPosition;
    private String direction;
    private String pushedBox;

    /**
     * Allow to create a HistoryMove
     *
     * @param stPosition the Start Position that will be saved
     * @param edPosition the end Position that will be saved
     * @param pushedBox if the players pushed the box
     * @param d the direction where the players move
     */
    public HistoryMove(Position stPosition, Position edPosition, boolean pushedBox, Direction d) {

        this.startPosition = stPosition.toString();
        this.endPosition = edPosition.toString();
        this.pushedBox = String.valueOf(pushedBox);
        this.direction = d.toString();
    }

    /**
     * Set the String pushed box
     *
     * @param pushedBox
     */
    public void setPushedBox(boolean pushedBox) {
        this.pushedBox = String.valueOf(pushedBox);
    }

    /**
     * get the start Position
     *
     * @return Position converted to String
     */
    public String getStartPosition() {
        return startPosition;
    }

    /**
     * get the end Position
     *
     * @return Position converted to String
     */
    public String getEndPosition() {
        return endPosition;
    }

    /**
     * get the pushed box
     *
     * @return converted boolean to String
     */
    public String getPushedBox() {
        return pushedBox;
    }

    /**
     * get the direction
     *
     * @return converted direction to String
     */
    public String getDirection() {
        return direction;
    }

}
