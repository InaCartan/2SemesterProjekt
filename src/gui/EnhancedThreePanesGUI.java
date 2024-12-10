package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

    public class EnhancedThreePanesGUI extends Application {

        // Store data for PåfyldTønde
        private final ListView<String> dataList = new ListView<>();

        @Override
        public void start(Stage Stage) {

//            Stage.setTitle("Sall");
//            BorderPane pane = new BorderPane();
//            this.initContent(pane);

//            Scene scene = new Scene(pane);
//            Stage.setScene(scene);
//            Stage.show();


            // Create the main TabPane
            TabPane tabPane = new TabPane();

            // Create Tabs
            Tab tondeTab = new Tab("Tønde");
            Tab destilleringTab = new Tab("Destillering");
            Tab pafyldTondeTab = new Tab("PåfyldTønde");


            // Configure Tabs
            tondeTab.setClosable(false);
            destilleringTab.setClosable(false);
            pafyldTondeTab.setClosable(false);

            // Create Destillering tab content
            destilleringTab.setContent(createDestilleringTab());

            // Create Tønde tab content
            tondeTab.setContent(createTondeTab());

            // Create PåfyldTønde tab content
            pafyldTondeTab.setContent(createPafyldTondeTab());

            // Add tabs to TabPane
            tabPane.getTabs().addAll(destilleringTab, tondeTab, pafyldTondeTab);

            // Set the stage
            Scene scene = new Scene(tabPane, 600, 400);
            Stage.setTitle("Three Panes GUI");
            Stage.setScene(scene);
            Stage.show();
        }

//        private void initContent(BorderPane pane) {
//            TabPane tabPane = new TabPane();
//            this.initTabPane(tabPane);
//            pane.setCenter(tabPane);
//        }

//        private void initTabPane(TabPane tabPane) {
//            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        private VBox createDestilleringTab() {
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));

            // Input fields
            TextField nameField = new TextField();
            nameField.setPromptText("Name");

            TextField antalLiterField = new TextField();
            antalLiterField.setPromptText("Antal Liter");

            TextField kornField = new TextField();
            kornField.setPromptText("Korn");

            TextField maltBatchField = new TextField();
            maltBatchField.setPromptText("Malt Batch");

            // Submit button
            Button submitButton = new Button("Submit");
            submitButton.setOnAction(event -> {
                String name = nameField.getText();
                String antalLiter = antalLiterField.getText();
                String korn = kornField.getText();
                String maltBatch = maltBatchField.getText();

                if (!name.isEmpty() && !antalLiter.isEmpty() && !korn.isEmpty() && !maltBatch.isEmpty()) {
                    String entry = String.format("Name: %s, Antal Liter: %s, Korn: %s, Malt Batch: %s",
                            name, antalLiter, korn, maltBatch);
                    dataList.getItems().add(entry);
                    clearFields(nameField, antalLiterField, kornField, maltBatchField);
                } else {
                    showAlert("All fields must be filled out!");
                }
            });

            layout.getChildren().addAll(new Label("Destillering Info:"), nameField, antalLiterField, kornField, maltBatchField, submitButton);
            return layout;
        }

        private VBox createTondeTab() {
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));

            for (int i = 1; i <= 5; i++) {
                Button btn = new Button("Tønde " + i);
                btn.setOnAction(event -> {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Input Liter");
                    dialog.setHeaderText("Enter how many liters you want:");
                    dialog.setContentText("Liters:");

                    dialog.showAndWait().ifPresent(liters -> {
                        if (!liters.matches("\\d+")) {
                            showAlert("Please enter a valid number!");
                        } else {
                            showAlert("You entered " + liters + " liters for " + btn.getText());
                        }
                    });
                });
                layout.getChildren().add(btn);
            }

            return layout;
        }

        private VBox createPafyldTondeTab() {
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));

            layout.getChildren().addAll(new Label("Registered Data:"), dataList);
            return layout;
        }

        private void clearFields(TextField... fields) {
            for (TextField field : fields) {
                field.clear();
            }
        }

        private void showAlert(String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setContentText(message);
            alert.showAndWait();
        }

    }

