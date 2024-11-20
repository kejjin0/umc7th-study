package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.dto.MemberRequestDto;
import umc.spring.dto.MypageDto;

import java.util.List;

public interface MemberQueryService {
    List<MypageDto> findMyPageInfoByMemberId(Long memberId);

    Member joinMember(MemberRequestDto.JoinDto request);
}
