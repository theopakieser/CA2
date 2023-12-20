package com.example.ca2;

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

    public TextField SelectedGameMachineForDeletion;
    public TextArea ViewSelectedGameMachineForDeletion;
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

    public TextField SelectedGameMachine;





    @FXML
    protected void onAddGameClicked() throws IOException {
        //TODO figure out how to change original game machine to a string
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
        StringBuilder GameMachines = new StringBuilder(); //creates a stringbuilder to loop the text - https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
        while (temp != null) {
            GameMachines.append(temp.toString()).append("\n"); // append makes the Stringbuilder exist via toString then uses the \n to new line after each
            temp = temp.next;
        }
        myGameMachines.setText(GameMachines.toString());
    }

    @FXML
    protected void onEditGameMachineClicked() throws IOException {
        HahaList<GamesMachine>.HahaNode<GamesMachine> temp = HelloApplication.gameMachines.head;
        while (temp != null) {
            if (temp.getContents().getName().equals(SelectedGameMachine.getText())){
                String yearOfReleasage = yearOfRelease1.getText();
                String initialPricage = initialPrice1.getText();
                int InitialPricage = Integer.parseInt(initialPricage);
                int YearOfReleasage = Integer.parseInt(yearOfReleasage);
                GamesMachine editedGameMachine = new GamesMachine(name1.getText(), description1.getText(), manufacturer1.getText(), YearOfReleasage, type1.getText(), media1.getText(), InitialPricage, url1.getText());
                HelloApplication.gameMachines.editElement(editedGameMachine);
                temp.setContents(editedGameMachine);
                System.out.println(editedGameMachine.toString());
                return;
            } else {
                temp = temp.next;
            }
        }
    }

    @FXML
    protected void onSelectedGameMachineClicked(){
        HahaList<GamesMachine>.HahaNode<GamesMachine> selectedGameMachine = HelloApplication.gameMachines.head;
        while(selectedGameMachine != null){
            if(selectedGameMachine.getContents().getName().equals(SelectedGameMachine.getText())){
                ViewSelectedGameMachine.setText(selectedGameMachine.toString());
                System.out.println("selectedGameMachine: " + selectedGameMachine.getContents() + " has been found");
                return;
            } else {
                selectedGameMachine = selectedGameMachine.next;
            }
        }
        System.out.println("Not found GG");
    }


    @FXML
    protected void onSelectedGameMachineForDeletionClicked(){
        HahaList<GamesMachine>.HahaNode<GamesMachine> selectedGameMachineForDeletion = HelloApplication.gameMachines.head;
        while(selectedGameMachineForDeletion != null){
            if(selectedGameMachineForDeletion.getContents().getName().equals(SelectedGameMachineForDeletion.getText())){
                ViewSelectedGameMachineForDeletion.setText(selectedGameMachineForDeletion.toString());
                System.out.println("selectedGameMachine: " + selectedGameMachineForDeletion.getContents() + " has been found");
                return;
            } else {
                selectedGameMachineForDeletion = selectedGameMachineForDeletion.next;
            }
        }
        System.out.println("Not found GG");
    }
    @FXML
    protected void onDeleteGameMachineClicked(){
        System.out.println("Selected machine to delete: " + SelectedGameMachineForDeletion.getText());


        HahaList<GamesMachine>.HahaNode<GamesMachine> selectedGameMachineForDeletion = HelloApplication.gameMachines.head;
        HahaList<GamesMachine>.HahaNode<GamesMachine> previousGameMachine = null;
        while (selectedGameMachineForDeletion != null && selectedGameMachineForDeletion.next != null){
            previousGameMachine = selectedGameMachineForDeletion;
            selectedGameMachineForDeletion = selectedGameMachineForDeletion.next;

            if(selectedGameMachineForDeletion.getContents().getName().equals(SelectedGameMachineForDeletion.getText())){
                previousGameMachine.next=selectedGameMachineForDeletion.next;
                System.out.println("It has been Deleted :)");
                return;
            } else {
                selectedGameMachineForDeletion = selectedGameMachineForDeletion.next;
            }
        }
    }

//    @FXML
//    protected HahaList<GamesMachine>.HahaNode<GamesMachine> onSelectedGameMachineClicked() {
//        HahaList<GamesMachine>.HahaNode<GamesMachine> selectedGameMachine = HelloApplication.gameMachines.head;
//
//        while (selectedGameMachine != null) {
//            if (selectedGameMachine.getContents().getName().equals(SelectedGameMachine.getText())) {
//                ViewSelectedGameMachine.setText(selectedGameMachine.toString());
//                System.out.println("selectedGameMachine: " + selectedGameMachine.getContents() + " has been found");
//                return selectedGameMachine;
//            } else {
//                selectedGameMachine = selectedGameMachine.next;
//            }
//        }
//
//        System.out.println("Not found GG");
//        return null;
//    }


    public TextField name1;
    public TextField manufacturer1;
    public TextField description1;
    public TextField media1;
    public TextField initialPrice1;
    public TextField yearOfRelease1;
    public TextField type1;
    public TextField url1;
    public TextArea ViewSelectedGameMachine;

}

