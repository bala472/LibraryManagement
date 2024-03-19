package com.mbala.librarymanagement.model;

public class Members {
    private String name;
   private int id;
    private String emailId;
   private String phoneNo;
   private String address;
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
      this.emailId=emailId;
   }
   public String getEmail(){
       return emailId;
   }
}
