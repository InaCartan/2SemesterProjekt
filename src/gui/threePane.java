package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class threePane extends Application {

    //StoredataforPåfyldTønde
    private final ListView<String> dataList = new ListView<>();

    @Override
    public void start(Stage stage) {
        //CreatethemainTabPane
        TabPane tabPane = new TabPane();

//CreateTabs
        Tab tondeTab = new Tab("Tønde");
        Tab destilleringTab = new Tab("Destillering");
        Tab pafyldTondeTab = new Tab("PåfyldTønde");


//ConfigureTabs
        tondeTab.setClosable(false);
        destilleringTab.setClosable(false);
        pafyldTondeTab.setClosable(false);

//CreateDestilleringtabcontent
        destilleringTab.setContent(createDestilleringTab());

//CreateTøndetabcontent
        tondeTab.setContent(createTondeTab());

//CreatePåfyldTøndetabcontent
        pafyldTondeTab.setContent(createPafyldTondeTab());

//AddtabstoTabPane
        tabPane.getTabs().addAll(destilleringTab, tondeTab, pafyldTondeTab);

//Setthestage
        Scene scene = new Scene(tabPane, 600, 400);
        stage.setTitle("ThreePanesGUI");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createDestilleringTab() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        //Inputfields
        TextField nameField = new TextField();
        nameField.setPromptText("Name: ");

        TextField antalLiterField = new TextField();
        antalLiterField.setPromptText("AntalLiter: ");

        TextField kornField = new TextField();
        kornField.setPromptText("Korn");

        TextField maltBatchField = new TextField();
        maltBatchField.setPromptText("MaltBatch");

        //Submitbutton
        Button gemButton = new Button("gem");
        gemButton.setOnAction(event -> {
            String name = nameField.getText();
            String antalLiter = antalLiterField.getText();
            String korn = kornField.getText();
            String maltBatch = maltBatchField.getText();

            if (!name.isEmpty() && !antalLiter.isEmpty() && !korn.isEmpty() && !maltBatch.isEmpty()) {
                String entry = String.format("Name:%s,AntalLiter:%s,Korn:%s,MaltBatch:%s",
                        name, antalLiter, korn, maltBatch);
                dataList.getItems().add(entry);
                clearFields(nameField, antalLiterField, kornField, maltBatchField);
            } else {
                showAlert("Allfieldsmustbefilledout!");
            }
        });

        layout.getChildren().addAll(new  Label("DestilleringInfo:"), nameField, antalLiterField, kornField, maltBatchField, gemButton);
        return layout;
    }

    private VBox createTondeTab(){
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(10));

        for(int i=1; i<=5; i++){
            Button btn= new Button("Tønde"+i);
            btn.setOnAction(event->{
                TextInputDialog dialog=new TextInputDialog();
                dialog.setTitle("InputLiter");
                dialog.setHeaderText("Enterhowmanylitersyouwant:");
                dialog.setContentText("Liters:");

                dialog.showAndWait().ifPresent(liters->{
                    if(!liters.matches("\\d+")){
                        showAlert("Pleaseenteravalidnumber!");
                    }else{
                        showAlert("Youentered"+liters+"litersfor"+btn.getText());
                    }
                });
            });
            layout.getChildren().add(btn);
        }

        return layout;
    }

    private VBox createPafyldTondeTab(){
        VBox layout=new VBox(10);
        layout.setPadding(new Insets(10));

        layout.getChildren().addAll(new Label("RegisteredData:"),dataList);
        return layout;
    }

    // Funktionen kan tag imod 0 til mange String variable ("or a single array of them")
    //<Stackoverflow>
    private void clearFields(TextField... fields){
        for(TextField field : fields){
            field.clear();
        }
    }

    private void showAlert(String message){
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

}



