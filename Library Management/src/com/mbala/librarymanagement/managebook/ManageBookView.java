package com.mbala.librarymanagement.managebook;

import java.util.Scanner;

public class ManageBookView {
    private ManageBookModel manageBookModel;
   public ManageBookView() {
          this.manageBookModel = new ManageBookModel(this);
    }
    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Book Name : ");
        String name = in.nextLine();
        System.out.println("Enter id : ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter Author : ");
        String author = in.nextLine();
        System.out.println("Enter Publication : ");
        String publication = in.nextLine();
        System.out.println("Enter edition : ");
        String edition = in.nextLine();
        System.out.println("Enter journer : ");
        String journer = in.nextLine();
        System.out.println("Enter available count : ");
        int count = in.nextInt();
        System.out.println("Enter volume : ");
        int volume = in.nextInt();
        manageBookModel.bookSetup(name,id,author,publication,edition,journer,count,volume);
       // doYouWantToAddMoreBook();
    }
    public void doYouWantToAddMoreBook(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nClick 1 -----> To add more books\nClick 2 -----> To view books");
        int nextStep = in.nextInt();
        if (nextStep == 1) {
            init();
        } else {
            System.out.println("Please enter valid input");
        }
    }

}
