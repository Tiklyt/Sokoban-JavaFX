package esi.g52816.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author braro
 */
public class HistoryMoveTest {

    @Test
    public void testSetPushedBox() {
        System.out.println("SetPushedBox");
        HistoryMove historyMove = new HistoryMove(new Position(0, 0),
                new Position(0, 1), false, Direction.RIGHT);
        historyMove.setPushedBox(true);
        assertEquals(historyMove.getPushedBox(), "true");
    }

    @Test
    public void testGetStartPosition() {
        System.out.println("getStartPosition");
        HistoryMove historyMove = new HistoryMove(new Position(0, 0),
                new Position(0, 1), false, Direction.RIGHT);
        assertEquals("(0;0)", historyMove.getStartPosition());
    }

    @Test
    public void testGetEndPosition() {
        System.out.println("getEndPosition");
        HistoryMove historyMove = new HistoryMove(new Position(0, 0),
                new Position(0, 1), false, Direction.RIGHT);
        assertEquals("(0;1)", historyMove.getEndPosition());

    }

    @Test
    public void testGetPushedBox() {
        System.out.println("getPushedBox");
        HistoryMove historyMove = new HistoryMove(new Position(0, 0),
                new Position(0, 1), false, Direction.RIGHT);
        assertEquals("false", historyMove.getPushedBox());
    }

    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        HistoryMove historyMove = new HistoryMove(new Position(0, 0),
                new Position(0, 1), false, Direction.RIGHT);
        assertEquals("RIGHT", historyMove.getDirection());
    }

}
