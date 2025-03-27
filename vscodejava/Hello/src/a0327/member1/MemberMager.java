package a0327.member1;

import java.util.ArrayList;

public class MemberMager {
    //private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> members;

    public MemberMager(){
        members = new ArrayList<>();
    }

    public void addMember() {
       members.add(new Member(addName,addAge,addEmail));
    }

    public void displayAllMembers() {
       if(members.isEmpty()){//members 리스트가 비어있으면
          System.out.println("등록된 회원이 없습니다.");
       }else{
         System.out.println("====등록된 회원목록====");
         for(Member m : members){
            System.out.println(m.toString());
         }
       }
    }

    public Member findMember(String name) {
        for(Member member : members){
            if(member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

   // public void updateMember(String updateName, int newAge, String newEmail) {
       //Member member = findMember(updateName);
      // if(member != null){
          //member  = new Member(updateName, newAge, newEmail);
          //첫번째방법 : 기존 객체의 필드 값 변경
          // member.setAge(newAge);
          // member.setEmail(newEmail); 
      // }else{
      //    System.out.println("회원을 찾을 수 없습니다.");
     //  }
  //  }
  public void updateMember(String updateName, int newAge, String newEmail){
    for(int i = 0 ;i <  members.size();i++){
        if(members.get(i).getName().equals(updateName)){
            members.set(i,new Member(updateName, newAge, newEmail));
        }
    }
    System.out.println("회원을 찾을수 없습니다.");
  }


    public void deleteMember(String deleteName) {
        Member member = findMember(deleteName);
        if(member != null){
           members.remove(member);
        }else{
           System.out.println("회원을 찾을 수 없습니다.");
        }
    }





}
