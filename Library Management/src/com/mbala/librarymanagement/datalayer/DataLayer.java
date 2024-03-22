package com.mbala.librarymanagement.datalayer;

import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.Library;
import com.mbala.librarymanagement.model.Members;


import java.util.ArrayList;
import java.util.List;

public class DataLayer {
    private static DataLayer dataLayer;
    private List<Book> bookList= new ArrayList<>();
    private List<Members> memberList = new ArrayList<>();
    private List<Library> librarySetup = new ArrayList<>();
    public List<Library> getLibrarySetup(){
        return librarySetup;
    }
    public void setLibrarySetup(Library libraryDetails){
        librarySetup.add(libraryDetails);
    }
    public static DataLayer getInstance(){
        if(dataLayer==null){
            dataLayer= new DataLayer();
        }
        return dataLayer;
    }
    public  List<Book> getBookList(){
        return bookList;
    }
    public Book searchBookById(int id){
        for(Book book : bookList){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }
    /*public List<Book> getBookByName(String name){
        List<Book>  searchBookList = new ArrayList<>();
        for(Book book : bookList){
            if(book.getName().contains(name)){
                searchBookList.add(book);
            }
        }
        return searchBookList;
    }*/
    public boolean isNewBook(Book book){
        for(Book check:bookList){
            if(check.getName().equals(book.getName()) && check.getVolume()==book.getVolume()){
                return false;
            }
        }
        bookList.add(book);
        return true;
    }
    public boolean isNewMember(Members members){
        for(Members check:memberList){
            if(check.getName().equals(members.getName()) && check.getId()==members.getId()){
                return false;
            }
        }
        memberList.add(members);
        return true;
    }
    public  List<Members> getMemberList(){
        return memberList;
    }

    public void removeMembers(int id){
        for(Members members:memberList){
            if(members.getId()==id){
                memberList.remove(members);
                break;
            }
        }
    }


}
