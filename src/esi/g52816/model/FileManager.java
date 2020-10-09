package esi.g52816.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Allow to manage sokoban file to convert them into Java Object
 *
 * @author braro
 */
public class FileManager {

    private static final int DUNGEONS_LENGTH = 8;
    private static final char PLAYER_STORAGE = '+';
    private static final char BOX_STORAGE = '*';
    private static final char WALL_VOID = '#';
    private static final char PLAYER_GROUND = '@';
    private static final char BOX_GROUND = '$';
    private static final char STORAGE_VOID = '.';
    private static final char VOID_GROUND = ' ';

    private final String[] levels;

    /**
     * create a file manager
     */
    public FileManager() {
        String level = "";
        try {
            level = Files.readString(Paths.get("level.txt"));
        } catch (IOException ex) {
        }
        this.levels = level.split(";");
    }

    /**
     * Allow to load a specific level
     *
     * @param level the level that will be loaded
     * @return the 2D array of Square
     */
    public Square[][] levelLoader(int level) {
        Square[][] plate = new Square[DUNGEONS_LENGTH][DUNGEONS_LENGTH];
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                plate[i][j] = new Square();
            }
        }
        String toSearch = stringCleaner(levels[level]);
        int k = 0;
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                switch (toSearch.charAt(k)) {
                    case PLAYER_STORAGE: //@srv: constantes !
                        plate[i][j].changeToPlayer();
                        plate[i][j].changeToStorage();
                        break;
                    case BOX_STORAGE:
                        plate[i][j].changeToStorage();
                        plate[i][j].changeToBox();
                        break;
                    case WALL_VOID:
                        plate[i][j].changeToWall();
                        plate[i][j].changeToVoid();
                        break;
                    case PLAYER_GROUND:
                        plate[i][j].changeToPlayer();
                        plate[i][j].changeToGround();
                        break;
                    case BOX_GROUND:
                        plate[i][j].changeToBox();
                        plate[i][j].changeToGround();
                        break;
                    case STORAGE_VOID:
                        plate[i][j].changeToStorage();
                        plate[i][j].changeToVoid();
                        break;
                    case VOID_GROUND:
                        plate[i][j].changeToVoidGround();
                        break;
                    default:
                        break;
                }
                k++;
            }
        }
        return plate;
    }

    /**
     * Clean a String
     *
     * @param toClean the String that will be cleaned
     * @return new String cleaned
     */
    private String stringCleaner(String toClean) {
        String result = "";
        for (int i = 0; i < toClean.length(); i++) {
            if (toClean.charAt(i) == '+'
                    || toClean.charAt(i) == '*'
                    || toClean.charAt(i) == '#'
                    || toClean.charAt(i) == '$'
                    || toClean.charAt(i) == '.'
                    || toClean.charAt(i) == '@'
                    || toClean.charAt(i) == ' ') {
                result += toClean.charAt(i);
            }
        }
        return result;
    }

    /**
     * get the dungeons LENGTH
     *
     * @return integer
     */
    public int getDungeonLength() {
        return DUNGEONS_LENGTH;
    }

    /**
     * get the number of levels
     *
     * @return Integer
     */
    public int getNbLevel() {
        return levels.length - 1;
    }

}
