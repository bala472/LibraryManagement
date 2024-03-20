package com.mbala.librarymanagement.member;

import java.util.Scanner;

import com.mbala.librarymanagement.datalayer.DataLayer;
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
        System.out.println("Enter email address : ");
        in.nextLine();
        members.setEmail(in.nextLine());
        System.out.println("Enter phone number : ");
        members.setPhoneNo(in.nextLine());
        System.out.println("Enter address : ");
        members.setAddress(in.nextLine());
        memberModel.addMemberList(members);
    }
    public void onSucess(){
        System.out.println("Member added successfully ");
    }
    public void alreadyExsists(){
        System.out.println("Member already added");
    }
    public void showMembers(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n","Name","Member ID","Phone Number","Email","Address");
      for(Members members: DataLayer.getInstance().getMemberList()){
          System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",members.getName(),members.getId(),members.getPhoneNo(),members.getEmail(),members.getAddress());
      }
    }
    public void removeMember(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter member id ");
        memberModel.removeMember(in.nextInt());
    }
    public void onSucessRemove(){
        System.out.println("Member removed successfully. If given id does not exists then none of the member is removed");
    }
}
