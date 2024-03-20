package com.mbala.librarymanagement.librarysetup;
import com.mbala.librarymanagement.managebook.ManageBookView;
import  com.mbala.librarymanagement.model.Library;

import java.util.Scanner;

public class LibrarySetupView {
    private Library library = new Library();
    private LibrarySetupModel librarySetupModel;
    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }
    public void init() {
       librarySetupModel.startSetup();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Library Name : ");
        String name = in.nextLine();
        library.setLibraryName(name);
        System.out.println("Enter Library Id : ");
        int id =in.nextInt();
        library.setLibraryId(id);
        System.out.println("Enter Phone Number : ");
        in.nextLine();
        String phoneNo = in.nextLine();
        library.setPhoneNo(phoneNo);
        System.out.println("Enter Emailid : ");
        String emailid= in.nextLine();
        library.setEmailId(emailid);
        System.out.println("Enter Address : ");
        String address = in.nextLine();
        library.setAddress(address);
        librarySetupModel.startSetup();
    }
    public void onSetupComplete() {
        System.out.println("\nLibrary setup completed successfully\n");
        new ManageBookView().mainMenu();
    }
   /* public void showAlert(String alert) {
        System.out.println("\nPrint any errors here.\n");
    }*/
    public void initiateSetup() {
        System.out.println("\nPlease Fill Library Details From Here.\n");
    }
}
