package com.fxii.personapi.service;

import com.fxii.personapi.dto.mapper.UserMapper;
import com.fxii.personapi.dto.request.UserDTO;
import com.fxii.personapi.entity.User;
import com.fxii.personapi.exception.UserNotFoundException;
import com.fxii.personapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public String createUser(UserDTO userDTO) {
        User user = userMapper.toModel(userDTO);

        User savedUser = userRepository.save(user);
        return String.format("Usuário %s criado com id %d",savedUser.getUserName(), savedUser.getId());
    }

    public User findByName(String userName) throws UsernameNotFoundException {
        User user = new User();
        user.setUserName(userName);
        return userRepository.findOne(Example.of(user))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", userName)));
    }
}
