package com.example.ca2;

public class Game{ //the game class
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

//    @Override
//    public int compareTo(Game g) {
//        return this.getYearOfRelease()-g.getYearOfRelease(); //compares games based on year of release in asceding order
//    }


//    public void bubbleSortGamesByYear(HahaList<Game> a){
//        for(int b=1;b<a.size();b++){
//            for(int i=0;i<a.size()-b;i++){
//                if(temp.getContents().getYearOfRelease() > temp.next.getContents().getYearOfRelease() ){
//                    temp = temp.next;
//                    temp.next = temp;
//                }
//                temp = temp.next;
//                        get(i).compareTo(a.get(i+1))>0){
//                    Game swap=a.get(i);
//                    a.set(i, a.get(i+1));
//                    a.set(i+1, swap);
//                }
//            }
//        }
//    }

}
