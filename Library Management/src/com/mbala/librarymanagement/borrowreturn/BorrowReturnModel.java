package com.mbala.librarymanagement.borrowreturn;

import com.mbala.librarymanagement.datalayer.DataLayer;
import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.model.BorrowReturnBook;
import com.mbala.librarymanagement.model.Members;

import java.io.File;
import java.lang.reflect.Member;
import java.util.List;


public class BorrowReturnModel {
    private BorrowReturnBookView borrowReturnBookView;

    BorrowReturnModel(BorrowReturnBookView borrowReturnBookView) {
        this.borrowReturnBookView = borrowReturnBookView;
    }

   /* public void validateUserBook(int userId,int bookId) {

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
    }*/
   public void validateUserBook(int userId,int bookId){
       for(Members members : DataLayer.getInstance().getMemberList()){
           if(members.getId()==userId){
               if(members.getBookList().size()>=3){
                   borrowReturnBookView.showAlert(3);
                   return;
               }
               else if(validateBook(bookId, members)){
                   borrowReturnBookView.showAlert(2);
                   return;
               }else{
                  borrowReturnBookView.showAlert(1);
                  return;
               }
           }
       }
       borrowReturnBookView.showAlert(0);
   }
   public boolean validateBook(int bookId,Members members){
       for(Book book : DataLayer.getInstance().getBookList()){
           if(book.getId()==bookId){
               if(book.getAvailableCount()<=0){
                   borrowReturnBookView.showAlert(4);
                   return false;
               }
               book.setAvailableCount(book.getAvailableCount()-1);
               new File("book.json").delete();
               DataLayer.getInstance().setBookListJson();
               members.setBookList(book.getName(),book.getId());
               new File("member.json").delete();
               DataLayer.getInstance().setMemberListJson();
               return true;
           }
       }
       return false;
   }


    public  void validateReturnBook(int userId,int bookId){
        for(Members members: DataLayer.getInstance().getMemberList()){
            if(members.getId()==userId){
                if(members.getBookid().isEmpty()){
                    borrowReturnBookView.showAlertReturn(1);
                }else{
                    removeBookFromUSerList(members,bookId);
                }
            }
        }
        borrowReturnBookView.showAlertReturn(0);
    }
    public void removeBookFromUSerList(Members members,int bookid){
        for(int i=0;i<3;i++){
            if(members.getBookid().get(i)==bookid){
                members.getBookid().remove(i);
                members.getBookList().remove(i);
                members.getIssuedBookDate().remove(i);
                members.getReturnBookDate().remove(i);
                new File("member.json").delete();
                DataLayer.getInstance().setMemberListJson();
                addBookCount(bookid);
                return;
            }
        }
        borrowReturnBookView.showAlertReturn(1);
    }
    public void addBookCount(int bookId){
        for(Book book:DataLayer.getInstance().getBookList()){
            if(book.getId()==bookId){
                book.setAvailableCount(book.getAvailableCount()+1);
                new File("book.json").delete();
                DataLayer.getInstance().setBookListJson();
                borrowReturnBookView.showAlertReturn(2);
                return;
            }
        }
    }




     /*public void validateReturnBook(int userId, int bookId) {
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
                                if(members.getBookid().isEmpty())
                                    continue ;
                               for(int i=0;i<members.getBookid().size();i++){
                                if(members.getBookid().get(i)==bookId){
                                    book.setAvailableCount(book.getAvailableCount() + 1);
                                    members.getBookid().remove(i);
                                    members.getBookList().remove(i);
                                    members.getIssuedBookDate().remove(i);
                                    members.getReturnBookDate().remove(i);
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
    }*/

}
