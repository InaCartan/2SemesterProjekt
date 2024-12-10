package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TøndePane extends GridPane {

    private Controller controller;
    private final TextField txfMedarbejderNavn = new TextField();
    private final TextField txfStartDato = new TextField();
    private final TextField txfSlutDato = new TextField();
    private final TextField txfAntalLiter= new TextField();
    private final TextField txfKornSort = new TextField();
    private final TextField txfMaltBatch = new TextField();
    private final TextField txfMængde = new TextField();

    public TøndePane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // søjle & række
        Label lblMedarbejderNavn = new Label("tønde1");
        this.add(lblMedarbejderNavn, 0, 2);
        this.add(txfMedarbejderNavn, 2, 2);

    }


    public void updateControls() {
    }
}
