package com.fxii.personapi.service;

import com.fxii.personapi.dto.request.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = findUser(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
    }

    private UserDTO findUser(String username) {
        if (username.equalsIgnoreCase("admin")) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            return UserDTO.builder()
                    .userName("admin")
                    .password(bCryptPasswordEncoder.encode("admin"))
                    .build();
        }
        return null;
    }
}
