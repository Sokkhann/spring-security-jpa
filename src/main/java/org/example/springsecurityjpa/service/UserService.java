package org.example.springsecurityjpa.service;

import org.example.springsecurityjpa.model.dto.UserRequest;
import org.example.springsecurityjpa.model.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
