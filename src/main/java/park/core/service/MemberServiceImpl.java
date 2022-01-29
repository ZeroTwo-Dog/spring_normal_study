package park.core.service;

import park.core.domain.Member;
import park.core.repository.MemoryMemberRepository;
import park.core.repository.MemberRepository;

/**
 * Created by park on 2021/11/20.
 */
public class MemberServiceImpl implements MemberService{

  private MemberRepository memberRepository;

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
