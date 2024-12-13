package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LagerPane extends GridPane {

    private Controller controller;
    private final TextField txflagerType = new TextField();
    private final TextField txfkapacitet = new TextField();
    private final TextField txflokation = new TextField();

    private final Button btnGem = new Button("Gem");


    public LagerPane(Controller controller) {

        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblLagerType = new Label("LagerType");
        this.add(lblLagerType, 0, 2);
        this.add(txflagerType, 2, 2);

        Label lblKapacitet = new Label("Kapacitet");
        this.add(lblKapacitet, 0, 4);
        this.add(txfkapacitet, 2, 4);


        this.add(btnGem, 2, 18);
        btnGem.setOnAction(event -> this.gemAction());

    }

    private void gemAction() {

        String lagerType = txflagerType.getText();

        int kapacitet = Integer.parseInt(txfkapacitet.getText());

        controller.opretLager(lagerType, kapacitet);


    }
}
