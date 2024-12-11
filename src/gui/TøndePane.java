package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TøndePane extends GridPane {

    private Controller controller;
    private final TextField txftøndeId = new TextField();
    private final TextField txfstørrelse = new TextField();
    private final TextField txftidligerIndhold = new TextField();
    private final TextField txflager = new TextField();
    private final TextField txfmængder = new TextField();
    private final TextField txffadType = new TextField();


    private final Button btnGem = new Button("Gem");

    public TøndePane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // søjle & række
        Label lblTøndeId = new Label("ID");
        this.add(lblTøndeId, 0, 2);
        this.add(txftøndeId, 2, 2);

        Label lblStørrelse = new Label("Størrelse");
        this.add(lblStørrelse, 0, 4);
        this.add(txfstørrelse, 2, 4);


        Label lbltidligerIndhold = new Label("Tidligere indhold ");
        this.add(lbltidligerIndhold, 0, 6);
        this.add(txftidligerIndhold, 2, 6);


        Label lbllager = new Label("Lager");
        this.add(lbllager, 0, 8);
        this.add(txflager, 2, 8);


        Label lblMængder = new Label("Mængde");
        this.add(lblMængder, 0, 10);
        this.add(txfmængder, 2, 10);

        Label lblFadtype = new Label("Mængde");
        this.add(lblFadtype, 0, 12);
        this.add(txffadType, 2, 12);


        this.add(btnGem,2,14);
        btnGem.setOnAction(event -> this.gemAction());

    }

    private void gemAction() {


        int TøndeId = Integer.parseInt(txftøndeId.getText());

        int Størrelse = Integer.parseInt(txfstørrelse.getText());

        String TidligerIndhold = txftidligerIndhold.getText();

        String FadType = txffadType.getText();

        controller.opretTønde(TøndeId, Størrelse, TidligerIndhold, FadType);



        // Fjerne tekst fra tekst felterne, hvis gem knap trykkes
        clearFields(txftøndeId, txfstørrelse, txftidligerIndhold, txffadType);

    }

    public void updateControls() {


    }

    private void clearFields(TextField... fields){
        for(TextField field : fields){
            field.clear();
        }
    }

}
