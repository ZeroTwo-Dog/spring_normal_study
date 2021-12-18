package park.core.service;

import park.core.domain.Member;
import park.core.repository.MemoryMemberRepository;
import park.core.repository.MemberRepository;

/**
 * Created by park on 2021/11/20.
 */
public class MemberServiceImpl implements MemberService{

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
