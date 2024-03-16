package com.mbala.librarymanagement.managebook;
import  com.mbala.librarymanagement.model.Book;

public class ManageBookModel {
    private  ManageBookView manageBookView;
    private  Book book;
    ManageBookModel(ManageBookView manageBookView) {
                this.manageBookView = new ManageBookView();}
    }
     void bookSetup(String name , int id ,
                           String author,String publication,String edition,
                           String journer,int count, int volume){
        book.setName(name);
        book.setId(id);
        book.setAuthor(author);
        book.setEdition(edition);
        book.setJourner(journer);
        book.setPublication(publication);
        book.setAvailableCount(count);
        book.setVolume(volume);
        manageBookView.doYouWantToAddMoreBook();
      //  System.out.println(book.getAuthor());
    }
}
