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



    //Add other insertion, deletion, access, search, etc. methods too
//Inner class approach.
    class HahaNode<N> {
        public HahaNode<H> next = null;
        private N contents; //ADT reference!

        public N getContents() {
            return contents;
        }

        public void setContents(N c) {
            contents = c;
        }

    }
}



