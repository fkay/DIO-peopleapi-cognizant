package com.fxii.personapi.service;

import com.fxii.personapi.dto.mapper.UserMapper;
import com.fxii.personapi.dto.request.UserDTO;
import com.fxii.personapi.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailServiceImpl implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = findUser(username);
        //if(user == null) {
        //    throw new UsernameNotFoundException(username);
        //}

        return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
    }

    private UserDTO findUser(String username) throws UsernameNotFoundException {
        if (username.equalsIgnoreCase("admin")) {
            //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); // di
            return UserDTO.builder()
                    .userName("admin")
                    .password(bCryptPasswordEncoder.encode("admin"))
                    .build();
        }
        com.fxii.personapi.entity.User user = userService.findByName(username);
        UserDTO userDTO = userMapper.toDTO(user);
        userDTO.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDTO;
    }
}
