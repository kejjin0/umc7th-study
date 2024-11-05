package umc.spring.repository.MemberRepository;

import umc.spring.dto.MypageDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MypageDto> findMyPageInfoByMemberId(Long memberId);
}
