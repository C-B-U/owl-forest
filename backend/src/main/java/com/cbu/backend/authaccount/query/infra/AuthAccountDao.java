package com.cbu.backend.authaccount.query.infra;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.authaccount.command.domain.AuthAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthAccountDao extends JpaRepository<AuthAccount, AccountNo> {
    Optional<AuthAccount> findById_Id(UUID uuid);
}
