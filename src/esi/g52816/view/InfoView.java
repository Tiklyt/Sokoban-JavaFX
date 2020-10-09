package esi.g52816.view;

import esi.g52816.model.Game;
import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * This class represent a VBox who manage the view of the characteristics games
 * and observe the observable game and update when ever the game change.
 *
 * @author braro
 */
public class InfoView extends VBox implements Observer {

    private final Game game;
    private final Label nbMovement;
    private final Label nbStorage;
    private final Label nbStorageFull;
    private final Label currentLevel;

    /**
     * Create the info view class who observe the observable game
     * https://www.geeksforgeeks.org/inheritance-in-java/
     *
     * @param obs the game
     */
    public InfoView(Observable obs) {
        this.game = (Game) obs;
        this.nbMovement = new Label("-");
        this.nbMovement.setTextFill(Color.WHITE);
        nbMovement.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 40));
        this.nbStorage = new Label("-");
        this.nbStorage.setTextFill(Color.WHITE);
        this.nbStorage.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 40));
        this.nbStorageFull = new Label("-");
        this.nbStorageFull.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 40));
        this.nbStorageFull.setTextFill(Color.WHITE);
        this.currentLevel = new Label("LEVEL -");
        this.currentLevel.setTextFill(Color.WHITE);
        this.currentLevel.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 40));
        game.addObserver(this);
        initialize();
    }

    /**
     * Allow to initialize the VBOX with multiple HBox who describe the state of
     * the games
     */
    private void initialize() {
        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.setSpacing(20);
        Text nbMoves = new Text("nb of mov.");
        nbMoves.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Text nbSto = new Text("storage slot");
        nbSto.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Text nbStoFull = new Text("full storage");
        nbStoFull.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 15));
        title.getChildren().addAll(nbMoves, nbSto, nbStoFull);
        HBox value = new HBox();
        value.setAlignment(Pos.CENTER);
        value.setSpacing(70);
        value.getChildren().addAll(nbMovement, nbStorage, nbStorageFull);
        this.getChildren().addAll(title, value, currentLevel);
    }

    /**
     * When ever a observable notify us that there is change this method is
     * called to update the change in the InfoView.
     */
    @Override
    public void update(Observable o, Object arg) {
        nbMovement.setText(String.valueOf(game.getNbMovement()));
        nbStorage.setText(String.valueOf(game.getNbStorage()));
        nbStorageFull.setText(String.valueOf(game.getNbStorageFull()));
        currentLevel.setText("LEVEL " + String.valueOf(game.getCurrentLevel()));
    }

}
