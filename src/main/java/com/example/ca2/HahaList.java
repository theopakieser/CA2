package com.example.ca2;

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
            current=current.next;
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


    public void bubbleSortGamesByYear() { // //www.prepbytes.com/blog/linked-list/bubble-sort-for-linked-list-by-swapping-nodes/
        HahaList<Game>.HahaNode<Game> gameHead =HelloApplication.games.head;
        if (gameHead != null) {
            HahaList<Game>.HahaNode<Game> current,newGameHead = null,moveNode, prevNode = null;
            while (gameHead != null) {//if head isnt null
                current = gameHead;
                moveNode = gameHead; //current and moveNode are now the head
                while (current != null) {//if current isnt null
                    if (current.next!=null && current.next.getContents().getYearOfRelease()>moveNode.getContents().getYearOfRelease()) {//if current year is bigger than prev year
                        moveNode=current.next; //swap nodes
                        prevNode=current;
                    }
                    current=current.next; //go next
                }
                if (moveNode==gameHead) {//if moved node is the same as the head
                    gameHead=gameHead.next; //go next
                }
                if (prevNode!=null) {//if previous node isnt null
                    prevNode.next = moveNode.next; //next node is the next node from the moved node
                }
                moveNode.next=newGameHead; //the node is the new head
                newGameHead=moveNode;
            }
            gameHead=newGameHead;//make new head
        }
    }

    public HahaList<Game>.HahaNode<Game> getSortedList() {
        return HelloApplication.games.head;
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



