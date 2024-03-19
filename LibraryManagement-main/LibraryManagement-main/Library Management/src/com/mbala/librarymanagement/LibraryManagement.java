package com.mbala.librarymanagement;

import com.mbala.librarymanagement.login.LoginView;
public class LibraryManagement {
    private static  LibraryManagement libraryManagement;
    private String appName = "Library Management System";
    private String appVersion = "1.0";
    private LibraryManagement() {
    }
    public static LibraryManagement getInstance() {
        if(libraryManagement == null) {
            libraryManagement = new LibraryManagement();
        }
        return libraryManagement;
    }
    private void create() {
        LoginView loginView = new LoginView();
        loginView.init();
    }
    public String getAppName() {
        return appName;
    }
    public String getAppVersion() {
        return appVersion;
    }
    public static void main(String[] arg) {
       LibraryManagement begin = LibraryManagement.getInstance();
       begin.create();
    }
}