package org.example.springsecurityjpa.service;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityjpa.mapper.UserMapper;
import org.example.springsecurityjpa.model.Role;
import org.example.springsecurityjpa.model.User;
import org.example.springsecurityjpa.model.dto.UserRequest;
import org.example.springsecurityjpa.model.dto.UserResponse;
import org.example.springsecurityjpa.repository.RoleRepository;
import org.example.springsecurityjpa.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    // need to fix this
    // occur nullPointerException

//    @Override
//    public UserResponse createUser(UserRequest userRequest) {
//        // check for email address
//        if (userRepository.existsByEmail(userRequest.email())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
//        }
//        Set<Role> roles = new HashSet<>();
//        // check for roles
//        userRequest.roles().forEach(
//                r -> {
//                    var roleObject = roleRepository
//                            .findByName(r)
//                            .orElseThrow(() -> new ResponseStatusException(
//                                    HttpStatus.BAD_REQUEST,
//                                    "Role " + r + "not found"
//                            ));
//                    roles.add(roleObject);
//                }
//        );
//        User newUser = userMapper.toUser(userRequest, roles);
//        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
//        userRepository.save(newUser);
//        return userMapper.toUserResponse(newUser);
//    }
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // Check if email already exists
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        Set<Role> roles = new HashSet<>();
        // Check if roles are provided and not null
        if (userRequest.roles() != null) {
            // Iterate over each role name provided in the request
            for (String roleName : userRequest.roles()) {
                // Find the Role object in the role repository
                Role roleObject = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Role " + roleName + " not found"
                        ));
                // Add the Role object to the set of roles
                roles.add(roleObject);
            }
        }

        // Create a new User object from the UserRequest and roles
        User newUser = userMapper.toUser(userRequest, roles);
        // Encode the password
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
        // Save the new user
        userRepository.save(newUser);
        // Map the newUser object to UserResponse and return
        return userMapper.toUserResponse(newUser);
    }
}
