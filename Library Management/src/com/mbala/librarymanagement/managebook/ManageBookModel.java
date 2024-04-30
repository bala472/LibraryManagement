package com.mbala.librarymanagement.managebook;

import java.io.File;

import com.mbala.librarymanagement.datalayer.DataLayer;
import com.mbala.librarymanagement.model.Book;

public class ManageBookModel {
    private ManageBookView manageBookView;
    private Book book;

    ManageBookModel(ManageBookView manageBookView) {
        this.manageBookView = manageBookView;
        this.book = new Book();
    }

    public void bookSetup(Book book) {
        if (DataLayer.getInstance().isNewBook(book)) {
            manageBookView.showSucess();
        } else {
            manageBookView.showAlreadyAdded();
        }
        manageBookView.bookMenu();
    }

    public void viewBook() {
        manageBookView.showBook(DataLayer.getInstance().getBookList());
    }

    public void searchBook(String name) {
        Book bookNameList = DataLayer.getInstance().searchBookByName(name);
        if(bookNameList==null){
            manageBookView.showUpdateStatus(0);
        }
        manageBookView.showSearchedBooks(bookNameList);
    }
    public void updateBook(Book updateBook){
       for (Book book : DataLayer.getInstance().getBookList()){
            if(updateBook.getId() == book.getId()){
                book.setName(updateBook.getName());
                book.setAuthor(updateBook.getAuthor());
                book.setVolume(updateBook.getVolume());
                book.setEdition(updateBook.getEdition());
                book.setAvailableCount(updateBook.getAvailableCount());
                book.setPublication(updateBook.getPublication());
                book.setJourner(updateBook.getJourner());
                manageBookView.showUpdateStatus(1);
                new File("booklist.json").delete();
                DataLayer.getInstance().setBookListJson();
                return;
            }
        }
       manageBookView.showUpdateStatus(0);
    }
}
