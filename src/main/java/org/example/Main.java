package org.example;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Library.Producer producer = new Library.Producer(library);
        Library.Reader reader = new Library.Reader(library);
        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(producer);
        executor.execute(reader);
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        //new Thread(reader).start();
        //new Thread(producer).start();
    }
}