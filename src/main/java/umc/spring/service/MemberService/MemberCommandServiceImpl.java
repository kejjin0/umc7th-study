package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.dto.MemberRequestDto;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
 private final MemberRepository memberRepository;
 private final FoodCategoryRepository foodCategoryRepository;
 private final ReviewRepository reviewRepository;
 private final MemberMissionRepository memberMissionRepository;

 @Override
 @Transactional
 public Member joinMember(MemberRequestDto.JoinDto request){

     Member newMember = MemberConverter.toMember(request);
     List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
             .map(category -> {
                 return foodCategoryRepository.findById(category).orElseThrow(()-> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
             }).collect(Collectors.toList());

     List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
     memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
     return memberRepository.save(newMember);
 }

 @Override
 public Page<Review> getMemberReviewList(Long memberId, Integer page){
     Member member = memberRepository.findById(memberId).get();
     Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
     return reviewPage;
 }

    @Override
    public Page<MemberMission> getChallengeMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> missionPage = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return missionPage;
    }

    @Override
    public MemberMission modifyMemberMissionStatus(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId).get();
        memberMission.setStatus(MissionStatus.COMPLETED);
        memberMission.setUpdatedAt(LocalDateTime.now());
        return memberMissionRepository.save(memberMission);
    }
}
