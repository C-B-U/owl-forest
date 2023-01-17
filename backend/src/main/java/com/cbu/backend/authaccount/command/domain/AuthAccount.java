package com.cbu.backend.authaccount.command.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthAccount {
    @EmbeddedId private AccountNo id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.NONE;

    @Embedded private Member memberInfo;

    private boolean isUpdate = false;

    public void updateMemberInfo(Member memberInfo) {
        this.memberInfo = memberInfo;
        isUpdate = true;
    }

    public List<SimpleGrantedAuthority> getRole() {
        return role.stream().map(Role::name).map(SimpleGrantedAuthority::new).toList();
    }

    @Builder
    public AuthAccount(AccountNo accountNo, AuthProvider authProvider, Member memberInfo) {
        this.id = accountNo;
        this.authProvider = authProvider;
        updateMemberInfo(memberInfo);
    }
}
