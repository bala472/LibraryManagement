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
        Book book = new Book();
        try{
        Scanner in = new Scanner(System.in);
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
        }
        catch(Exception e){
            System.out.println("\nWarning : Input must be number for the above field\n");
            init();
        }
        return book;
    }

    public void mainMenu() {
        try{
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
            System.out.println("\n--- Logged out successfully ---\n");
            if (loginView == null) {
                loginView = new LoginView();
                loginView.init();
            } else {
                loginView.init();
            }
        }else{
            System.out.println("\nPlease enter valid input\n");
            mainMenu();
        }
        }catch(Exception e){
            System.out.println("\nInput must be number\n");
            mainMenu();
        }
    }
    public void bookMenu(){
        try{
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
            System.out.println("\nPlease enter valid number in the menu\n");
            bookMenu();
        }
    }catch(Exception e){
        System.out.println("\nInput must be number\n");
        bookMenu();
    }
    }
    public void memberMenu(){
        try{
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
            System.out.println("\nPlease enter valid number in the menu\n");
            memberMenu();
        }
    }catch(Exception e){
        System.out.println("\nInput must be number\n");
        memberMenu();
    }
    }
    public void manageBorrowReturnBookMenu(){
        try{
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
            System.out.println("\nPlease enter valid input\n");
            manageBorrowReturnBookMenu();
        }
    }catch(Exception e){
        System.out.println("\nInput must be number\n");
        manageBorrowReturnBookMenu();
    }
    }

    public void showSearchedBooks(Book book) {
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", "Book Name", "Book Id", "Author", "Publication", "Journal", "Edition", "Volume", "Count");
        System.out.printf("%-30s %-10s %-18s %-20s %-20s %-8s %-7s %-6s\n", book.getName(), book.getId(), book.getAuthor(), book.getPublication(), book.getJourner(), Integer.toString(book.getEdition()), Integer.toString(book.getVolume()), book.getAvailableCount());
        bookMenu();
    }


    public void showSucess() {
        System.out.println("\nBook added successfully !!!\n");
    }

    public void showAlreadyAdded() {
        System.out.println("\nBook already added\n");
    }

    public void showUpdateStatus(int status){
        if(status == 1){
            System.out.println("\nBook Updated Sucessfully\n");
            bookMenu();
        }
        System.out.println("\nBook Not Found\n");
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
