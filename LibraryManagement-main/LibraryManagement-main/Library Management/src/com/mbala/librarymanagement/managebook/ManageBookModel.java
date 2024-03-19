package com.mbala.librarymanagement.managebook;
import com.mbala.librarymanagement.datalayer.DataLayer;
import  com.mbala.librarymanagement.model.Book;

import java.util.Arrays;

public class ManageBookModel {
    private  ManageBookView manageBookView;
    private  Book book;
    ManageBookModel(ManageBookView manageBookView) {
                this.manageBookView = manageBookView;
                this.book = new Book();
    }
     void bookSetup(String name , int id ,
                           String author,String publication,String edition,
                           String journer,int count, int volume){
        this.book =new Book();
        book.setName(name);
        book.setId(id);
        book.setAuthor(author);
        book.setEdition(edition);
        book.setJourner(journer);
        book.setPublication(publication);
        book.setAvailableCount(count);
        book.setVolume(volume);
        if( DataLayer.getInstance().isNewBook(book)){
            DataLayer.getInstance().isNewBook(book);
            manageBookView.showSucess();
        }
        else{
            manageBookView.showAlreadyAdded();
        }
        manageBookView.doYouWantToAddMoreBook();
    }
    public void viewBook(){
         manageBookView.showBook(DataLayer.getInstance().getBookList());
    }
    public void searchBook(int id){
        Book temp = DataLayer.getInstance().searchBookById(id);
        manageBookView.showSearchedBooks(temp.getName(),temp.getId(),temp.getAuthor());
    }
}
