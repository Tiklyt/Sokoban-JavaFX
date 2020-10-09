package esi.g52816.view;

import esi.g52816.model.Game;
import esi.g52816.model.HistoryMove;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * represent a table of history of move done in the game this class observe the
 * observable game and when ever the game will be changed this class will be
 * updated
 *
 * @author braro
 */
public class HistoryView extends TableView<HistoryMove> implements Observer {

    private ObservableList<HistoryMove> historyList;
    private final Game game;

    /**
     * create the history view and recover data from the class HistoryMove and
     * print it
     *
     * @param obs
     */
    public HistoryView(Observable obs) {
        this.historyList = FXCollections.observableArrayList();
        this.game = (Game) obs;
        obs.addObserver(this);

        TableColumn<HistoryMove, String> startPos = new TableColumn<>("start pos");
        startPos.setCellValueFactory(new PropertyValueFactory<>("startPosition"));

        TableColumn<HistoryMove, String> endPos = new TableColumn<>("end pos");
        endPos.setCellValueFactory(new PropertyValueFactory<>("endPosition"));

        TableColumn<HistoryMove, String> boxPushed = new TableColumn<>("box pushed");
        boxPushed.setCellValueFactory(new PropertyValueFactory<>("pushedBox"));

        TableColumn<HistoryMove, String> direction = new TableColumn<>("direction");
        direction.setCellValueFactory(new PropertyValueFactory<>("direction"));

        this.getColumns().addAll(startPos, endPos, direction, boxPushed);
        setItems(historyList);
    }

    /**
     * When ever a observable notify us that there is change this method is
     * called to update the change in the HistoryView.
     */
    @Override
    public void update(Observable o, Object arg) {
        historyList = game.getHlist();
        setItems(historyList);
    }

}
