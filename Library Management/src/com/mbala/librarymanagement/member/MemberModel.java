package com.mbala.librarymanagement.member;
import com.mbala.librarymanagement.model.Members;
import com.mbala.librarymanagement.datalayer.DataLayer;
public class MemberModel {
    private MemberView memberView;
    public MemberModel(MemberView memberView){
        this.memberView=memberView;
    }
    public void addMemberList(Members members){
      if(DataLayer.getInstance().isNewMember(members)){
          memberView.onSucess();
      }else {
          memberView.alreadyExsists();
      }
    }
    public void removeMember(int id){
        DataLayer.getInstance().removeMembers(id);
        memberView.onSucessRemove();
    }
}
