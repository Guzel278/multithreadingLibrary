package org.example;

public class Main {
    public static void main(String[] args){
        Library library = new Library();
        Library.Producer producer = new Library.Producer(library);
        Library.Reader reader = new Library.Reader(library);
        new Thread(reader).start();
        new Thread(producer).start();
    }
}