package com.ansdev.secureapita.service;

import com.ansdev.secureapita.domain.User;
import com.ansdev.secureapita.dto.UserDTO;

public interface UserService {
    UserDTO createUser (User user);
}
