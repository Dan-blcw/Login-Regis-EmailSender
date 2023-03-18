package com.DanCreate.loginregisEmail.repository;

import com.DanCreate.loginregisEmail.model.entities.TokenKey;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenKeyRepository extends JpaRepository<TokenKey,Long> {
    Optional<TokenKey> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE TokenKey c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
