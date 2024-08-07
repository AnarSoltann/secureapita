package com.ansdev.secureapita.service.implementation;

import com.ansdev.secureapita.domain.User;
import com.ansdev.secureapita.dto.UserDTO;
import com.ansdev.secureapita.dtomapper.UserDTOMapper;
import com.ansdev.secureapita.repository.UserRepository;
import com.ansdev.secureapita.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }











}
