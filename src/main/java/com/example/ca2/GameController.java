package com.example.ca2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GameController {
    public TextField addGameName;
    public TextField addGamePublisher;
    public TextField addGameDescription;
    public TextField addGameDeveloper;
    public TextField addGameUrl;
    public TextField addGameOriginalMachine;
    public TextField addGameYearOfRelease;
    @FXML
    public TextArea myGames;
    public TextArea ViewSelectedGameMachine;

    @FXML
    protected void onAddGameClicked() throws IOException {
        HahaList<GamesMachine>.HahaNode<GamesMachine> originalGameMachine = HelloApplication.gameMachines.head; //create new GameMachine

        while (originalGameMachine != null) {
            if (originalGameMachine.getContents().getName().equals(OriginalGameMachine.getText())) {
                ViewOriginalMachine.setText(originalGameMachine.toString());

                // Add the game using the found originalGameMachine
                String yearOfReleasage = addGameYearOfRelease.getText();
                int yearOfRelease = Integer.parseInt(yearOfReleasage);

                HelloApplication.games.addElement(new Game(
                        addGameName.getText(),
                        addGamePublisher.getText(),
                        addGameDescription.getText(),
                        addGameDeveloper.getText(),
                        originalGameMachine.getContents(), // Use the found originalGameMachine
                        yearOfRelease,
                        addGameUrl.getText()
                ));

                System.out.println(HelloApplication.games.head);

                return; // Exit the method after adding the game
            } else {
                originalGameMachine = originalGameMachine.next;
            }
        }

        System.out.println("Not found GG");
    }


    @FXML
    protected void onSelectedGameMachineClicked() {
        HahaList<GamesMachine>.HahaNode<GamesMachine> selectedGameMachine = HelloApplication.gameMachines.head;

        while (selectedGameMachine != null) {

            if (selectedGameMachine.getContents() != null &&
                    selectedGameMachine.getContents().getName().equals(OriginalGameMachine.getText())) {

                ViewSelectedGameMachine.setText(selectedGameMachine.toString());
                System.out.println("Selected game machine found: " + selectedGameMachine.getContents());
                return;
            } else {
                selectedGameMachine = selectedGameMachine.next;
            }
        }

        System.out.println("Not found GG");
    }

    @FXML
    protected void onViewGameClicked() throws IOException {
        HahaList.HahaNode temp = HelloApplication.games.head;
        StringBuilder Games = new StringBuilder(); //creates a stringbuilder to loop the text - https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
        while (temp != null) {
            Games.append(temp.toString()).append("\n"); // append makes the Stringbuilder exist via toString then uses the \n to new line after each
            temp = temp.next;
        }
        myGames.setText(Games.toString());
    }

    @FXML
    protected void onSelectedGameForDeletionClicked() {
        HahaList<Game>.HahaNode<Game> selectedGameForDeletion = HelloApplication.games.head;
        while (selectedGameForDeletion != null) {
            if (selectedGameForDeletion.getContents().getName().equals(SelectedGameForDeletion.getText())) {
                ViewSelectedGameForDeletion.setText(selectedGameForDeletion.toString());
                System.out.println("selectedGame: " + selectedGameForDeletion.getContents() + " has been found");
                return;
            } else {
                selectedGameForDeletion = selectedGameForDeletion.next;
            }
        }
        System.out.println("Not found GG");
    }

    @FXML
    protected void onDeleteGameClicked() {
        System.out.println("Selected machine to delete: " + SelectedGameForDeletion.getText());
        HahaList<Game>.HahaNode<Game> selectedGameForDeletion = HelloApplication.games.head;
        HahaList<Game>.HahaNode<Game> previousGame = null;
        while (selectedGameForDeletion != null) {
            if (selectedGameForDeletion.getContents().getName().equals(SelectedGameForDeletion.getText())) {
                if (previousGame == null) {
                    HelloApplication.games.head = selectedGameForDeletion.next;
                } else {
                    previousGame.next = selectedGameForDeletion.next;
                }
                System.out.println("It has been Deleted :)");
                return;
            } else {
                previousGame = selectedGameForDeletion;
                selectedGameForDeletion = selectedGameForDeletion.next;
            }
        }

        System.out.println("GG not deleted");
    }

    @FXML
    protected void onEditGameClicked() throws IOException {

        HahaList<GamesMachine>.HahaNode<GamesMachine> originalGameMachine = HelloApplication.gameMachines.head;

        while (originalGameMachine != null) {
            if (originalGameMachine.getContents().getName().equals(addGameOriginalMachine.getText())) {
                ViewOriginalMachine.setText(originalGameMachine.toString());

                HahaList<Game>.HahaNode<Game> temp = HelloApplication.games.head;
                while (temp != null) {
                    if (temp.getContents().getName().equals(SelectedGame.getText())) {
                        String yearOfReleasage = editGameYearOfRelease.getText();
                        int YearOfRelease = Integer.parseInt(yearOfReleasage);
                        Game editedGame = new Game(
                                editGameName.getText(),
                                editGamePublisher.getText(),
                                editGameDescription.getText(),
                                editGameDeveloper.getText(),
                                originalGameMachine.getContents(), // Use the found originalGameMachine?
                                YearOfRelease,
                                editGameUrl.getText()
                        );
                        HelloApplication.games.editG(editedGame);
                        temp.setContents(editedGame);
                        System.out.println(editedGame.toString());
                        return;
                    } else {
                        temp = temp.next;
                    }
                }
            }
        }
    }
    @FXML
    protected void onSortClicked(){
        HelloApplication.games.bubbleSortGamesByYear();
      HahaList<Game>.HahaNode<Game> current = HelloApplication.games.head;
      while(current!=null) {
          System.out.println(current.getContents());
          current = current.next;
      }
    }
    public TextField editGameName;
    public TextField editGamePublisher;
    public TextField editGameDescription;
    public TextField editGameDeveloper;
    public TextField editGameOriginalGameMachine;
    public TextField editGameYearOfRelease;
    public TextField editGameUrl;
    public TextArea myGames1;
    public TextField OriginalGameMachine;
    public TextArea ViewOriginalMachine;
    public TextArea ViewSelectedGameForDeletion;
    public TextField SelectedGameForDeletion;
    public TextField SelectedGame;
}