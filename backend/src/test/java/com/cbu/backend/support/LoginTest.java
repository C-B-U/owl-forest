package com.cbu.backend.support;

import com.cbu.backend.member.MemberRepository;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;
import com.cbu.backend.support.database.EnableDataBaseTest;
import com.cbu.backend.support.fixture.member.MemberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@EnableDataBaseTest
public abstract class LoginTest {

    @MockBean
    protected AuthService authService;

    @Autowired
    private MemberRepository memberRepository;

    protected Member loginUser;

    @BeforeEach
    private void setup() {
        Member member = MemberFixture.HERRY.toEntity();
        loginUser = memberRepository.save(member);
        when(authService.getLoginUser()).thenReturn(loginUser);
    }
}
