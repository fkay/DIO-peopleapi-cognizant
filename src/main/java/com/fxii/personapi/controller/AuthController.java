package com.fxii.personapi.controller;

import com.fxii.personapi.dto.MessageResponseDTO;
import com.fxii.personapi.dto.request.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/people")
public class AuthController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @PostMapping(path = "/login")
    public MessageResponseDTO login(@RequestBody UserDTO user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return MessageResponseDTO.builder()
                .message("Usuário logado")
                .build();
    }

}
