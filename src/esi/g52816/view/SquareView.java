package esi.g52816.view;

import esi.g52816.model.Square;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Represent a the view of one Square he is observing the observable "Square",
 * when ever the Square changing is characteristics the SquareView will update.
 *
 * @author braro
 */
public class SquareView extends StackPane implements Observer {

    private static final int HEIGHT_WIDTH = 40;

    private Square square;
    private ImageView groundImage;
    private ImageView entityImage;
    private Group g;

    /**
     * Allow to create a SquareView that will observe the Square(Observable)
     * https://www.geeksforgeeks.org/inheritance-in-java/
     *
     * @param obs the observable Square
     */
    public SquareView(Observable obs) {
        this.square = (Square) obs;
        settingsFinder();
        g = new Group(groundImage, entityImage);
        fit();
        this.square.addObserver(this);
        this.getChildren().add(g);
    }

    /**
     * Allow to find all parameter of a Square like we can update the View of
     * the Square (Image)
     */
    private void settingsFinder() {
        try {
            if (square.isWall()) {
                groundImage = new ImageView(new Image(new FileInputStream("src\\image\\wallground.png")));
                entityImage = new ImageView(new Image(new FileInputStream("src\\image\\invisible.png")));
            } else if (square.isStorage()) {
                groundImage = new ImageView(new Image(new FileInputStream("src\\image\\storage.png")));
            } else if (square.isGround()) {
                groundImage = new ImageView(new Image(new FileInputStream("src\\image\\ground.png")));
            }
            if (square.isPlayer()) {
                entityImage = new ImageView(new Image(new FileInputStream("src\\image\\player.png")));
            } else if (square.isVoid()) {
                entityImage = new ImageView(new Image(new FileInputStream("src\\image\\invisible.png")));
            } else if (square.isBox()) {
                entityImage = new ImageView(new Image(new FileInputStream("src\\image\\box.png")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found !");
        }
        fit();
        g = new Group(groundImage, entityImage);
        this.getChildren().clear();
        this.getChildren().add(g);
    }

    /**
     * Allow to give a fixed HEIGHT and WIDTH for images
     */
    public void fit() {
        groundImage.setFitHeight(HEIGHT_WIDTH);
        groundImage.setFitWidth(HEIGHT_WIDTH);
        entityImage.setFitHeight(HEIGHT_WIDTH);
        entityImage.setFitWidth(HEIGHT_WIDTH);
    }

    /**
     * When ever a observable notify us that there is change this method is
     * called to update the change in the SquareView.
     */
    @Override
    public void update(Observable o, Object arg) {
        settingsFinder();
    }

}
