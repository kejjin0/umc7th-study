package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.dto.MypageDto;
import umc.spring.repository.MemberRepository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    @Override
    public List<MypageDto> findMyPageInfoByMemberId(Long memberId) {
        List<MypageDto> myPageMember = memberRepository.findMyPageInfoByMemberId(memberId);
        myPageMember.forEach(MyPageDto -> System.out.println("myPage member : " + MyPageDto));
        return myPageMember;
    }
}