package esi.g52816.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class PositionTest {
    
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Position instance = new Position(67, 42);
        int expResult = 67;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Position instance = new Position(34, -5);
        int expResult = -5;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    @Test
    public void equalsTrueMySelf() {
        System.out.println("equalsTrueMySelf");
        Position position1 = new Position(-4, 7);
        assertTrue(position1.equals(position1));
        assertTrue(position1.hashCode() == position1.hashCode());
    }

    @Test
    public void equalsTrue() {
        System.out.println("equalsTrue");
        Position position1 = new Position(-4, 7);
        Position position2 = new Position(-4, 7);
        assertTrue(position1.equals(position2));
        assertTrue(position1.hashCode() == position2.hashCode());
    }

    @Test
    public void equalsFalseDifferentRow() {
        System.out.println("equalsFalseDifferentRow");
        Position position1 = new Position(-4, 7);
        Position position2 = new Position(8, 7);
        assertFalse(position1.equals(position2));
    }

    @Test
    public void equalsFalseDifferentColumn() {
        System.out.println("equalsFalseDifferentColumn");
        Position position1 = new Position(2, 7);
        Position position2 = new Position(2, 5);
        assertFalse(position1.equals(position2));
    }

    @Test
    public void equalsFalseOtherObject() {
        System.out.println("equalsFalseOtherObject");
        Position position1 = new Position(2, 96);
        String position2 = "abcd";
        assertFalse(position1.equals(position2));
    }

    @Test
    public void equalsFalseNull() {
        System.out.println("equalsFalseNull");
        Position position1 = new Position(2, 96);
        assertFalse(position1.equals(null));
    }
    
    @Test
    public void TestNextUP(){
        System.out.println("TestNextUP");
        Position p = new Position(2, 1);
        Position expResult = new Position(1, 1);
        p.move(Direction.UP.getRow(), Direction.UP.getColumn());
        assertEquals(expResult, p);
    }
    
    @Test
    public void TestNextDOWN(){
        System.out.println("TestNextDOWN");
        Position p = new Position(2, 1);
        Position expResult = new Position(3, 1);
        p.move(Direction.DOWN.getRow(), Direction.DOWN.getColumn());
        assertEquals(expResult, p);
    }
    
    
    @Test
    public void TestNextLEFT(){
        System.out.println("TestNextLEFT");
        Position p = new Position(2, 1);
        Position expResult = new Position(2, 0);
        p.move(Direction.LEFT.getRow(),Direction.LEFT.getColumn());
        assertEquals(expResult, p);
    }
    
    @Test
    public void TestNextRIGHT(){
        System.out.println("TestNextRIGHT");
        Position p = new Position(2, 1);
        Position expResult = new Position(2, 2);
        p.move(Direction.RIGHT.getRow(),Direction.RIGHT.getColumn());
        assertEquals(expResult, p);
    }

}
