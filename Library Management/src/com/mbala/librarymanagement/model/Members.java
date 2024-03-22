package com.mbala.librarymanagement.model;

import java.util.ArrayList;

public class Members {
    private String name;
   private int id;
   private String emailId;
   private String phoneNo;
   private String address;
   private ArrayList<String> bookList = new ArrayList<>();
   private ArrayList<Integer> bookId = new ArrayList<>();

    public ArrayList<String> getBookList() {
        return bookList;
    }
    public ArrayList<Integer> getBookid(){
        return bookId;
    }

    public void setBookList(String bookList,int bookId) {
        this.bookList.add(bookList);
        this.bookId.add(bookId);
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
