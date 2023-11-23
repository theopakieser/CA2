package com.example.ca2;

public class Game {
    private String name;
    private String publisher;
    private String description;
    private String developer;
    private GamesMachine originalMachine;
    private int yearOfRelease;
    private String url;

    HahaList<Game> games=new HahaList<>();




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public GamesMachine getOriginalMachine() {
        return originalMachine;
    }

    public void setOriginalMachine(GamesMachine originalMachine) {
        this.originalMachine = originalMachine;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Game(String name, String publisher, String description, String developer, GamesMachine originalMachine, int yearOfRelease, String url) {
        this.name = name;
        this.publisher = publisher;
        this.description = description;
        this.developer = developer;
        this.originalMachine = originalMachine;
        this.yearOfRelease = yearOfRelease;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", developer='" + developer + '\'' +
                ", originalMachine=" + originalMachine +
                ", yearOfRelease=" + yearOfRelease +
                ", url='" + url + '\'' +
                '}';
    }

    }
