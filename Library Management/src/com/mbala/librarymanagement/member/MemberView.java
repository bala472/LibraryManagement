package com.mbala.librarymanagement.member;

import java.util.Scanner;

import com.mbala.librarymanagement.datalayer.DataLayer;
import com.mbala.librarymanagement.model.Members;

public class MemberView {
    private MemberModel memberModel;

    public MemberView() {
        memberModel = new MemberModel(this);
    }

    public void addMember() {
        try{
        Members members = new Members();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Member's Name : ");
        members.setName(in.nextLine());
        System.out.println("Enter Member's Id : ");
        members.setId(in.nextInt());
        System.out.println("Enter email address : ");
        in.nextLine();
        members.setEmail(in.nextLine());
        System.out.println("Enter phone number : ");
        members.setPhoneNo(in.nextLine());
        System.out.println("Enter address : ");
        members.setAddress(in.nextLine());
        memberModel.addMemberList(members);
        }catch(Exception e){
            System.out.println("Member id must be number");
            addMember();
        }
    }

    public void onSucess() {
        System.out.println("Member added successfully ");
    }

    public void alreadyExsists() {
        System.out.println("Member already added");
    }

    public void showMembers() {
        System.out.printf("%-20s %-10s %-15s %-32s %-40s %-30s %-7s %-40s %-40s\n", "Name", "Member ID", "Phone Number", "Email", "Address", "Book Name", "Book id", "Book Issued Date", "Book Return Date");
        for (Members members : DataLayer.getInstance().getMemberList()) {
            System.out.printf("%-20s %-10s %-15s %-32s %-40s %-30s %-7s %-40s %-40s\n", members.getName(), members.getId(), members.getPhoneNo(), members.getEmail(), members.getAddress(), members.getBookList(), members.getBookid(), members.getIssuedBookDate(), members.getReturnBookDate());
        }
    }

    public void removeMember() {
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter member id ");
            memberModel.removeMember(in.nextInt());
        }catch(Exception e){
            System.out.println("Member id must be number");
            removeMember();
        }
       
    }

    public void onSucessRemove() {
        System.out.println("Member removed successfully. If given id does not exists then none of the member is removed");
    }
}
