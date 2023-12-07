package com.example.ca2;

public class HahaList<H> {
    public HahaNode<H> head = null;

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

public void SelectElement(){

}

//    public void deleteElement(){
//        if(head ==null){
//            return;
//        }
//        (head.getContents()) {
//            head = head.next;
//            return;
//        }
//    }

//    public void delElement(H e){
//        HahaNode<H> hn = new HahaNode<>();
//        hn.setContents(e);
//        if(hn.getContents())
//        hn.next = head;
//        head = hn;
//            intCode = Utils.readNextInt("Enter International Code: ");
//            PortNode temp = portHead;
//            while (temp != null && temp.getIntCode() != intCode)
//                temp = temp.nextPort;
//            if (temp != null)
//                return temp;
//
//
//    }






    public void clear() { //Empty list
        head = null;
    }


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



