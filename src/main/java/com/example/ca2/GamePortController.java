package com.example.ca2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GamePortController {

        public TextField addGamePortOriginalGame;
        public TextField addGamePortNewGameMachine;
        public TextField addGamePortDeveloper;
        public TextField addGamePortUrl;
        public TextField addGamePortYearOfRelease;
        @FXML
        public TextArea myGames;
        public TextArea ViewSelectedGameMachine;

        @FXML
        protected void onAddGamePortClicked() throws IOException {
            HahaList<GamesMachine>.HahaNode<GamesMachine> newGameMachine = HelloApplication.gameMachines.head; //create new GameMachine

            while (newGameMachine != null) {
                if (newGameMachine.getContents().getName().equals(NewGameMachine.getText())) {
                    ViewNewGameMachine.setText(newGameMachine.toString());

            HahaList<Game>.HahaNode<Game> originalGame = HelloApplication.games.head; //create new Game

            while (originalGame != null) {
                if (originalGame.getContents().getName().equals(OriginalGame.getText())) {
                    ViewOriginalGame.setText(newGameMachine.toString());

                        // Add the game using the found originalGameMachine
                        String yearOfReleasage = addGamePortYearOfRelease.getText();
                        int yearOfRelease = Integer.parseInt(yearOfReleasage);

                            HelloApplication.gamePorts.addElement(new GamePort(
                                    originalGame.getContents(),
                                    newGameMachine.getContents(),
                                    addGamePortDeveloper.getText(),
                                    yearOfRelease,
                                    addGamePortUrl.getText()
                            ));

                            System.out.println(HelloApplication.gamePorts.head);

                            return; // Exit the method after adding the game
                        } else {
                            newGameMachine = newGameMachine.next;
                        }
                    }

                    System.out.println("Not found GG");
                }
            }
        }


        @FXML
        protected void onSelectedGameMachineClicked() {
            HahaList<GamesMachine>.HahaNode<GamesMachine> selectedGameMachine = HelloApplication.gameMachines.head;

            while (selectedGameMachine != null) {

                if (selectedGameMachine.getContents() != null &&
                        selectedGameMachine.getContents().getName().equals(NewGameMachine.getText())) {

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
    protected void onSelectedGameClicked() {
        HahaList<Game>.HahaNode<Game> selectedGame = HelloApplication.games.head;

        while (selectedGame != null) {

            if (selectedGame.getContents() != null &&
                    selectedGame.getContents().getName().equals(OriginalGame.getText())) {

                ViewSelectedGameMachine.setText(selectedGame.toString());
                System.out.println("Selected game machine found: " + selectedGame.getContents());
                return;
            } else {
                selectedGame = selectedGame.next;
            }
        }

        System.out.println("Not found GG");
    }

    @FXML
    protected void onSelectedGamePortClicked() {
        HahaList<GamePort>.HahaNode<GamePort> selectedGamePort = HelloApplication.gamePorts.head;

        while (selectedGamePort != null) {

            if (selectedGamePort.getContents() != null &&
                    selectedGamePort.getContents().getOriginalGame().equals(OriginalGame.getText())) {

                ViewSelectedGameMachine.setText(selectedGamePort.toString());
                System.out.println("Selected game machine found: " + selectedGamePort.getContents());
                return;
            } else {
                selectedGamePort = selectedGamePort.next;
            }
        }

        System.out.println("Not found GG");
    }

        @FXML
        protected void onViewGamePortClicked() throws IOException {
            HahaList.HahaNode temp = HelloApplication.gamePorts.head;
            StringBuilder GamePorts = new StringBuilder(); //creates a stringbuilder to loop the text - https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
            while (temp != null) {
                GamePorts.append(temp.toString()).append("\n"); // append makes the Stringbuilder exist via toString then uses the \n to new line after each
                temp = temp.next;
            }
            myGamePorts.setText(GamePorts.toString());
        }

        @FXML
        protected void onSelectedGamePortForDeletionClicked() {
            HahaList<GamePort>.HahaNode<GamePort> selectedGamePortForDeletion = HelloApplication.gamePorts.head;
            while (selectedGamePortForDeletion != null) {
                if (selectedGamePortForDeletion.getContents().getOriginalGame().getName().equals(SelectedGamePortForDeletion.getText())) {
                    ViewSelectedGamePortForDeletion.setText(selectedGamePortForDeletion.toString());
                    System.out.println("selectedGame: " + selectedGamePortForDeletion.getContents() + " has been found");
                    return;
                } else {
                    selectedGamePortForDeletion = selectedGamePortForDeletion.next;
                }
            }
            System.out.println("Not found GG");
        }

//    @FXML
//    protected void onSelectedGameForDeletionClicked() {
//        HahaList<Game>.HahaNode<Game> selectedGameForDeletion = HelloApplication.games.head;
//        while (selectedGameForDeletion != null) {
//            if (selectedGameForDeletion.getContents().getName().equals(SelectedGameForDeletion.getText())) {
//                ViewSelectedGameForDeletion.setText(selectedGameForDeletion.toString());
//                System.out.println("selectedGame: " + selectedGameForDeletion.getContents() + " has been found");
//                return;
//            } else {
//                selectedGameForDeletion = selectedGameForDeletion.next;
//            }
//        }
//        System.out.println("Not found GG");
//    }


    @FXML
        protected void onDeleteGamePortClicked() {
            System.out.println("Selected machine to delete: " + SelectedGamePortForDeletion.getText());
            HahaList<GamePort>.HahaNode<GamePort> selectedGamePortForDeletion = HelloApplication.gamePorts.head;
            HahaList<GamePort>.HahaNode<GamePort> previousGamePort = null;
            while (selectedGamePortForDeletion != null) {
                if (selectedGamePortForDeletion.getContents().getOriginalGame().getName().equals(SelectedGamePortForDeletion.getText())) {
                    if (previousGamePort == null) {
                        HelloApplication.gamePorts.head = selectedGamePortForDeletion.next;
                    } else {
                        previousGamePort.next = selectedGamePortForDeletion.next;
                    }
                    System.out.println("It has been Deleted :)");
                    return;
                } else {
                    previousGamePort = selectedGamePortForDeletion;
                    selectedGamePortForDeletion = selectedGamePortForDeletion.next;
                }
            }

            System.out.println("GG not deleted");
        }

        @FXML
       protected void onEditGamePortClicked() throws IOException {

            HahaList<GamesMachine>.HahaNode<GamesMachine> newGameMachine = HelloApplication.gameMachines.head;

            while (newGameMachine != null) {
                if (newGameMachine.getContents().getName().equals(addGamePortNewGameMachine.getText())) {
                    ViewNewGameMachine.setText(newGameMachine.toString());

            HahaList<Game>.HahaNode<Game> originalGame = HelloApplication.games.head;
            while(originalGame != null) {
                if(originalGame.getContents().getName().equals(addGamePortOriginalGame.getText())){
                    ViewOriginalGame.setText(originalGame.toString());
                }
            }

                    HahaList<GamePort>.HahaNode<GamePort> temp = HelloApplication.gamePorts.head;
                    while (temp != null) {
                        if (temp.getContents().getOriginalGame().equals(SelectedGame.getText())) {
                            String yearOfReleasage = editGamePortYearOfRelease.getText();
                            int YearOfRelease = Integer.parseInt(yearOfReleasage);
                            GamePort editedGamePort = new GamePort(
                                    originalGame.getContents(),
                                    newGameMachine.getContents(),
                                    editGamePortDeveloper.getText(),
                                    YearOfRelease,
                                    editGamePortUrl.getText()
                            );
                            HelloApplication.gamePorts.editGP(editedGamePort);
                            temp.setContents(editedGamePort);
                            System.out.println(editedGamePort.toString());
                            return;
                        } else {
                            temp = temp.next;
                        }
                    }
                }


            }
        }
        public TextField editGamePortOriginalGame;
        public TextField editGamePortNewGamesMachine;
        public TextField editGameDescription;
        public TextField editGamePortDeveloper;
        public TextField editGameOriginalGameMachine;
        public TextField editGamePortYearOfRelease;
        public TextField editGamePortUrl;
        public TextField NewGameMachine;
        public TextArea ViewOriginalMachine;
        public TextArea ViewSelectedGameForDeletion;
        public TextField SelectedGameForDeletion;
        public TextField SelectedGame;
        public TextArea ViewOriginalGame;
        public TextArea ViewNewGameMachine;
        public TextField OriginalGame;
        public TextField SelectedGamePortForDeletion;
        public TextArea myGamePorts;
        public TextArea ViewSelectedGamePortForDeletion;
}
