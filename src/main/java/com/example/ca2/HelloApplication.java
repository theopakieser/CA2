package com.example.ca2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver()); //creates XStream object
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Ship Management System.xml")); //uses filewriter to write objects below as xml to ship management system file
        out.writeObject(HahaList.class);
        out.writeObject(HahaList.HahaNode.class);
        out.writeObject(HashTableLP.class);
        out.writeObject(Game.class);
        out.writeObject(GamesMachine.class);
        out.writeObject(GamePort.class);
        out.close();
    }

    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{HahaList.class, HahaList.HahaNode.class, Hashtable.class, Game.class, GamesMachine.class, GamePort.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Game Management System.xml"));
        HahaList lists = (HahaList) is.readObject();
        HahaList.HahaNode nodes = (HahaList.HahaNode) is.readObject();
        HashTableLP hashTables = (HashTableLP) is.readObject();
        Game games = (Game) is.readObject();
        GamePort gamePorts = (GamePort) is.readObject();
        GamesMachine gamesMachines = (GamesMachine) is.readObject();

        is.close();
    }


}
