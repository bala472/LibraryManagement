package com.mbala.librarymanagement.managebook;

import com.mbala.librarymanagement.model.Book;
import com.mbala.librarymanagement.member.MemberView;
import com.mbala.librarymanagement.login.LoginView;
import com.mbala.librarymanagement.borrowreturn.BorrowReturnBookView;

import java.util.List;
import java.util.Scanner;

public class ManageBookView {
    private ManageBookModel manageBookModel;
    private MemberView memberView = new MemberView();
    private BorrowReturnBookView borrowReturnBookView = new BorrowReturnBookView();
    private LoginView loginView;

    public ManageBookView() {
        manageBookModel = new ManageBookModel(this);
    }

    public Book init() {
        Scanner in = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter Book Name : ");
        book.setName(in.nextLine());
        System.out.println("Enter id : ");
        book.setId(in.nextInt());
        System.out.println("Enter Author : ");
        in.nextLine();
        book.setAuthor(in.nextLine());
        System.out.println("Enter Publication : ");
        book.setPublication(in.nextLine());
        System.out.println("Enter edition : ");
        book.setEdition(in.nextInt());
        System.out.println("Enter journer : ");
        in.nextLine();
        book.setJourner(in.nextLine());
        System.out.println("Enter available count : ");
        book.setAvailableCount(in.nextInt());
        System.out.println("Enter volume : ");
        book.setVolume(in.nextInt());
        return book;
    }

    public void mainMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nClick 1 -----> Add Books" +
                "\nClick 2 -----> View Books" +
                "\nClick 3 -----> Search Books\n" +
                "Click 4 -----> Add Members" +
                "\nClick 5 -----> View Members\n" +
                "Click 6 -----> Remove Members\n" +
                "Click 7 -----> Borrow Books");
        System.out.println("Click 8 -----> Return Books");
        System.out.println("Click 9 -----> Logout Session");
        System.out.println("Enter 10 -----> Update Book Details");
        int nextStep = in.nextInt();
        if (nextStep == 1) {
            manageBookModel.bookSetup(init());
        } else if (nextStep == 2) {
            manageBookModel.viewBook();
        } else if (nextStep == 3) {
            System.out.println("Enter Book Name to search : ");
           // Scanner sc = new Scanner(System.in);
           in.nextLine();
            manageBookModel.searchBook(in.nextLine());
        } else if (nextStep == 4) {
            memberView.addMember();
            mainMenu();
        } else if (nextStep == 5) {
            memberView.showMembers();
            mainMenu();
        } else if (nextStep == 6) {
            memberView.removeMember();
            mainMenu();
        } else if (nextStep == 7) {
            borrowReturnBookView.borrowBook();
        } else if (nextStep == 8) {
            borrowReturnBookView.returnBook();
        } else if (nextStep == 9) {
            System.out.println("Logged out successfully\n\n");
            if (loginView == null) {
                loginView = new LoginView();
                loginView.init();
            } else {
                loginView.init();
            }
        } else if(nextStep == 10){
           manageBookModel.updateBook(init());
        }
        else {
            System.out.println("Please enter valid input");
            mainMenu();
        }
    }

    public void showSearchedBooks(Book book) {
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume", "Count");
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", book.getName(), book.getId(), book.getAuthor(), book.getPublication(), book.getJourner(), Integer.toString(book.getEdition()), Integer.toString(book.getVolume()), book.getAvailableCount());
        mainMenu();
    }


    public void showSucess() {
        System.out.println("Book added successfully");
    }

    public void showAlreadyAdded() {
        System.out.println("Book already added");
    }

    public void showUpdateStatus(int status){
        if(status == 1){
            System.out.println("Book Updated Sucessfully ");
            mainMenu();
        }
        System.out.println("Book Not Found ");
        mainMenu();
    }

    public void showBook(List<Book> bookList) {
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume", "Count");
        for (Book book : bookList) {
            System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", book.getName(), book.getId(), book.getAuthor(), book.getPublication(), book.getJourner(), book.getEdition(), book.getVolume(), book.getAvailableCount());
        }
        mainMenu();
    }

}
