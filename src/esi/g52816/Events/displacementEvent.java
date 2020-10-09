package esi.g52816.Events;

import esi.g52816.model.Direction;
import esi.g52816.model.Game;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Event handler manage W S A D keyboard key to allow to move the player
 *
 * @author braro
 */
public class displacementEvent implements EventHandler<KeyEvent> {

    private final Game g;

    /**
     * Create a displacementEvent Handler
     *
     * @param g the game
     */
    public displacementEvent(Game g) {
        this.g = g;
    }

    /**
     * Handle the event when ever the user press W (UP) S (DOWN) A (LEFT) D
     * (RIGHT) I have a QWERTY keyboard ^^
     *
     * @param t the event that we can recover data like which key he pressed
     */
    @Override
    public void handle(KeyEvent t) {

        switch (t.getCode()) {
            case W:
                g.moveExecute(Direction.UP);
                break;
            case S:
                g.moveExecute(Direction.DOWN);
                break;
            case A:
                g.moveExecute(Direction.LEFT);
                break;
            case D:
                g.moveExecute(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

}
