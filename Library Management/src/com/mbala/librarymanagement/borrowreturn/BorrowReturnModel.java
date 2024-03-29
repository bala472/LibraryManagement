package com.mbala.librarymanagement.borrowreturn;

import com.mbala.librarymanagement.datalayer.DataLayer;
import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.BorrowReturnBook;
import com.mbala.librarymanagement.model.Members;

import java.io.File;


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
                       // book.setAvailableCount((book.getAvailableCount()) - 1);
                        if(member.getBookList().size()<=3){
                            book.setAvailableCount((book.getAvailableCount()) - 1);
                            member.setBookList(book.getName(),book.getId());
                            DataLayer.getInstance().setBorrowBook(borrowReturnBook);
                            new File("borrowBook.json").delete();
                            new File("book.json").delete();
                            new File("member.json").delete();
                            DataLayer.getInstance().setBorrowBookListJson(DataLayer.getInstance().getBorrowBookList());
                            DataLayer.getInstance().setBookListJson(DataLayer.getInstance().getBookList());
                            DataLayer.getInstance().setMemberListJson(DataLayer.getInstance().getMemberList());

                        }
                        else{
                            flag=3;
                        }
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
        if (flag ==3)
            borrowReturnBookView.showAlert(3);
    }

    public void validateReturnBook(int userId, int bookId) {
        int flag = 0;
        int count =0;
    L1:    for (BorrowReturnBook borrowReturnBook : DataLayer.getInstance().getBorrowBookList()) {
           
            if (userId == borrowReturnBook.getUserId()) {
                flag = 1;
                if (bookId == borrowReturnBook.getBookId()) {
                    flag = 2;
                    for (Book book : DataLayer.getInstance().getBookList()) {
                        if (bookId == book.getId()) {
                            //book.setAvailableCount(book.getAvailableCount() + 1);
                            for(Members members: DataLayer.getInstance().getMemberList()){
                               for(int i=0;i<members.getBookid().size();i++){
                                if(members.getBookid().get(i)==bookId){
                                    book.setAvailableCount(book.getAvailableCount() + 1);
                                    members.getBookid().remove(i);
                                    members.getBookList().remove(i);
                                    DataLayer.getInstance().getBorrowBookList().remove(count);
                                    new File("book.json").delete();
                                    new File("member.json").delete();
                                    new File("borrowBook.json").delete();
                                    DataLayer.getInstance().setBookListJson(DataLayer.getInstance().getBookList());
                                    DataLayer.getInstance().setMemberListJson(DataLayer.getInstance().getMemberList());
                                    DataLayer.getInstance().setBorrowBookListJson(DataLayer.getInstance().getBorrowBookList());
                                  break L1;
                                }
                               }
                            }
                        }
                    }
                }
            }
            count++;
        }
        if (flag == 0)
            borrowReturnBookView.showAlertReturn(0);
        if (flag == 1)
            borrowReturnBookView.showAlertReturn(1);
        if (flag == 2)
            borrowReturnBookView.showAlertReturn(2);
    }
}
