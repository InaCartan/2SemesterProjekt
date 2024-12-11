package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Destillering;
import model.Mængde;
import model.Tønde;

import java.util.ArrayList;

public class PåfyldTøndePane extends GridPane {
    private Controller controller;
    private final ListView<Destillering> lvwDestilleringer = new ListView<>();
    private final ListView<Tønde> lvwTønder = new ListView<>();
    private final ListView<Mængde> lvwPåfyld = new ListView<>();


    public PåfyldTøndePane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblDestilleringer = new Label("Destilleringer");
        this.add(lblDestilleringer, 0, 0);
        this.add(lvwDestilleringer, 0, 1);

        Label lblTønder = new Label("Tønder");
        this.add(lblTønder,4,0);
        this.add(lvwTønder, 4, 1);

        Label lblPåFyld = new Label("Påfyld");
        this.add(lblPåFyld,8,0);
        this.add(lvwPåfyld, 8, 1);


    }

    public void updateControls() {
        ArrayList<Destillering> destilleringer = controller.getDestilleringer();
        lvwDestilleringer.getItems().setAll(destilleringer);

        ArrayList<Tønde> tønder = controller.getTønde();
        lvwDestilleringer.getItems().setAll(destilleringer);

    }
}
