package esi.g52816.model;

/**
 *
 * @author bilal
 */
public enum Direction {
    UP(-1, 0, "UP"), DOWN(1, 0, "DOWN"), LEFT(0, -1, "LEFT"), RIGHT(0, 1, "RIGHT");

    private final String name;
    private final int row;
    private final int column;

    /**
     * Constructor who initialize the row and the column
     *
     * @param row row Integer parameter
     * @param column column Integer parameter
     */
    private Direction(int row, int column, String name) {
        this.row = row;
        this.column = column;
        this.name = name;
    }

    /**
     * Allow to get a Column
     *
     * @return integer returned
     */
    public int getColumn() {
        return column;
    }

    /**
     * Allow to get a Row
     *
     * @return integer returned
     */
    public int getRow() {
        return row;
    }

    /**
     * Allow to convert a direction to string
     *
     * @return a string corresponded to the direction
     */
    @Override
    public String toString() {
        return name;
    }

}
