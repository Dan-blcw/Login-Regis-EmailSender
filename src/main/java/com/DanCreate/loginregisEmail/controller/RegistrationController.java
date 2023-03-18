package com.DanCreate.loginregisEmail.controller;

import com.DanCreate.loginregisEmail.model.dtos.RegistrationDto;
import com.DanCreate.loginregisEmail.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationDto requestDto){
        return registrationService.register(requestDto);
    }

    @GetMapping(path =  "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
