package com.example.ca2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
private Game g1, g2, g3, g4;
    @BeforeEach
    void setUp() {
        g1 = new Game("Minecraft", "Mirosoft", "Haha funny block game", "Your mom", null, 1991, "qirnqio");
        g2 = new Game("Stardew Valley", "Sleepy Ape", "Cosy Farming Sim", "Your da", null, 2003, "asdfghjkl");
        g3 = new Game("Call Of Duty", "Some cunt", "Pew pew shooty game", "your brother's dog", null, 2024, "qwefsi");
        g4 = new Game("Fifa 20000000000000000", "EA", "a cex employee's worst nightmare", "some fucking soccer obsessed twat", null, 1982, "daeojfaq");
    }

    @AfterEach
    void tearDown() {
        g1=g2=g3=g4=null;
    }

    @Test
    void gettersTest(){
        assertEquals("Minecraft", g1.getName());
        assertEquals("Sleepy Ape", g2.getPublisher());
        assertEquals("Pew pew shooty game", g3.getDescription());
        assertEquals("some fucking soccer obsessed twat", g4.getDeveloper());
        assertEquals(null, g1.getOriginalMachine());
        assertEquals(2003, g2.getYearOfRelease());
        assertEquals("qwefsi", g3.getUrl());

    }

    @Test
    void settersTest(){
        assertEquals("Stardew Valley", g2.getName());
        g2.setName("OverWatch");
        assertEquals("OverWatch", g2.getName());

        assertEquals("Some cunt", g3.getPublisher());
        g3.setPublisher("A very lovely person");
        assertEquals("A very lovely person", g3.getPublisher());

        assertEquals("a cex employee's worst nightmare", g4.getDescription());
        g4.setDescription("Soccer Game");
        assertEquals("Soccer Game", g4.getDescription());

        assertEquals("Your mom", g1.getDeveloper());
        g1.setDeveloper("Some bored dude");
        assertEquals("Some bored dude", g1.getDeveloper());
    }

    @Test
    void toStringTest(){
        String toStringContains = g1.toString();
        assertTrue(toStringContains.contains( "name='" + g1.getName()));
        assertTrue(toStringContains.contains( "publisher='" + g1.getPublisher()));
        assertTrue(toStringContains.contains( "description='" + g1.getDescription()));
        assertTrue(toStringContains.contains( "developer='" + g1.getDeveloper()));
        assertTrue(toStringContains.contains( "originalMachine=" + g1.getOriginalMachine()));
        assertTrue(toStringContains.contains( "yearOfRelease=" + g1.getYearOfRelease()));
        assertTrue(toStringContains.contains( "url='" + g1.getUrl()));
    }
}