package esi.g52816.view;

import esi.g52816.model.Game;
import java.util.Observable;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represent the total view of the application
 *
 * @author bilal
 */
public class View extends HBox {

    private final DungeonView dungeonView;
    private final HistoryView historyView;
    private final InfoView infoView;
    private final ButtonView buttonView;
    private final Game game;

    /**
     * Create the view who take game in parameter
     *
     * @param obs the game
     */
    public View(Observable obs) {
        this.game = (Game) obs;
        this.dungeonView = new DungeonView(game.getDungeons(), game);
        this.infoView = new InfoView(game);
        this.historyView = new HistoryView(game);
        this.buttonView = new ButtonView(game);
        initialize();
    }

    /**
     * Allow to initialize the general View
     */
    private void initialize() {
        historyView.autosize();
        setPadding(new Insets(30));
        setSpacing(50);
        VBox subRoot = new VBox();
        subRoot.setSpacing(15);
        subRoot.getChildren().addAll(dungeonView, buttonView, infoView);
        this.getChildren().addAll(subRoot, historyView);
    }
}
