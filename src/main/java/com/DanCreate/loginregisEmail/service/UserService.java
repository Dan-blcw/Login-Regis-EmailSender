package com.DanCreate.loginregisEmail.service;

import com.DanCreate.loginregisEmail.model.entities.TokenKey;
import com.DanCreate.loginregisEmail.model.entities.User;
import com.DanCreate.loginregisEmail.repository.UserReponsitory;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.lang.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    /*
        cách để khắc phục bean circyle va not found Bcry
        private PasswordEncoder passwordEncoder;
        @Autowired
        public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        Lưu ý : cách tách này hoạt động tương tự cách kia nhưng với cách dưới
        final cho tự động dùng @RequiredArgsConstructor tự động dùng đối số thì
        phải tách @bean passwordencoder ra
    }
    */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserReponsitory userReponsitory;
    private final TokenKeyService tokenKeyService;
    public int enableUser(String email) {
        return userReponsitory.enableUser(email);
    }
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userReponsitory
                .findByEmail(email)
                .orElseThrow(()
                        -> new UsernameNotFoundException
                        (String.format("User of the email %s not found",email)));
    }

    public String signUpUser(User user){
        Boolean isExists = userReponsitory
                .findByEmail(user.getEmail())
                .isPresent();
        if(isExists){
            /*
                có thể dùng cách này để trả về thông báo dưới dạng tin json hoặc text
                    throw new IllegalStateException("Email already taken");
                nhưng ở đây chỉ đề mô đơn giản nên cx k cần thiết lắm
            */
            return  "Email already taken";
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userReponsitory.save(user);
        String token = UUID.randomUUID().toString();
        TokenKey tokenKey = new TokenKey(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        tokenKeyService.saveTokenKeyService(tokenKey);
        return token;
    }
}
