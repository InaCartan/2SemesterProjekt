package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
    private Controller controller = new Controller();
    private final ListView<String> dataList = new ListView<>();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Sall");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }



    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabDestillering = new Tab("Destillering");
        tabPane.getTabs().add(tabDestillering);

        DestilleringPane destilleringPane = new DestilleringPane(controller);
        tabDestillering.setContent(destilleringPane);
        tabDestillering.setOnSelectionChanged(event -> destilleringPane.updateControls());

        Tab tabTønde = new Tab("Tønde");
        tabPane.getTabs().add(tabTønde);

        TøndePane tøndePane = new TøndePane(controller);
        tabTønde.setContent(tøndePane);
        tabTønde.setOnSelectionChanged(event -> tøndePane.updateControls());


        Tab tabPåfyldTønde = new Tab("PåfyldTøndePane");
        tabPane.getTabs().add(tabPåfyldTønde);

        PåfyldTøndePane påfyldTøndePane = new PåfyldTøndePane(controller);
        tabPåfyldTønde.setContent(påfyldTøndePane);
        tabPåfyldTønde.setOnSelectionChanged(event -> påfyldTøndePane.updateControls());
    }
}
