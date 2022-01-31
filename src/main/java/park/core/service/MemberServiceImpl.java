package park.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import park.core.domain.Member;
import park.core.repository.MemoryMemberRepository;
import park.core.repository.MemberRepository;

/**
 * Created by park on 2021/11/20.
 */
@Component("memberService")
public class MemberServiceImpl implements MemberService{

  private final MemberRepository memberRepository;

  @Autowired
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
