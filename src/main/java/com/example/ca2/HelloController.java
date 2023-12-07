package com.example.ca2;

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
        String yearOfReleasage = yearOfRelease.getText(); //TextField text is turned into a String
        int yearOfRelease = Integer.parseInt(yearOfReleasage); // parseInt takes the numbers and turns them to an int
        String initialPricage = initialPrice.getText(); //TextField text is turned into a String
        int initialPrice = Integer.parseInt(initialPricage); // parseInt takes the numbers and turns them to an int
        HelloApplication.gameMachines.addElement(new GamesMachine(name.getText(), description.getText(), manufacturer.getText(), yearOfRelease, type.getText(), media.getText(), initialPrice, url.getText()));
        System.out.println(HelloApplication.gameMachines.head);
    }

    @FXML
    private TextArea myGameMachines;
    @FXML
    protected void onViewGameMachineClicked() throws IOException{
        HahaList.HahaNode temp = HelloApplication.gameMachines.head;
        StringBuilder ports = new StringBuilder(); //creates a stringbuilder to loop the text - https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
        while (temp != null) {
            ports.append(temp.toString()).append("\n"); // append makes the Stringbuilder exist via toString then uses the \n to new line after each
            temp = temp.next;
        }
        myGameMachines.setText(ports.toString());
    }

}