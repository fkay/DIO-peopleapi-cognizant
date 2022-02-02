package com.fxii.personapi.controller;

import com.fxii.personapi.dto.MessageResponseDTO;
import com.fxii.personapi.dto.request.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(path = "/login")
    public MessageResponseDTO login(@RequestBody UserDTO user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return MessageResponseDTO.builder()
                .message("Usuário logado")
                .build();
    }

}
