package com.mbala.librarymanagement.member;

import java.util.Scanner;
import com.mbala.librarymanagement.model.Members;

public class MemberView {
    private MemberModel memberModel;
    public MemberView(){
        memberModel=new MemberModel(this);
    }
    public void addMember(){
        Members members = new Members();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Member's Name : ");
        members.setName(in.nextLine());
        System.out.println("Enter Member's Id : ");
        members.setId(in.nextInt());
        in.next();
        System.out.println("Enter email address : ");
        members.setEmail(in.nextLine());
        System.out.println("Enter phone number : ");
        members.setPhoneNo(in.nextLine());
        System.out.println("Enter address : ");
        members.setAddress(in.nextLine());
    }
}
