package com.example.ca2;

import java.util.Hashtable;

public class HahaList<H> {
    public HahaNode<H>  head = null;

    public void addElement(H e) { //Add element to head of list
        HahaNode<H> hn = new HahaNode<>();
        hn.setContents(e);
        hn.next = head;
        head = hn;

    }


    public void listElements() {
        HahaNode<H> temp;
         temp=head;
        while(temp!=null) {
//Process node referenced by temp
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int size(){
        int size =0;
        HahaList.HahaNode current = head;
        while (current!=null){
            size++;
            current=current.next
        }
        return size;
    }



public void editGM(GamesMachine editGameMachine){
    HahaList<GamesMachine>.HahaNode<GamesMachine> temp = HelloApplication.gameMachines.head;
    while(temp !=null) {
        if (temp.getContents().getName().equals(editGameMachine.getName())) {
            temp.setContents(editGameMachine);
        } else {
            temp = temp.next;
        }
    }
}
    public void editG(Game editGame){
        HahaList<Game>.HahaNode<Game> temp = HelloApplication.games.head;
        while(temp !=null) {
            if (temp.getContents().getName().equals(editGame.getName())) {
                temp.setContents(editGame);
            } else {
                temp = temp.next;
            }
        }
    }

    public void editGP(GamePort editGamePort){
        HahaList<GamePort>.HahaNode<GamePort> temp = HelloApplication.gamePorts.head;
        while(temp !=null) {
            if (temp.getContents().getOriginalGame().equals(editGamePort.getOriginalGame())) {
                temp.setContents(editGamePort);
            } else {
                temp = temp.next;
            }
        }
    }




    public void clear() { //Empty list
        head = null;
    }


    //Add other insertion, deletion, access, search, etc. methods too
//Inner class approach.
    class HahaNode<N> {
        HahaNode<N> next = null;
        private N contents; //ADT reference!

        public N getContents() {
            return contents;
        }

        public void setContents(N c) {
            contents = c;
        }

        @Override
        public String toString() {
            return contents + " \n";
        }
    }
}



