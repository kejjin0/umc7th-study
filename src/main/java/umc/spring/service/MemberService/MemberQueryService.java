package umc.spring.service.MemberService;

import umc.spring.dto.MypageDto;

import java.util.List;

public interface MemberQueryService {
    List<MypageDto> findMyPageInfoByMemberId(Long memberId);
}
