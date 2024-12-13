package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class WhiskyPane extends GridPane {

    private Controller controller;
    private final TextField txfproduktID = new TextField();
    private final TextField txftype = new TextField();
    private final TextField txfalkoholProcent = new TextField();
    private final TextField txffortyndet = new TextField();
    private final TextField txfantalFlasker = new TextField();

    private final Button btnGem = new Button("Gem");

    public WhiskyPane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblProduktId = new Label("ProdukID");
        this.add(lblProduktId, 0, 2);
        this.add(txfproduktID, 2, 2);

        Label lbltype = new Label("Type");
        this.add(lbltype, 0, 4);
        this.add(txftype, 2, 4);

        Label lblFortyndet = new Label("Fortyndet");
        this.add(lblFortyndet, 0, 6);
        this.add(txffortyndet, 2, 6);

        Label lblalkoholProcent = new Label("Alkohol procent");
        this.add(lblalkoholProcent, 0, 8);
        this.add(txfalkoholProcent, 2, 8);

        Label lblantalFlasker = new Label("Antallet af Flasker");
        this.add(lblantalFlasker, 0, 10);
        this.add(txfantalFlasker, 2, 10);

        this.add(btnGem, 2, 12);
        btnGem.setOnAction(event -> this.gemAction());


    }

    private void gemAction() {

        int produktId = Integer.parseInt(txffortyndet.getText());

        String type = txftype.getText();

        double alkoholProcent = Integer.parseInt(txfalkoholProcent.getText());

        int fortyndet = Integer.parseInt(txffortyndet.getText());

        int antalFlasker = Integer.parseInt(txfantalFlasker.getText());


        controller.opretWhisky(produktId, type, alkoholProcent, fortyndet, antalFlasker);

        // Fjerne tekst fra tekst felterne, hvis gem knap trykkes
        clearFields(txfproduktID, txftype, txfalkoholProcent, txffortyndet, txfantalFlasker);


    }

    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    public void updateControls() {


    }
}
