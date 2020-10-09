package esi.g52816.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bilal
 */
public class DungeonTest {

    @Test
    public void testPlayerFinder() {
        System.out.println("PlayerFinder");
        Dungeon d = new Dungeon();
        d.DungeonLoader(0);
        Position posPlayer = new Position(1, 5);
        Position exp = d.playerFinder();
        assertEquals(posPlayer, exp);
    }

    @Test
    public void testGetCurrentLevel() {
        System.out.println("GetCurrentLevel");
        Dungeon d = new Dungeon();
        d.DungeonLoader(0);
        assertEquals(0, d.getCurrentLevel());
    }

    @Test
    public void testGetNbLevel() {
        System.out.println("GetNbLevel");
        Dungeon d = new Dungeon();
        assertEquals(23, d.getNbLevel());
    }

    @Test
    public void testIsInsideWhenCornerUpLeft() {
        System.out.println("testIsInsideWhenCornerUpLeft");
        Position position = new Position(0, 0);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerUpRight() {
        System.out.println("testIsInsideWhenCornerUpRight");
        Position position = new Position(0, 3);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownleft() {
        System.out.println("testIsInsideWhenCornerDownleft");
        Position position = new Position(4, 0);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownRight() {
        System.out.println("testIsInsideWhenCornerDownRight");
        Position position = new Position(4, 3);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryUp() {
        System.out.println("testIsInsideWhenBoundaryUp");
        Position position = new Position(0, 1);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryDown() {
        System.out.println("testIsInsideWhenBoundaryDown");
        Position position = new Position(4, 2);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryLeft() {
        System.out.println("testIsInsideWhenBoundaryLeft");
        Position position = new Position(1, 0);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryRight() {
        System.out.println("testIsInsideWhenBoundaryRight");
        Position position = new Position(3, 3);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);

        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryUp() {
        System.out.println("testIsInsideWhenOutsideBoundaryUp");
        Position position = new Position(-1, 1);
        Dungeon instance = new Dungeon();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryDown() {
        System.out.println("testIsInsideWhenOutsideBoundaryDown");
        Position position = new Position(11, 2);
        Dungeon instance = new Dungeon();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryLeft() {
        System.out.println("testIsInsideWhenOutsideBoundaryLeft");
        Position position = new Position(1, -1);
        Dungeon instance = new Dungeon();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryRight() {
        System.out.println("testIsInsideWhenOutsideBoundaryRight");
        Position position = new Position(10, 8);
        Dungeon instance = new Dungeon();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenInside() {
        System.out.println("testIsInsideWhenInside");
        Position position = new Position(2, 1);
        Dungeon instance = new Dungeon();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testDungeonLoader() {
        System.out.println("DungeonLoader");
        Dungeon dungeon = new Dungeon();
        dungeon.DungeonLoader(5);
        assertEquals(5, dungeon.getCurrentLevel());
    }

    @Test
    public void testStorageFinder() {
        System.out.println("StorageFinder");
        Dungeon dungeon = new Dungeon();
        dungeon.DungeonLoader(0);
        assertEquals(1, dungeon.StorageFinder());
    }
}
