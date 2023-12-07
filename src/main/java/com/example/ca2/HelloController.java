package com.example.ca2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

import java.io.IOException;
import com.example.ca2.Game;

public class HelloController {
    @FXML
    private Label welcomeText;
     @FXML
     private Label exitText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    protected void onExitClicked() {
        Platform.exit();
    }

    @FXML
    protected void onGamesClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        Stage stage = new Stage();
        stage.setTitle("The Game Menu!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onGamesMachineClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gamesMachine-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        Stage stage = new Stage();
        stage.setTitle("The Game Menu!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onBackClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        Stage stage = new Stage();
        stage.setTitle("The Game Menu!");
        stage.setScene(scene);
        stage.show();
    }

    public TextField name;
    public  TextField publisher;
    public  TextField description;
    public  TextField developer;
    public  TextField url;

    public GamesMachine originalMachine;
    public TextField yearOfRelease;

    public TextField manufacturer;
    public TextField media;
    public TextField initialPrice;
    public TextField type;





    @FXML
    protected void onAddGameClicked() throws IOException {
       HelloApplication.games.addElement(new Game(name.getText(), publisher.getText(), description.getText(), developer.getText(), originalMachine, yearOfRelease.getLength(), url.getText()));
       System.out.println(HelloApplication.games.head);
    }

    @FXML
    protected void onAddGameMachineClicked() throws IOException {
        HelloApplication.gameMachines.addElement(new GamesMachine(name.getText(), description.getText(), manufacturer.getText(), yearOfRelease.getLength(), type.getText(), media.getText(), initialPrice.getLength(), url.getText()));
        System.out.println(HelloApplication.gameMachines.head);
    }



    public void onViewAllGameMachineClicked() throws IOException {
        HelloApplication.gameMachines.listElements();
    }

//    // Create UI components
//    public TextField nodeName;
//    Button deleteButton = new Button("Delete Node");
//        deleteButton.setOnAction(event -> deleteNode());
//
//
//
//    // Create the scene and set it on the stage
//
//
//    private void deleteNode() {
//        // Get the node name from the TextField
//        String nodeName = nodeNameTextField.getText();
//
//        // Call the delete method with the node name
//        gameList.deleteByName(nodeName);
//
//        // Update the UI or print some result
//        System.out.println("Node with name '" + nodeName + "' deleted.");
//}
}