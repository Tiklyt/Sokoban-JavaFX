package esi.g52816.model;

/**
 *
 * @author bilal
 */
public class Dungeon {

    private final Square[][] plate;
    private FileManager fileManager = new FileManager();
    private final int DUNGEONS_LENGTH = fileManager.getDungeonLength();
    private int currentLevel;

    /**
     * construct a Dungeon
     */
    public Dungeon() {
        fileManager = new FileManager();
        plate = new Square[DUNGEONS_LENGTH][DUNGEONS_LENGTH];
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                plate[i][j] = new Square();
            }
        }
    }

    /**
     * load a Dungeon in the game
     *
     * @param level the level number that will be played
     */
    public void DungeonLoader(int level) {
        currentLevel = level;
        Square[][] copy = fileManager.levelLoader(level);
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                plate[i][j].setTypeEntity(copy[i][j].getTypeEntity());
                plate[i][j].setTypeSquare(copy[i][j].getTypeSquare());
            }
        }
    }

    /**
     * restart a level
     */
    public void restartLevel() {
        DungeonLoader(currentLevel);
    }

    public int StorageFinder() {
        int counter = 0;
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[0].length; j++) {
                if (plate[i][j].isStorage()) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * find the Position of the player
     *
     * @return true or false
     */
    public Position playerFinder() {
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                if (plate[i][j].isPlayer()) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    /**
     * get the current level of the Dungeons
     *
     * @return a int
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * get the plate of the game
     *
     * @return a arrays of arrays of Square
     */
    public Square[][] getPlate() { //@srv JAMAIS retourner un attribut de type tableau ou List (encapsulation).
        return plate;
    }

    /**
     * get the current number level
     *
     * @return a int
     */
    public int getNbLevel() {
        return fileManager.getNbLevel();
    }

    /**
     * Check if a Position is Inside the Dungeons
     *
     * @param pos the position
     * @return true or false
     */
    public boolean isInside(Position pos) {
        return pos.getX() >= 0 && pos.getX() < DUNGEONS_LENGTH
                && pos.getY() >= 0 && pos.getY() < DUNGEONS_LENGTH;
    }

    /**
     * Check if in a specific position in the Dungeon is a Wall
     *
     * @param p the position
     * @return true or false
     */
    public boolean isWall(Position p) {
        return plate[p.getX()][p.getY()].isWall();
    }

    /**
     * Check if in a specific position in the Dungeon is a Box
     *
     * @param p the position
     * @return true or false
     */
    public boolean isBox(Position p) {
        return plate[p.getX()][p.getY()].isBox();
    }

    /**
     * Check if in a specific position in the Dungeon is a void ground
     *
     * @param p the Position
     * @return true or false
     */
    public boolean isVoidGround(Position p) {
        return plate[p.getX()][p.getY()].isVoidGround();
    }

    /**
     * Check if in a specific position in the Dungeon is a Storage
     *
     * @param p
     * @return
     */
    public boolean isStorage(Position p) {
        return plate[p.getX()][p.getY()].isStorage();
    }

    public boolean isVoid(Position p) {
        return plate[p.getX()][p.getY()].isVoid();
    }

    /**
     * Change in a specific position to Box
     *
     * @param p the position in the Dungeon
     */
    public void changeToBox(Position p) {
        plate[p.getX()][p.getY()].changeToBox();
    }

    /**
     * Change in a specific position to Player
     *
     * @param p the position in the Dungeon
     */
    public void changeToPlayer(Position p) {
        plate[p.getX()][p.getY()].changeToPlayer();
    }

    /**
     * Change in a specific position to void ground
     *
     * @param p the position in the Dungeon
     */
    public void changeToVoidGround(Position p) {
        plate[p.getX()][p.getY()].changeToVoidGround();
    }

    /**
     * Change in a specific position to Wall
     *
     * @param p the position in the Dungeon
     */
    public void changeToWall(Position p) {
        plate[p.getX()][p.getY()].changeToWall();
    }

    /**
     * Change in a specific position to void
     *
     * @param p the position in the Dungeon
     */
    public void changeToVoid(Position p) {
        plate[p.getX()][p.getY()].changeToVoid();
    }

}
