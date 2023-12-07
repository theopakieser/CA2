package com.example.ca2;

public class GamePort {
    private Game originalGame;
    private GamesMachine newMachine;
    private String developer;
    private int yearOfRelease;
    private String url;

    HahaList<GamePort> gamePorts=new HahaList<>();

    public Game getOriginalGame() {
        return originalGame;
    }

    public void setOriginalGame(Game originalGame) {
        this.originalGame = originalGame;
    }

    public GamesMachine getNewMachine() {
        return newMachine;
    }

    public void setNewMachine(GamesMachine newMachine) {
        this.newMachine = newMachine;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        if(yearOfRelease>originalGame.getYearOfRelease()) {
            this.yearOfRelease = yearOfRelease;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GamePort(Game originalGame, GamesMachine newMachine, String developer, int yearOfRelease, String url) {
        this.originalGame = originalGame;
        this.newMachine = newMachine;
        this.developer = developer;
        this.yearOfRelease = yearOfRelease;
        this.url = url;
    }
   public String name = originalGame.getName();

    @Override
    public String toString() {

        return "GamePort{" +
                "originalGame=" + originalGame +
                ", newMachine=" + newMachine +
                ", developer='" + developer + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", url='" + url + '\'' +
                ", name=" + name +
                '}';
    }
}
