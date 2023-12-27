package com.example.ca2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("games-menu.fxml"));
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

    public void onGamesPortClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gh.fxml"));
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

    @FXML
    protected void onSaveClicked() throws Exception {
        HelloApplication.saveGameMachines(HelloApplication.gameMachines,"Game Management System.xml");
    }

    @FXML
    protected void onLoadClicked() throws Exception {
        HelloApplication.load();
    }


}

