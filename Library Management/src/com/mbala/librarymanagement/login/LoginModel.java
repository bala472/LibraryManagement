package com.mbala.librarymanagement.login;

import com.mbala.librarymanagement.datalayer.DataLayer;

import java.io.IOException;

class LoginModel {


    private LoginView loginView;
    LoginModel(LoginView loginView) {
        this.loginView = loginView;
    }

    public void validateUser(String userName, String password)  {
        if (isValidUserName(userName)) {
            if (isValidPassword(password)) {
                if(DataLayer.getInstance().getBookList().isEmpty())
                DataLayer.getInstance().loadBookListJson();
                if(DataLayer.getInstance().getMemberList().isEmpty())
                DataLayer.getInstance().loadMemberListJson();
                if(DataLayer.getInstance().getBorrowBookList().isEmpty())
                    DataLayer.getInstance().loadBorrowBookListJson();
                if(DataLayer.getInstance().getLibrarySetup()==null)
                DataLayer.getInstance().loadLibraryJson();
                loginView.onSuccess();
            } else {
                loginView.showAlert("\nInvalid password");
            }
        } else {
            loginView.showAlert("\nInvalid User Name");
        }
    }

    private boolean isValidUserName(String userName) {
        return userName.equals("bala");
    }

    private boolean isValidPassword(String password) {
        return password.equals("1234");
    }
}
