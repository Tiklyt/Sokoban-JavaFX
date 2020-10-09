package esi.g52816.model;

/**
 * representing a position in X Y board
 *
 * @author bilal
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of the Position class for creating the Position of a Square
     *
     * @param x deltaX
     * @param y deltaY
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor of copy
     *
     * @param copy the copy that will be "copied"
     */
    public Position(Position copy) {
        this.x = copy.getX();
        this.y = copy.getY();
    }

    /**
     * get the pos X
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * get the pos Y
     *
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Move in a delta X and delta Y
     *
     * @param dx dx
     * @param dy dy
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }

}
