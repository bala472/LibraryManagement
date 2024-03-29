package com.mbala.librarymanagement.librarysetup;
import com.mbala.librarymanagement.managebook.ManageBookView;
import  com.mbala.librarymanagement.model.Library;

import java.util.Scanner;

public class LibrarySetupView {
    private Library library; 
    private LibrarySetupModel librarySetupModel;
    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }
    public void init() {
       librarySetupModel.startSetup();
    }
    public void initiateSetup() {
        this.library=new Library();
        System.out.println("\nPlease Fill Library Details From Here.\n\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Library Name : ");
        library.setLibraryName(in.nextLine());
     /*   System.out.println("Enter Library Id : ");
        int id =in.nextInt();
        library.setLibraryId(id);*/
        System.out.println("Enter Phone Number : ");
        library.setPhoneNo(in.nextLine());
        System.out.println("Enter Emailid : ");
        library.setEmailId(in.nextLine());
        System.out.println("Enter Address : ");
        library.setAddress(in.nextLine());
        librarySetupModel.addLibraryList(library);
        System.out.println("\nLibrary setup completed successfully\n");
        librarySetupModel.startSetup();
    }
    public void onSetupComplete() {
        new ManageBookView().mainMenu();
    }
}
