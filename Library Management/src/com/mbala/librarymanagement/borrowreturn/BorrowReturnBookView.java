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
    try{
        Scanner in = new Scanner(System.in);
        BorrowReturnBook borrowReturnBook = new BorrowReturnBook();
        System.out.println("Enter User ID : ");
        int userId = in.nextInt();
        System.out.println("Enter Book ID : ");
        int bookId = in.nextInt();
        borrowReturnModel.validateUserBook(userId,bookId);
    }catch(Exception e){
        System.out.println("\nID must be number\n");
        borrowBook();
    } 
   }
   public void showAlert(int flag){
        if(flag==0){
        System.out.println("\nInvalid User Id\n");
        }
        if(flag==1){ System.out.println("\nInvalid Book Id\n");
        }
        if(flag==2){
        System.out.println("\nBook borrowed successfully\n");
        }
        if(flag==3)
        System.out.println("\nUser already taken 3 books.Please return books to continue\n");
        if(flag==4)
            System.out.println("\nBook Currently not available\n");
        doYouWantContinue();
   }
   public void doYouWantContinue(){
    try{
        Scanner in = new Scanner(System.in);
        System.out.println("Click 1 -----> To borrow more books ");
        System.out.println("Click 2 -----> Go to Main Menu");
        int nextStep = in.nextInt();
        if(nextStep==1){
            borrowBook();
        }
        if(nextStep==2){
            ManageBookView manageBookView = new ManageBookView();
            manageBookView.manageBorrowReturnBookMenu();
        }else {
            System.out.println("\nInvalid input\n");
            doYouWantContinue();
        }
    }catch(Exception e){
        System.out.println("\nInput must be number\n");
        doYouWantContinue();
    } 
   }
  public void returnBook(){
    try{
      Scanner in = new Scanner(System.in);
      System.out.println("Enter User ID : ");
      int userId=in.nextInt();
      System.out.println("Enter Book ID : ");
      int bookId = in.nextInt();
      System.out.println(userId+" "+bookId);
      borrowReturnModel.validateReturnBook(userId,bookId);
      System.out.println(userId+" "+bookId);
    }catch(Exception e){
        System.out.println("\nID must be number\n");
        returnBook();
    }  
  }
    public void showAlertReturn(int flag){
        if(flag==0) {
            System.out.println("\nInvalid User Id\n ");
        }
        if(flag==1) {
            System.out.println("\nInvalid Book Id\n");
        }
        if(flag==2){
            System.out.println("\nBook returned successfully\n");
        }
        doYouWantContinueReturn();
    }
    public void doYouWantContinueReturn(){
        System.out.println("Entered doyouwantcontinuereturn");
        try{
         Scanner sc = new Scanner(System.in);
        System.out.println("Click 1 -----> To return more books ");
        System.out.println("Click 2 -----> Go to Main Menu");
        int nextStep = sc.nextInt();
        if(nextStep==1){
            returnBook();
        }
        if(nextStep==2){
            ManageBookView manageBookView = new ManageBookView();
            manageBookView.manageBorrowReturnBookMenu();
        }else {
            System.out.println("\nInvalid input\n");
            doYouWantContinueReturn();
        }
        }catch(Exception e){
            System.out.println("\nInput must be number\n");
            doYouWantContinueReturn();
        }
        
    }
}
