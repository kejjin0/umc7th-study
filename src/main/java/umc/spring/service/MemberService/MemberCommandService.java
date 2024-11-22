package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDto request);

    Page<Review> getMemberReviewList(Long memberId, Integer page);

    Page<MemberMission> getChallengeMissionList(Long missionId, Integer page);
}
