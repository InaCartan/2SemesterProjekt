package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Destillering;
import model.Mængde;
import model.Tønde;

import javafx.beans.value.ChangeListener;
import java.util.ArrayList;

public class PåfyldTøndePane extends GridPane {
    private Controller controller;
    private final ListView<Destillering> lvwDestilleringer = new ListView<>();
    private final ListView<Tønde> lvwTønder = new ListView<>();
    private final TextArea txaPåFyld = new TextArea();
    //private final ListView<Mængde> lvwPåfyld = new ListView<>();
    private final TextField txfMængde = new TextField();
    private final TextField txfpåfyldningsDato = new TextField();


    public PåfyldTøndePane(Controller controller) {
        this.controller = controller;

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // List views
        Label lblDestilleringer = new Label("Destilleringer");
        this.add(lblDestilleringer, 0, 0);
        this.add(lvwDestilleringer, 0, 1);

        Label lblTønder = new Label("Tønder");
        this.add(lblTønder,4,0);
        this.add(lvwTønder, 4, 1);

        // Text Area
        Label lblPåFyld = new Label("Påfyld");
        this.add(lblPåFyld,6,0);
        this.add(txaPåFyld,6,1);
        txaPåFyld.setEditable(false);

        // Listener
        ChangeListener<Destillering> desListener = (ov, o , n) -> this.updateControls();
        lvwDestilleringer.getSelectionModel().selectedItemProperty().addListener(desListener);

        ChangeListener<Tønde> tndListener = (ov, o, n) -> this.updateControls();
        lvwTønder.getSelectionModel().selectedItemProperty().addListener(tndListener);

        // Text Fields
        Label lblMængde = new Label("Mængde");
        this.add(lblMængde,6,3);
        this.add(txfMængde,6,4);

        Label lblPåfyldningsDato = new Label("Påfyldningsdato");
        this.add(lblPåfyldningsDato, 6,5);
        this.add(txfpåfyldningsDato,6,6);

        HBox hbxButton = new HBox(40);
        this.add(hbxButton,6,7);
        hbxButton.setAlignment(Pos.BASELINE_CENTER);

        Button btnpåFyldAction = new Button("Påfyld");
        hbxButton.getChildren().add(btnpåFyldAction);
        btnpåFyldAction.setOnAction(event -> this.påFyldAction());



    }

    public void påFyldAction(){
//        lvwDestilleringer.getItems().setAll(controller.getDestilleringer());
//        int desIndex = lvwDestilleringer.getItems().size() - 1;
//        lvwDestilleringer.getSelectionModel().select(desIndex);
        Destillering destillering = lvwDestilleringer.getSelectionModel().getSelectedItem();
        Tønde tønde = lvwTønder.getSelectionModel().getSelectedItem();
        StringBuilder sbDest = new StringBuilder();
        StringBuilder sbTønde = new StringBuilder();

        if(tønde != null){
            for(Mængde mgde : destillering.getMængder()){
                sbDest.append(mgde).append("\n");
            }
            for(Mængde mgde : tønde.getMængder()){
                sbTønde.append(mgde).append("\n");
            }
        }

//        int getMængde = Integer.parseInt(txfMængde.getText());
//        String getPåfyldningsDato = txfpåfyldningsDato.getText();

        txaPåFyld.setText(sbDest.toString());
        txaPåFyld.setText(sbTønde.toString());

    }

    private void selectedChanged() {
    }

    public void updateControls() {
        ArrayList<Destillering> destilleringer = controller.getDestilleringer();
        lvwDestilleringer.getItems().setAll(destilleringer);

        ArrayList<Tønde> tønder = controller.getTønde();
        lvwTønder.getItems().setAll(tønder);




    }
}
