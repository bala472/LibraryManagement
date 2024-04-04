package com.mbala.librarymanagement.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Members {
    private String name;
   private int id;
   private String emailId;
   private String phoneNo;
   private String address;
   private ArrayList<String> bookList = new ArrayList<>(3);
   private ArrayList<Integer> bookId = new ArrayList<>(3);

   private  ArrayList<String> issuedBookDate = new ArrayList<>(3);

   private ArrayList<String> returnBookDate = new ArrayList<>(3);

    public ArrayList<String> getBookList() {
        return bookList;
    }
    public ArrayList<Integer> getBookid(){
        return bookId;
    }

    public ArrayList<String> getIssuedBookDate(){return issuedBookDate;}
    public ArrayList<String> getReturnBookDate(){return returnBookDate;}

    public void setBookList(String bookList,int bookId) {
        this.bookList.add(bookList);
        this.bookId.add(bookId);
        this.issuedBookDate.add(LocalDate.now().toString());
        this.returnBookDate.add(LocalDate.now().plusDays(30).toString());
    }

    public void setName(String name){
       this.name=name;
   }
   public String getName(){
       return name;
   }
   public void  setId(int id){
       this.id = id;
   }
   public int getId(){
       return id;
   }
   public void  setAddress(String address){
       this.address = address;
   }
   public String getAddress(){
       return address;
   }
   public void setPhoneNo(String phoneNo){
       this.phoneNo=phoneNo;
   }
   public String getPhoneNo(){
       return phoneNo;
   }
   public void setEmail(String email){
      this.emailId=email;
   }
   public String getEmail(){
       return emailId;
   }

}
