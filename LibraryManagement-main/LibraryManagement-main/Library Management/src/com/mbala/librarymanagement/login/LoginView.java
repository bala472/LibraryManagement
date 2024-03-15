package com.mbala.librarymanagement.login;

import java.util.Scanner;

public class LoginView {
    private  LoginModel loginModel;
    public LoginView(){
       loginModel= new LoginModel(this);
    }
 public void init(){
     Scanner in = new Scanner(System.in);
     System.out.println("Enter User Name : ");
     String userName = in.nextLine();
     System.out.println("Enter Password : ");
     String passWord = in.nextLine();
     in.close();
     System.out.println(loginModel.validateUser(userName, passWord));
     
 }
}
