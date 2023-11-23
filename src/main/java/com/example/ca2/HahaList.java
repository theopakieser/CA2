package com.example.ca2;

public class HahaList<H> {
    public HahaNode<H> head = null;

    public void addElement(H e) { //Add element to head of list
        HahaNode<H> hn = new HahaNode<>();
        hn.setContents(e);
        hn.next = head;
        head = hn;
    }



    public void clear() { //Empty list
        head = null;
    }

    public void deleteElement(H e){
        HahaNode<H> hn = new HahaNode<>();
        hn.setContents(e);}

    //Add other insertion, deletion, access, search, etc. methods too
//Inner class approach.
    class HahaNode<N> {
        public HahaNode<N> next = null;
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



