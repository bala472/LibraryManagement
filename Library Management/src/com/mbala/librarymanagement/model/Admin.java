package com.mbala.librarymanagement.model;

public class Admin {
    private String name;
   private int id;
    private String emailId;
   private String phoneNo;
   private String address;
   void setName(String name){
       this.name=name;
   }
   String getName(){
       return name;
   }
   void  setId(int id){
       this.id = id;
   }
   int getId(){
       return id;
   }
   void  setAddress(String address){
       this.address = address;
   }
   String getAddress(){
       return address;
   }
   void setPhoneNo(String phoneNo){
       this.phoneNo=phoneNo;
   }
   String getPhoneNo(){
       return phoneNo;
   }
   void setEmail(String email){
      this.emailId=emailId;
   }
   String getEmail(){
       return emailId;
   }
}
