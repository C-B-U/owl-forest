package com.cbu.backend.authaccount.command.infra;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.authaccount.command.domain.AuthAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthAccountRepository extends JpaRepository<AuthAccount, AccountNo> {
    Optional<AuthAccount> findBySocialId(String socialId);

    Optional<AuthAccount> findById_Id(UUID uuid);
}
