package com.mbala.librarymanagement.managebook;
import com.mbala.librarymanagement.datalayer.DataLayer;
import  com.mbala.librarymanagement.model.Book;

public class ManageBookModel {
    private  ManageBookView manageBookView;
    private  Book book;
    ManageBookModel(ManageBookView manageBookView) {
                this.manageBookView = manageBookView;
                this.book = new Book();
    }
     void bookSetup(String name , int id ,
                           String author,String publication,int edition,
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
        manageBookView.mainMenu();
    }
    public void viewBook(){
         manageBookView.showBook(DataLayer.getInstance().getBookList());
    }
    public void searchBook(int id){
        Book bookNameList = DataLayer.getInstance().searchBookById(id);
        manageBookView.showSearchedBooks(bookNameList.getName(),bookNameList.getId(),bookNameList.getAuthor(),bookNameList.getPublication(),bookNameList.getJourner(),bookNameList.getEdition(),bookNameList.getVolume(),bookNameList.getAvailableCount());
    }
}
