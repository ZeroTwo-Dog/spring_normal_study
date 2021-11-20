package park.core;

import park.core.domain.Grade;
import park.core.domain.Member;
import park.core.service.MemberService;
import park.core.service.MemberServiceImpl;

/**
 * Created by park on 2021/11/20.
 */
public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);

    System.out.println("findMember: " + findMember.getName());
    System.out.println("Member:  " + member.getName());
  }

}
