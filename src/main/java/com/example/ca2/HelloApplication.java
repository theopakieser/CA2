package com.example.ca2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {

    static HahaList<Game> games = new HahaList<>();
    static HahaList<GamesMachine> gameMachines = new HahaList<>();



    @Override
        public void start (Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            stage.setTitle("The Games App!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main (String[]args){

            launch();
        }
    }
