package org.example;

public class Library {
    private  int book = 0;
     public synchronized void get(){
         while (book < 1){
             try {
                 wait();
             }
             catch(InterruptedException e){}
         }
         book--;
         System.out.println("1 book was taken");
         System.out.println("availible book: " + book);
         notify();
    }
    public synchronized void put(){
         while (book >= 10){
             try{
                 wait();
             }
             catch(InterruptedException e){}
         }
         book++;
         System.out.println("added 1 book");
         System.out.println("books in libary: " + book);
         notify();
    }
    static class Producer implements Runnable{
         Library library;
         Producer(Library library){
             this.library = library;
         }
         public void run(){
             for(int i = 1; i < 20; i++){
                 library.put();
             }
         }
    }
    static class Reader implements  Runnable{
        Library library;
        Reader(Library library){
            this.library = library;
        }
        public void run(){
            for(int i = 1; i < 20; i++){
                library.get();
            }
        }
    }
}
