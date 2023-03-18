package com.DanCreate.loginregisEmail.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TokenKey {

    @SequenceGenerator(
            name = "key_token_sequence",
            sequenceName = "key_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "key_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User User;

    public TokenKey(
            String token,
            LocalDateTime createdAt,
            LocalDateTime expiresAt,
            User User
    ) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.User = User;
    }
}
