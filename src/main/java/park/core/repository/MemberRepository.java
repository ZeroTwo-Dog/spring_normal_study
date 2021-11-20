package park.core.repository;

import park.core.domain.Member;

public interface MemberRepository {

  void save (Member member);

  Member findById(Long memberId);

}
