package com.mbala.librarymanagement.login;

import java.util.Scanner;

import com.mbala.librarymanagement.LibraryManagement;
import com.mbala.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView {
    private LoginModel loginModel;

    public LoginView() {
        loginModel = new LoginModel(this);
    }

    public void init() {
        System.out.println("----- " + LibraryManagement.getInstance().getAppName() + " (" + LibraryManagement.getInstance().getAppVersion() + ") -----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease login to proceed.");
        System.out.println("\nEnter User Name:");
        String userName = scanner.next();
        System.out.println("\nEnter the password:");
        String password = scanner.next();
        loginModel.validateUser(userName, password);
    }

    public void onSuccess() {
        System.out.println("\n--- Login successful ---\n");
        System.out.println ("\n ---- welcome to " + LibraryManagement.getInstance().getAppName()
                + " (" + LibraryManagement.getInstance().getAppVersion() + ") ---- ");
        LibrarySetupView librarySetupView = new LibrarySetupView();
        librarySetupView.init();
    }

    public void showAlert(String alertText) {
        System.out.println(alertText);
        init();
    }
}
