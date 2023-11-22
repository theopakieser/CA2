package com.example.ca2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Platform;
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-menu.fxml"));
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
    protected void onAddClicked() throws IOException {
       HelloApplication.games.addElement(new Game("q", "w", "w", "w", null,12, "q" ));
       System.out.println(HelloApplication.games.head);
    }

}