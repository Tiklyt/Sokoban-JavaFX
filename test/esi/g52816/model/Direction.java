package esi.g52816.model;

/**
 *
 * @author bilal
 */
public enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    private final int row;
    private final int column;

    /**
     * Constructor who initialize the row and the column
     *
     * @param row row Integer parameter
     * @param column column Integer parameter
     */
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
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

}
