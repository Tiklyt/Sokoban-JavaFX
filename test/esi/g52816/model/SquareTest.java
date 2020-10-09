package esi.g52816.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author braro
 */
public class SquareTest {

    @Test
    public void testGetTypeEntity() {
        System.out.println("GetTypeEntity");
        Square square = new Square(SquareType.STORAGE, EntityType.PLAYER);
        assertEquals(EntityType.PLAYER, square.getTypeEntity());
    }

    @Test
    public void testGetTypeSquare() {
        System.out.println("GetTypeSquare");
        Square square = new Square(SquareType.STORAGE, EntityType.PLAYER);
        assertEquals(SquareType.STORAGE, square.getTypeSquare());
    }

    @Test
    public void testIsWall() {
        System.out.println("IsWall");
        Square square = new Square(SquareType.WALL, EntityType.VOID);
        assertTrue(square.isWall());
    }

    @Test
    public void testIsNotWall() {
        System.out.println("IsNotWall");
        Square square = new Square(SquareType.GROUND, EntityType.VOID);
        assertFalse(square.isWall());
    }

    @Test
    public void testIsBox() {
        System.out.println("IsBox");
        Square square = new Square(SquareType.GROUND, EntityType.BOX);
        assertTrue(square.isBox());
    }

    @Test
    public void testIsNotBox() {
        System.out.println("IsNotBox");
        Square square = new Square(SquareType.GROUND, EntityType.PLAYER);
        assertFalse(square.isBox());
    }

    @Test
    public void testIsPlayer() {
        System.out.println("IsPlayer");
        Square square = new Square(SquareType.GROUND, EntityType.PLAYER);
        assertTrue(square.isPlayer());
    }

    @Test
    public void testIsNotPlayer() {
        System.out.println("IsNotPlayer");
        Square square = new Square(SquareType.GROUND, EntityType.BOX);
        assertFalse(square.isPlayer());
    }

    @Test
    public void testIsVoidGround() {
        System.out.println("isVoidGround");
        Square square = new Square(SquareType.GROUND, EntityType.VOID);
        assertTrue(square.isGround());
    }

    @Test
    public void testIsNotVoidGround() {
        System.out.println("isNotVoidGround");
        Square square = new Square(SquareType.STORAGE, EntityType.VOID);
        assertFalse(square.isGround());
    }

    @Test
    public void testIsVoid() {
        System.out.println("isVoid");
        Square square = new Square(SquareType.GROUND, EntityType.VOID);
        assertTrue(square.isVoid());
    }

    @Test
    public void testIsNotVoid() {
        System.out.println("isNotVoid");
        Square square = new Square(SquareType.GROUND, EntityType.PLAYER);
        assertFalse(square.isVoid());
    }

    @Test
    public void testIsGround() {
        System.out.println("isGround");
        Square square = new Square(SquareType.GROUND, EntityType.PLAYER);
        assertTrue(square.isGround());
    }

    @Test
    public void testIsNotGround() {
        System.out.println("isNotGround");
        Square square = new Square(SquareType.STORAGE, EntityType.PLAYER);
        assertFalse(square.isGround());
    }

    @Test
    public void testIsStorage() {
        System.out.println("isStorage");
        Square square = new Square(SquareType.STORAGE, EntityType.PLAYER);
        assertTrue(square.isStorage());
    }

    @Test
    public void testIsNotStorage() {
        System.out.println("isNotStorage");
        Square square = new Square(SquareType.GROUND, EntityType.PLAYER);
        assertFalse(square.isStorage());
    }

    @Test
    public void testSetTypeEntity() {
        System.out.println("setTypeEntity");
        Square square = new Square();
        square.setTypeEntity(EntityType.PLAYER);
        assertTrue(square.isPlayer());
    }

    @Test
    public void testSetTypeSquare() {
        System.out.println("setTypeSquare");
        Square square = new Square();
        square.setTypeSquare(SquareType.STORAGE);
        assertTrue(square.isStorage());
    }

    @Test
    public void testChangeToBox() {
        System.out.println("ChangeToBox");
        Square square = new Square();
        square.changeToBox();
        assertTrue(square.isBox());
    }

    @Test
    public void testChangeToPlayer() {
        System.out.println("ChangeToPlayer");
        Square square = new Square();
        square.changeToPlayer();
        assertTrue(square.isPlayer());
    }

    @Test
    public void testChangeToVoid() {
        System.out.println("ChangeToVoid");
        Square square = new Square();
        square.changeToVoid();
        assertTrue(square.isVoid());
    }

    @Test
    public void testChangeToGround() {
        System.out.println("ChangeToGround");
        Square square = new Square();
        square.changeToGround();
        assertTrue(square.isGround());
    }

    @Test
    public void testChangeToVoidGround() {
        System.out.println("ChangeToVoidGround");
        Square square = new Square();
        square.changeToVoidGround();
        assertTrue(square.isVoidGround());
    }

    @Test
    public void testChangeToWall() {
        System.out.println("ChangeToWall");
        Square square = new Square();
        square.changeToWall();
        assertTrue(square.isWall());
    }

    @Test
    public void testChangeToStorage() {
        System.out.println("ChangeToStorage");
        Square square = new Square();
        square.changeToStorage();
        assertTrue(square.isStorage());
    }

}
