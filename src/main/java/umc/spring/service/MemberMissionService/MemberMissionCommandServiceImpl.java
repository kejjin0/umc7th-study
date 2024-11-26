package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request) {
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);

        Member member = memberRepository.findById(request.getMember())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMission())
                .orElseThrow(()-> new MissionHandler(ErrorStatus.MEMBER_MISSION_EXIST));

        boolean memberMission = memberMissionRepository.existsByMemberIdAndMissionId(request.getMember(), request.getMission());
        if(memberMission) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_EXIST);
        }

        System.out.println("-----------");
        System.out.println(member.toString());
        System.out.println(mission.toString());
        System.out.println("-----------");

        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

        return memberMissionRepository.save(newMemberMission);
    }
}
