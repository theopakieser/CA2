package com.example.ca2;

public class GamesMachine {
private String name;
private String desc;
private String manufacturer;
private int yearOfRelease;
private String type;
private String media;
private int initialPrice;


    private String url;

    HahaList<GamesMachine> gamesMachines=new HahaList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(int initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GamesMachine(String name, String desc, String manufacturer, int yearOfRelease, String type, String media, int initialPrice, String url) {
        this.name = name;
        this.desc = desc;
        this.manufacturer = manufacturer;
        this.yearOfRelease = yearOfRelease;
        this.type = type;
        this.media = media;
        this.initialPrice = initialPrice;
        this.url = url;
    }



    @Override
    public String toString() {
        return "GamesMachine{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", type='" + type + '\'' +
                ", media='" + media + '\'' +
                ", initialPrice=" + initialPrice +
                ", url='" + url + '\'' +
                '}';
    }
}


