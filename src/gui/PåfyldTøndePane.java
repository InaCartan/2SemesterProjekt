package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Destillering;

import java.util.ArrayList;

public class PåfyldTøndePane extends GridPane {
    private Controller controller;
    private final ListView<Destillering> lvwDestilleringer = new ListView<>();

    public PåfyldTøndePane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblDestilleringer = new Label("Destilleringer");
        this.add(lblDestilleringer, 0, 0);
        this.add(lvwDestilleringer, 0, 1);


    }

    public void updateControls() {
        ArrayList<Destillering> destilleringer = controller.getDestilleringer();
        lvwDestilleringer.getItems().setAll(destilleringer);
    }
}
