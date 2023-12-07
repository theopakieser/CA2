package com.example.ca2;
import java.util.Scanner;
import java.util.function.Function;

public class HahaHashCuckoo<Q> {
    int[] hashTable;
    public HahaHashCuckoo(int size) {
        hashTable=new int [size];
    }

    public int hashFunction(int key) {
        return key%hashTable.length;
    }

    public void displayHashTable(){
        System.out.println("Hash Table (using Quadratic Probing)\n=================");
        for(int i=0;i<hashTable.length;i++)
            System.out.println(i+". "+hashTable[i]);
    }

    public int add(int data) {
        int home=hashFunction(data),loc=home,probe=1;
        do {
            if(hashTable[loc]==0) { //Free, so use it...
                hashTable[loc] = data;
                return loc;
            }
            else {
                //Full, so probe ahead by 1 with wrap round
                System.out.println(loc+" full so probing ahead by "+(probe*probe)+"...");
                loc=(loc+(probe*probe++))%hashTable.length;
            }

        }while(probe<=50);
        return -1; //Failed!!!!
    }
}