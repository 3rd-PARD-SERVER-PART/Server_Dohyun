package com.pard.hw5.oauth;

import com.pard.hw5.oauth.dto.OAuthAttributes;
import com.pard.hw5.oauth.entity.GetOAuthres;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.repo.UserRepo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // 의존성 주입
@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepo userRepo;
    private final HttpSession httpSession;
    @Override
    public OAuth2User loadUser(
            OAuth2UserRequest oAuth2UserRequest
    ) throws OAuth2AuthenticationException {
        log.info("Google에서 받아온 rep id : "+ oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        log.info("Google에서 받아온 정보 : "+ oAuth2User);

        // String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
        // 현재 로그인 진행중인 서비스를 구분
        // 구글로그인인지, 네이버인지, 페이스북인지 구분하기위해 사용 --> 구글만으로 로그인하기에 사용하지 않음.

        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        // OAuth2 로그인 진행시 키가 되는 필드값.
        // primary key와 같은 의미.
        // 구글의 경우 기본 "sub"를 사용하지만 네이버 카카오등은 기본 지원하지 않음.
        // 네이버로그인과 구글로그인을 동시 지원할 때 사용
        OAuthAttributes attributes = OAuthAttributes.of(userNameAttributeName, oAuth2User.getAttributes());
        //OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담은 클래스로 네이버 등 다른 소셜 로그인도 이 클래스를 사용
        // 새로 구현해야함 --> 공부해야함

        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new GetOAuthres(user));
        // 세션에 사용자 정보를 저장하기위한 Dto클래스.

        return super.loadUser(oAuth2UserRequest);
    }
    private User saveOrUpdate(OAuthAttributes attributes) {
        User user = userRepo.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName())).orElse(attributes.toEntity());

        return userRepo.save(user);
    }
}
