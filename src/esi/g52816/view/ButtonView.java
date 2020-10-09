package esi.g52816.view;

import esi.g52816.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * This class represent the view of button with the user can interact with.The
 * user can change the level, restart the level undo or redo an action.
 *
 * @author braro
 */
public class ButtonView extends HBox {

    private Game game;
    private final Button prevLevel;
    private final Button nextLevel;
    private final Button restart;
    private final Button undo;
    private final Button redo;

    /**
     * Allow to create the button view and need the game in parameter
     *
     * @param g the game that will be passed in parameter
     */
    public ButtonView(Game g) {
        this.game = g;
        this.prevLevel = new Button("previous level");
        prevLevel.setStyle("-fx-background-color: transparent;");;
        prevLevel.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 12));
        this.nextLevel = new Button("next level");
        this.nextLevel.setStyle("-fx-background-color: transparent;");
        this.nextLevel.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 12));
        this.restart = new Button("restart");
        this.restart.setStyle("-fx-background-color: transparent;");
        this.restart.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 12));
        this.undo = new Button("undo");
        this.undo.setStyle("-fx-background-color: transparent;");
        this.undo.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 12));
        this.redo = new Button("redo");
        this.redo.setStyle("-fx-background-color: transparent;");
        this.redo.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 12));
        initialize();
        initializeEvent();
    }

    /**
     * Allow to initialize the HBox for adding buttons
     */
    private void initialize() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        getChildren().addAll(prevLevel, nextLevel, restart, undo, redo);
    }

    /**
     * Allow to handle some events when ever user click on one of these button
     */
    private void initializeEvent() {
        prevLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.previousLevel();
                System.out.println("CurrentLevel :" + game.getCurrentLevel());
            }
        });
        nextLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.nextLevel();
                System.out.println("CurrentLevel :" + game.getCurrentLevel());
            }
        });
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.restart();
            }
        });
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.undo();
            }
        });
        redo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.redo();
            }
        });
    }
}
