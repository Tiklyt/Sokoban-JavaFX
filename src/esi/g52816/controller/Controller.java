package esi.g52816.controller;

import esi.g52816.Events.displacementEvent;
import esi.g52816.model.Game;
import esi.g52816.view.View;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Controller of the application and allow to launch the application
 *
 * @author bilal
 */
public class Controller extends Application {

    private final Game g = new Game(0, this);
    private final View v = new View(g);
    private MediaPlayer mediaPlayer;

    private static final String ICON = "https://image.winudf.com/v2/image1/Y29tLm1vZXJzY2h"
            + "saS5taW5pc29rb2Jhbl9pY29uXzE1NTMxNDUxMzhfMDcy/icon.png?w=170&fakeurl=1";
    private static final String BACKGROUND = "https://i.pinimg.com/originals/b8/"
            + "2f/28/b82f28a7e9c8fcb3868d3d94652c107c.gif";

    /**
     * Allow to start the application
     */
    @Override
    public void start(Stage stage) {
        initializeMusic();
        stage.getIcons().add(new Image(ICON));
        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND, 900, 630, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        v.setBackground(new Background(background));
        Scene scene = new Scene(v, 900, 630, Color.BLACK);
        stage.setResizable(false);
        scene.setOnKeyPressed(new displacementEvent(g));
        stage.setTitle("SOKOBAN");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Alert box show up when ever the user finished a level.
     */
    public void isOver() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("STATUS");
        alert.setHeaderText(null);
        alert.setContentText("YOU WON !, YOU WILL PLAY THE NEXT LEVEL !");
        alert.showAndWait();
    }

    /**
     * Initialize the music during the party
     */
    private void initializeMusic() {
        Media sound = new Media(new File("src\\musicsokoban.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.15);
        mediaPlayer.play();
    }

    /**
     * main...
     */
    public static void main(String[] args) {
        launch(args);
    }

}
