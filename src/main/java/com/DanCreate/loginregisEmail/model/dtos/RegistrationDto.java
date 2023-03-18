package com.DanCreate.loginregisEmail.model.dtos;

import lombok.*;
import lombok.experimental.Accessors;
@Builder
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class RegistrationDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
