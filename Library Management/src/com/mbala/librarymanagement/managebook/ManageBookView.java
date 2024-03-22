package com.mbala.librarymanagement.managebook;

import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.member.MemberView;

import java.util.List;
import java.util.Scanner;

public class ManageBookView {
    private ManageBookModel manageBookModel;
   /* private MemberView memberViews;
    private MemberView getInstance(){
        if(memberViews==null){
            memberViews= new MemberView();
        }
        return memberViews;
    }
    */
    private  MemberView memberView = new MemberView();
   public ManageBookView() {
       manageBookModel = new ManageBookModel(this);
    }
    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Book Name : ");
        String name = in.nextLine();
        System.out.println("Enter id : ");
        int id = in.nextInt();
        System.out.println("Enter Author : ");
        in.nextLine();
        String author = in.nextLine();
        System.out.println("Enter Publication : ");
        String publication = in.nextLine();
        System.out.println("Enter edition : ");
        int edition = in.nextInt();
        System.out.println("Enter journer : ");
        in.nextLine();
        String journer = in.nextLine();
        System.out.println("Enter available count : ");
        int count = in.nextInt();
        System.out.println("Enter volume : ");
        int volume = in.nextInt();
        manageBookModel.bookSetup(name,id,author,publication,edition,journer,count,volume);
    }

    public void mainMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nClick 1 -----> To add more books\nClick 2 -----> To view books\nClick 3 -----> To Search books\nClick 4 -----> To add members\nClick 5 -----> To view members\nClick 6 -----> To remove members\nClick 7 -----> Logout Session");
        int nextStep = in.nextInt();
        if (nextStep == 1) {
            init();
        } else if (nextStep==2) {
           manageBookModel.viewBook();
        }else if(nextStep==3){
            System.out.println("Enter Book id to search : ");
            Scanner sc= new Scanner(System.in);
            manageBookModel.searchBook(sc.nextInt());
        }else if(nextStep==4){
            memberView.addMember();
            mainMenu();
        }
        else if(nextStep==5){
            memberView.showMembers();
            mainMenu();
        }else if(nextStep==6){
            memberView.removeMember();
            mainMenu();
        } else if (nextStep==7) {
            System.out.println("Logged out successfully");
            
        } else {
            System.out.println("Please enter valid input");
            mainMenu();
        }
    }

    public void showSearchedBooks(String name, int id, String author, String publication, String journal, int edition, int volume) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", name, id, author, publication, journal, Integer.toString(edition), Integer.toString(volume));
        mainMenu();
    }


    public void showSucess(){
        System.out.println("Book added successfully");
    }
    public void showAlreadyAdded(){
        System.out.println("Book already added");
    }

    public void showBook(List<Book> bookList) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume");
        for (Book book : bookList) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", book.getName(), book.getId(), book.getAuthor(), book.getPublication(), book.getJourner(), book.getEdition(), book.getVolume());
        }
        mainMenu();
    }

}
