package esi.g52816.view;

import esi.g52816.model.Dungeon;
import esi.g52816.model.Game;
import esi.g52816.model.Position;
import javafx.scene.layout.GridPane;

/**
 * this class represent the plate of the game that why it's a "Grid" Pane this
 * class dont have to observe the game because the SquareView already do that
 * for us so when ever some change will be done on the game the DungeonView will
 * have nothing to update
 *
 * @author braro
 */
public class DungeonView extends GridPane {

    private Dungeon d;
    private Game g;

    /**
     * create the dungeonView who need the dungeon and the game
     *
     * @param d the dungeon
     * @param g the game
     */
    public DungeonView(Dungeon d, Game g) {
        this.d = d;
        this.g = g;
        for (int i = 0; i < d.getPlate().length; i++) {
            for (int j = 0; j < d.getPlate()[0].length; j++) {
                Position position = new Position(i, j);
                SquareView square = new SquareView(d.getPlate()[i][j]);
                this.add(square, j, i);
            }
        }
    }

}
