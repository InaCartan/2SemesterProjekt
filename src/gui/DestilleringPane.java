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

        Label lblSlutDato = new Label("SlutDato");
        this.add(lblSlutDato, 0, 6);
        this.add(txfSlutDato, 2, 6);

        Label lblAntalLiter = new Label("AntalLiter");
        this.add(lblAntalLiter, 0, 8);
        this.add(txfAntalLiter, 2, 8);

        Label lblKornSort = new Label("Kornsort");
        this.add(lblKornSort, 0, 10);
        this.add(txfKornSort, 2, 10);

        Label lblMaltBatch = new Label("MaltBatch");
        this.add(lblMaltBatch, 0, 12);
        this.add(txfMaltBatch, 2, 12);


        Label lblMængde = new Label("Mængde");
        this.add(lblMængde, 0, 14);
        this.add(txfMængde, 2, 14);


        this.add(btnGem,2,17);
        btnGem.setOnAction(event -> this.gemAction());



        }

    private void gemAction() {

        String medarbejderNavn = txfMedarbejderNavn.getText();
        controller.opretDestillering(medarbejderNavn);

        String startDato = txfStartDato.getText();
        controller.opretDestillering(startDato);

        String slutDato = txfSlutDato.getText();
        controller.opretDestillering(slutDato);

        String antaLiter = txfAntalLiter.getText();
        controller.opretDestillering(antaLiter);

        String kornSort = txfKornSort.getText();
        controller.opretDestillering(kornSort);

        String maltBatch = txfMaltBatch.getText();
        controller.opretDestillering(maltBatch);

        String mængde = txfMængde.getText();
        controller.opretDestillering(mængde);

        // Fjerne tekst fra tekst felterne, hvis gem knap trykkes
        txfMedarbejderNavn.clear();
        txfStartDato.clear();
        txfSlutDato.clear();
        txfAntalLiter.clear();
        txfKornSort.clear();
        txfMaltBatch.clear();
        txfMængde.clear();

    }


    public void updateControls() {

    }
}
