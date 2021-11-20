package park.core.service;

import park.core.domain.Member;

/**
 * Created by park on 2021/11/20.
 */
public interface MemberService {

  void join (Member member);

  Member findMember(Long memberId);

}
