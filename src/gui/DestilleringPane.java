package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Destillering;

import java.time.LocalDate;

public class DestilleringPane extends GridPane {
    private Controller controller;
    private final TextField txfMedarbejderNavn = new TextField();
    private final TextField txfStartDato = new TextField();
    private final TextField txfSlutDato = new TextField();
    private final TextField txfAntalLiter= new TextField();
    private final TextField txfKornSort = new TextField();
    private final TextField txfMaltBatch = new TextField();
    private final TextField txfMængde = new TextField();
    private final TextField txfNewMake = new TextField();
    private final TextField txfalkoholProcent = new TextField();


    // private final TextField txfAlkoholProcent = new TextField(); ??

    private final Button btnGem = new Button("Gem");



    public DestilleringPane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // søjle & række
        Label lblMedarbejderNavn = new Label("Navn");
        this.add(lblMedarbejderNavn, 0, 2);
        this.add(txfMedarbejderNavn, 2, 2);


        Label lblStartDato = new Label("StartDato");
        this.add(lblStartDato, 0, 4);
        this.add(txfStartDato, 2, 4);
        txfStartDato.setPromptText("yy-mm-dd");

        Label lblSlutDato = new Label("SlutDato");
        this.add(lblSlutDato, 0, 6);
        this.add(txfSlutDato, 2, 6);
        txfSlutDato.setPromptText("yy-mm-dd");


        Label lblKornSort = new Label("Kornsort");
        this.add(lblKornSort, 0,8);
        this.add(txfKornSort, 2, 8);

        Label lblMaltBatch = new Label("MaltBatch");
        this.add(lblMaltBatch, 0, 10);
        this.add(txfMaltBatch, 2, 10);


        Label lblMængde = new Label("Mængde");
        this.add(lblMængde, 0, 12);
        this.add(txfMængde, 2, 12);

        Label lblnewMake = new Label("New Make");
        this.add(lblnewMake, 0, 14);
        this.add(txfNewMake, 2, 14);

        Label lblalkoholProcent = new Label("Alkohol Procent");
        this.add(lblalkoholProcent, 0, 16);
        this.add(txfalkoholProcent, 2, 16);

        this.add(btnGem,2,18);
        btnGem.setOnAction(event -> this.gemAction());

    }

    private void gemAction() {

        String medarbejderNavn = txfMedarbejderNavn.getText();

        LocalDate startDato = LocalDate.parse(txfStartDato.getText());

        LocalDate slutDato = LocalDate.parse(txfSlutDato.getText());

        String kornSort = txfKornSort.getText();

        int maltBatch = Integer.parseInt(txfMaltBatch.getText());

        int mængde = Integer.parseInt(txfMængde.getText());

        int newMake = Integer.parseInt(txfNewMake.getText());

        double alkoholProcent = Integer.parseInt(txfalkoholProcent.getText());

        controller.opretDestillering(newMake, mængde, medarbejderNavn, startDato, slutDato, kornSort, maltBatch, alkoholProcent);


        // Fjerne tekst fra tekst felterne, hvis gem knap trykkes
        clearFields(txfMedarbejderNavn, txfStartDato, txfSlutDato,
                txfAntalLiter, txfKornSort, txfMaltBatch, txfMængde, txfNewMake, txfalkoholProcent);

    }


    public void updateControls() {

    }

    // Funktionen kan tag imod 0 til mange String variable ("or a single array of them")
    //<Stackoverflow>
    private void clearFields(TextField... fields){
        for(TextField field : fields){
            field.clear();
        }
    }
}
