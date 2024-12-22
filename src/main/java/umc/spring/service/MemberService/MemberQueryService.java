package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberDTO.MemberRequestDto;
import umc.spring.web.dto.MypageDto;

import java.util.List;

public interface MemberQueryService {
    List<MypageDto> findMyPageInfoByMemberId(Long memberId);

    Member joinMember(MemberRequestDto.JoinDto request);
}
