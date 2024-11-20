package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.dto.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDto request);
}