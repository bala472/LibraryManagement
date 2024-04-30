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
        System.out.println("Enter 1 ---> Book Management ");
        System.out.println("Enter 2 ---> Member Management");
        System.out.println("Enter 3 ---> Manage Borrowed & Returned Books");
        System.out.println("Enter 4 ---> Logout Session");
        int nextStep = in.nextInt();
        if(nextStep==1){
            bookMenu();
        } else if (nextStep==2) {
            memberMenu();
        } else if (nextStep==3) {
            manageBorrowReturnBookMenu();
        } else if (nextStep == 4) {
            System.out.println("Logged out successfully\n\n");
            if (loginView == null) {
                loginView = new LoginView();
                loginView.init();
            } else {
                loginView.init();
            }
        }else{
            System.out.println("Please enter valid input");
            mainMenu();
        }
    }
    public void bookMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 ---> Add Books");
        System.out.println("Enter 2 ---> View Books");
        System.out.println("Enter 3 ---> Search Books");
        System.out.println("Enter 4 ---> Update Book Details");
        System.out.println("Enter 5 ---> Exit Menu");
        int menu = in.nextInt();
        if (menu == 1) {
            manageBookModel.bookSetup(init());
        } else if (menu == 2) {
            manageBookModel.viewBook();
        } else if (menu == 3) {
            System.out.println("Enter Book Name to search : ");
            in.nextLine();
            manageBookModel.searchBook(in.nextLine());
        }else if(menu ==4){
            manageBookModel.updateBook(init());
        }
        else if (menu == 5) {
            mainMenu();
        }else {
            System.out.println("Please enter valid number in the menu");
            bookMenu();
        }
    }
    public void memberMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 ---> Add Members");
        System.out.println("Enter 2 ---> View Members");
        System.out.println("Enter 3 ---> Remove Members");
        System.out.println("Enter 4 ---> Exit Menu");
        int menu = in.nextInt();
        if(menu==1){
            memberView.addMember();
            memberMenu();
        }else if (menu == 2) {
            memberView.showMembers();
            memberMenu();
        } else if (menu == 3) {
            memberView.removeMember();
            memberMenu();
        } else if (menu==4) {
            mainMenu();
        }else {
            System.out.println("Please enter valid number in the menu");
            memberMenu();
        }
    }
    public void manageBorrowReturnBookMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 ---> Borrow Books");
        System.out.println("Enter 2 ---> Return Books");
        System.out.println("Enter 3 ---> Exit Menu");
        int menu = in.nextInt();
        if (menu == 1) {
            borrowReturnBookView.borrowBook();
        } else if (menu == 2) {
            borrowReturnBookView.returnBook();
        } else if (menu == 3) {
            mainMenu();
        }else {
            System.out.println("Please enter valid input");
            manageBorrowReturnBookMenu();
        }
    }

    public void showSearchedBooks(Book book) {
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume", "Count");
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", book.getName(), book.getId(), book.getAuthor(), book.getPublication(), book.getJourner(), Integer.toString(book.getEdition()), Integer.toString(book.getVolume()), book.getAvailableCount());
        bookMenu();
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
            bookMenu();
        }
        System.out.println("Book Not Found ");
        bookMenu();
    }

    public void showBook(List<Book> bookList) {
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume", "Count");
        for (Book book : bookList) {
            System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", book.getName(), book.getId(), book.getAuthor(), book.getPublication(), book.getJourner(), book.getEdition(), book.getVolume(), book.getAvailableCount());
        }
        bookMenu();
    }

}
