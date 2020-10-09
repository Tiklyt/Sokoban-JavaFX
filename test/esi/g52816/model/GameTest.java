package esi.g52816.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author braro
 */
public class GameTest {
    
    @Test
    public void testGetNbMovement() {
        System.out.println("getNbMovement");
        Game game = new Game(0);
        game.move(Direction.RIGHT);
        assertEquals(1,game.getNbMovement());
    }

    @Test
    public void testGetNbStorage() {
        System.out.println("getNbStorage");
        Game game = new Game(0);
        assertEquals(1, game.getNbStorage());
    }

    @Test
    public void testGetNbStorageFull() {
        System.out.println("getNbStorageFull");
        Game game = new Game(0);
        assertEquals(0,game.getNbStorageFull());
    }

    @Test
    public void testGetPosPlayer() {
        System.out.println("getPosPlayer");
        Game game = new Game(0);
        assertEquals(new Position(1, 5), game.getPosPlayer());
    }

    @Test
    public void testGetCurrentLevel() {
        System.out.println("getCurrentLevel");
        Game game = new Game(2);
        assertEquals(2,game.getCurrentLevel());
    }

    @Test
    public void testIsInsideCornerLeft() {
        System.out.println("isInsideCornerLeft");
        Game game = new Game(0);
        assertTrue(game.isInside(new Position(0,0)));
    }
    
    @Test
    public void testIsInsideCornerRight() {
        System.out.println("isInsideCornerRight");
        Game game = new Game(0);
        assertTrue(game.isInside(new Position(0,7)));
    }
    
    @Test
    public void testIsInsideCornerDownLeft() {
        System.out.println("isInsideDownLeft");
        Game game = new Game(0);
        assertTrue(game.isInside(new Position(7,0)));
    }
    
    @Test
    public void testIsInsideCornerDownRight() {
        System.out.println("isInsideCornerDownRight");
        Game game = new Game(0);
        assertTrue(game.isInside(new Position(7,7)));
    }
    
    
    

    @Test
    public void testCanPushBox() {
    }

    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game game = new Game(0);
        game.setNbStorageFull(3);
        assertEquals(game.getNbStorageFull(), 3);
    }

    @Test
    public void testIsNotOver() {
        System.out.println("isNotOver");
        Game game = new Game(0);
        assertFalse(game.isOver());
    }

}
