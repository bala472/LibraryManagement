package com.mbala.librarymanagement.borrowreturn;
import com.mbala.librarymanagement.model.BorrowReturnBook;
import com.mbala.librarymanagement.managebook.ManageBookView;

import java.util.Scanner;

public class BorrowReturnBookView {
    private BorrowReturnModel borrowReturnModel;

    public BorrowReturnBookView(){
        borrowReturnModel= new BorrowReturnModel(this);
    }
   public void borrowBook(){
       Scanner in = new Scanner(System.in);
       BorrowReturnBook borrowReturnBook = new BorrowReturnBook();
       System.out.println("Enter User ID : ");
       borrowReturnBook.setUserId(in.nextInt());
       System.out.println("Enter Book ID : ");
       borrowReturnBook.setBookId(in.nextInt());
       borrowReturnModel.validateUserBook(borrowReturnBook);
   }
   public void showAlert(int flag){
        if(flag==0){
        System.out.println("\nInvalid User Id ");
        }
        if(flag==1){ System.out.println("\nInvalid Book Id ");
        }
        if(flag==2){
        System.out.println("\nBook borrowed successfully ");
        }
        doYouWantContinue();
   }
   public void doYouWantContinue(){
        Scanner in = new Scanner(System.in);
       System.out.println("Click 1 -----> To borrow more books ");
       System.out.println("Click 2 -----> Go to Main Menu");
       int nextStep = in.nextInt();
       if(nextStep==1){
           borrowBook();
       }
       if(nextStep==2){
           ManageBookView manageBookView = new ManageBookView();
         manageBookView.mainMenu();
       }else {
           System.out.println("Invalid input ");
           doYouWantContinue();
       }
   }
  public void returnBook(){
      Scanner in = new Scanner(System.in);
      BorrowReturnBook borrowReturnBook = new BorrowReturnBook();
      System.out.println("Enter User ID : ");
     // borrowReturnBook.setUserId(in.nextInt());
      int userId=in.nextInt();
      System.out.println("Enter Book ID : ");
      int bookId = in.nextInt();
     // borrowReturnBook.setBookId(in.nextInt());
      borrowReturnModel.validateReturnBook(userId,bookId);
  }
    public void showAlertReturn(int flag){
        if(flag==0) {
            System.out.println("\nInvalid User Id ");
        }
        if(flag==1)
            System.out.println("\nInvalid Book Id ");
        if(flag==2)
            System.out.println("\nBook returned successfully ");
        doYouWantContinueReturn();
    }
    public void doYouWantContinueReturn(){
        Scanner in = new Scanner(System.in);
        System.out.println("Click 1 -----> To return more books ");
        System.out.println("Click 2 -----> Go to Main Menu");
        int nextStep = in.nextInt();
        if(nextStep==1){
            returnBook();
        }
        if(nextStep==2){
            ManageBookView manageBookView = new ManageBookView();
            manageBookView.mainMenu();
        }else {
            System.out.println("Invalid input ");
            doYouWantContinueReturn();
        }
    }
}
