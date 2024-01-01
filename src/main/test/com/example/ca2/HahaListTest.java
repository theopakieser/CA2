package com.example.ca2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HahaListTest {

    //TODO 4/6 tests done!

    public HahaList<Game> gamesList, gamesListEmpty;
    public HahaList<GamePort> gpList, gpListEmpty;
    public HahaList<GamesMachine> gmList, gmListEmpty;

    private Game g1, g2, g3;
    private GamePort gp1, gp2, gp3;
    private GamesMachine gm1, gm2, gm3;

    @BeforeEach
    void setUp() {
        gamesList= new HahaList<>();
        gamesListEmpty= new HahaList<>();
        g1 = new Game("Minecraft", "Mirosoft", "Haha funny block game", "Your mom", null, 1991, "qirnqio");
        g2 = new Game("Stardew Valley", "Sleepy Ape", "Cosy Farming Sim", "Your da", null, 2003, "asdfghjkl");
        g3 = new Game("Call Of Duty", "Some cunt", "Pew pew shooty game", "your brother's dog", null, 2024, "qwefsi");

        gmList=new HahaList<>();
        gmListEmpty=new HahaList<>();
        gm1 = new GamesMachine("Laptop", "Acer Laptop, portable home computer", "Acer", 2019, "PC", "Disk", 1300, "ASDFGHJKL" );
        gm2 = new GamesMachine("Xbox Series S", "Black Xbox console", "Microsoft", 2020, "Console", "Disk", 450, "qwertyuiop");
        gm3 = new GamesMachine("Nintendo Switch Lite", "Small handheld console", "Nintendo", 2019, "Console", "Cartridge", 200, "zxcvbnm");

        gpList=new HahaList<>();
        gpListEmpty=new HahaList<>();
        gp1 = new GamePort(g1, gm2, "Alexander Hamilton", 2009, "qazwsxedc");
        gp2 = new GamePort(g2, gm3, "ELizabeth Schyler", 2017, "plmokijnuhb");
        gp3 = new GamePort(g3, gm1, "Aaron Burr", 2015, "qetuokhfs");

        gamesList.addElement(g1);
        gmList.addElement(gm1);
        gpList.addElement(gp1);

    }

    @AfterEach
    void tearDown() {
        gamesList=gamesListEmpty=null;
        g1=g2=g3=null;
        gmList=gmListEmpty=null;
        gm1=gm2=gm3=null;
        gpList=gpListEmpty=null;
        gp1=gp2=gp3=null;
    }

    @Test
    void addingElementsToEmptyList(){
        assertEquals(0, gamesListEmpty.size());
        gamesListEmpty.addElement(g2);
        assertEquals(1, gamesListEmpty.size());

        assertEquals(0, gmListEmpty.size());
        gmList.addElement(gm2);
        assertEquals(1, gmListEmpty.size());
    }

    @Test
    void addingElementsToListWithElementsInIt(){
        assertEquals(1, gmList.size());
        gmList.addElement(gm3);
        assertEquals(2, gmList.size());

        assertEquals(1, gpList.size());
        gpList.addElement(gp3);
        assertEquals(2, gpList.size());
    }

    @Test
    void editGames(){

    }

    @Test
    void editGamesMachine(){

    }

}