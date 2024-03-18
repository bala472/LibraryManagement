package com.mbala.librarymanagement.datalayer;

import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataLayer {
    private static DataLayer dataLayer;
    private List<Book> bookList= new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    public static DataLayer getInstance(){
        if(dataLayer==null){
            dataLayer= new DataLayer();
        }
        return dataLayer;
    }
    public  List<Book> getBookList(){
        return bookList;
    }
    public Book getBookById(int id){
        for(Book book : bookList){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }
    public List<Book> getBookByName(String name){
        List<Book>  searchBookList = new ArrayList<>();
        for(Book book : bookList){
            if(book.getName().contains(name)){
                searchBookList.add(book);
            }
        }
        return searchBookList;
    }
    public boolean isNewBook(Book book){
        for(Book check:bookList){
            if(check.getName().equals(book.getName()) && check.getVolume()==book.getVolume()){
                return false;
            }
        }
        bookList.add(book);
        return true;
    }

}
