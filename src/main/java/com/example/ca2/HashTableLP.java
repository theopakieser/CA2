package com.example.ca2;
import java.io.*;
import java.util.*;
import java.util.Scanner;

//used geeks for geeks to understand and write hash table and implement it - https://www.geeksforgeeks.org/java-program-to-implement-hashtables-with-linear-probing/ , https://www.geeksforgeeks.org/hashtable-in-java/?ref=lbp and https://www.geeksforgeeks.org/implementing-hash-table-open-addressing-linear-probing-cpp/

public class HashTableLP {
    private int currentSize, maxSize;
    private String[] keys;
    private String[] values;
    //^ variables


    public String[] getKeys() {
        return keys;
    }

    //constructor
    public HashTableLP(int capacity) {
        currentSize = 0; //start with size 0
        maxSize = capacity;
        keys = new String[maxSize]; //keys are declared
        values = new String[maxSize]; //values are declared
    }

    //clear table
    public void empty(){
        currentSize=0; //resets size
        keys = new String[maxSize]; // new keys are declared
        values = new String[maxSize]; // new values are declared
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public boolean isFull(){
        return currentSize==maxSize; // check if the current size is the same as max size, if the table is full
    }

    public boolean isEmpty(){
        return getCurrentSize() == 0; //checks if the table is empty
    }

    private int hashFunction(String key){
        return key.hashCode() % maxSize; //gets the hash code for a given key and takes modulo (%) with maxSize so that it is in the correct range
    }

    public void add(String key, String value){ //adds key-value pair
        int temp = hashFunction(key); //create temp hashfuntion
            if (keys[temp]==null){ //check if empty
                keys[temp] = key; //key goes inside keys array
                values[temp]=value; //value goes inside value array at same index
                currentSize++; //increase the size by one
                return; //exit when method done
            }
            if(keys[temp].equals(key)){ //if the key already exists
                values[temp]=value; //store the value in an array at the same key index
            }
            temp=(temp+1) % maxSize; //linear probing, increments index by 1
        }

        public String get(String key){ //gets a value for a given key
        int i = hashFunction(key); //create temp hashfuntion
        while(keys[i]!=null){ // while keys exist
            if(keys[i].equals(key)) // the key equals inputted key
                return values[i]; // return value
                i = (i+1)%maxSize; //linear probing, increments index by 1
        }
        return null;
        }

        public boolean contains(String key){ //checks if table contains a key, using the get method above
        return get(key) != null;
        }

        public void delete(String key){ //delete a key and its value
        if(!contains(key)) //if the key doesnt exist, leave method
            return;
        int i = hashFunction(key); //hashfunction i created
            while (!key.equals(keys[i])) //while the key doesnt equal to the one we are looking for
                i = (i+1)%maxSize; //use linear probing to find it
            keys[i]=values[i]=null; //delete key and value
            //rehash the keys now
            for(i=(i+1)%maxSize; keys[i]!=null; i=(i+1)%maxSize){//for loop that goes as long as the key is not zero, uses linear probing
                String temp1 = keys[i];
                String temp2 = values[i]; //create two temp variables, one for the key and value at the same index
                keys[i]=values[i]=null; //deletes key and value
                currentSize--; //decrements size of table
                add(temp1, temp2); //deleted pair is reinserted so that it finds a new slot in the table
            }
            currentSize--;
        }

        public void displayHashTable(){
        System.out.println("Hash Table******************\n");
        for (int i=0;i<maxSize;i++) //for loop with index i, makes sure i is less than the max size
            if(keys[i]!=null) //if the key isnt null
                System.out.println(keys[i]+" "+values[i]); //prints key and value for that index
        }
    }


