package com.mbala.librarymanagement.model;

public class Library {
    private static String libraryName;
    private static int libraryId;
    private static String phoneNo;
    private static String emailId;
    private static String address;
    public boolean isFieldEmpty(){
        return libraryId==0;
    }
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public String getLibraryName() {
        return libraryName;
    }
    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }
    public int getLibraryId() {
        return libraryId;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
}
