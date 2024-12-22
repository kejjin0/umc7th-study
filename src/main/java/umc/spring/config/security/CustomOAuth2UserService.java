package umc.spring.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.Role;
import umc.spring.repository.MemberRepository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 카카오 로그인
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
//        String nickname = (String) properties.get("nickname");
//        String email = nickname + "@kakao.com";

        // 구글로 로그인
//        String email = oAuth2User.getAttributes().get("email").toString();
//        String nickname = oAuth2User.getAttributes().get("name").toString();

        // 네이버로 로그인
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        String email = (String) response.get("email");
        String nickname = (String) response.get("nickname");
        Member member = saveOrUpdateUser(email,nickname);

        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("email", email);

        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "email"
        );
    }

    private Member saveOrUpdateUser(String email, String nickname) {
        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .name(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER" + UUID.randomUUID()))
                        .gender(Gender.NONE)
                        .address("소셜로그인")
                        .specAddress("소셜로그인")
                        .birthyYear(2009)
                        .birthyMonth(9)
                        .birthyDay(9)
                        .role(Role.USER)
                        .build());
        return memberRepository.save(member);
    }
}
