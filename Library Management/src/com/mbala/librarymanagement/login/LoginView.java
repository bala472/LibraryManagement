package com.mbala.librarymanagement.login;

import java.util.Scanner;

public class LoginView {
 public void init(){
     Scanner in = new Scanner(System.in);
     System.out.println("Enter name : ");
     String userName = in.nextLine();
     String passWord = in.nextLine();
     in.close();
     if(userName.equals("bala")&&passWord.equals("12345678")){
         System.out.println("Logged in sucessfully");
     }else{
         System.out.println("Login failed");
     }
 }
}
