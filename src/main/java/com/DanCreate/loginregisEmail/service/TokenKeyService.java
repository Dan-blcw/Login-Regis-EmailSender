package com.DanCreate.loginregisEmail.service;
import com.DanCreate.loginregisEmail.model.entities.TokenKey;
import com.DanCreate.loginregisEmail.repository.TokenKeyRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenKeyService {
    private final TokenKeyRepository tokenKeyRepository;
    public void saveTokenKeyService(TokenKey token) {
        tokenKeyRepository.save(token);
    }
    public Optional<TokenKey> getToken(String token) {
        return tokenKeyRepository.findByToken(token);
    }
    public int setConfirmedAt(String token) {
        return tokenKeyRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}

