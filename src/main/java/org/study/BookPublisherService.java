package org.study;

public class BookPublisherService {

    public void publish(String bookName){
        if(bookName.length() <= 5) System.out.println("[" +bookName + "] is published!!");
        else deny(bookName);
    }

    public void deny(String bookName){
        System.out.println("Publishing [" + bookName + "] is denied!!");
    }
}
