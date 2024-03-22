package com.mbala.librarymanagement.borrowreturn;

import com.mbala.librarymanagement.datalayer.DataLayer;
import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.BorrowReturnBook;
import com.mbala.librarymanagement.model.Members;


public class BorrowReturnModel {
    private BorrowReturnBookView borrowReturnBookView;

    BorrowReturnModel(BorrowReturnBookView borrowReturnBookView) {
        this.borrowReturnBookView = borrowReturnBookView;
    }

    public void validateUserBook(BorrowReturnBook borrowReturnBook) {
        int flag = 0;
        for (Members member : DataLayer.getInstance().getMemberList()) {
            if (member.getId() == borrowReturnBook.getUserId()) {
                flag = 1;
                for (Book book : DataLayer.getInstance().getBookList()) {
                    if (book.getId() == borrowReturnBook.getBookId() && book.getAvailableCount() != 0) {
                        flag = 2;
                        book.setAvailableCount((book.getAvailableCount()) - 1);
                        if(member.getBookList().size()<=3){
                            member.setBookList(book.getName(),book.getId());
                            DataLayer.getInstance().setBorrowBook(borrowReturnBook);
                        }
                        else{
                            System.out.println("User already taken 3 books.Please return books to continue");
                        }

                        //   borrowReturnBook.setBorrowedBooks(borrowReturnBook.getBorrowedBooks()+1);

                    }
                }
            }
        }
        if (flag == 0)
            borrowReturnBookView.showAlert(0);
        if (flag == 1)
            borrowReturnBookView.showAlert(1);
        if (flag == 2)
            borrowReturnBookView.showAlert(2);
    }

    public void validateReturnBook(int userId, int bookId) {
        int flag = 0;
        for (BorrowReturnBook borrowReturnBook : DataLayer.getInstance().getBorrowBookList()) {
            if (userId == borrowReturnBook.getUserId()) {
                flag = 1;
                if (bookId == borrowReturnBook.getBookId()) {
                    flag = 2;
                    for (Book book : DataLayer.getInstance().getBookList()) {
                        if (bookId == book.getId()) {
                            book.setAvailableCount(book.getAvailableCount() + 1);
                            for(Members members: DataLayer.getInstance().getMemberList()){
                                for(int i: members.getBookid())
                                if(i==bookId){
                                    members.getBookList().remove(i);
                                    members.getBookid().remove((Integer)i);
                                   // members.setBookList(null,0);
                                }
                            }
                            //  borrowReturnBook.setBorrowedBooks(borrowReturnBook.getBorrowedBooks()-1);
                            break;
                        }
                    }
                }
            }
        }
        if (flag == 0)
            borrowReturnBookView.showAlertReturn(0);
        if (flag == 1)
            borrowReturnBookView.showAlertReturn(1);
        if (flag == 2)
            borrowReturnBookView.showAlertReturn(2);
    }
}