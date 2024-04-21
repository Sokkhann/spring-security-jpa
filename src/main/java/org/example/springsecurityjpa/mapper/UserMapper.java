package org.example.springsecurityjpa.mapper;
import org.example.springsecurityjpa.model.Role;
import org.example.springsecurityjpa.model.User;
import org.example.springsecurityjpa.model.dto.UserRequest;
import org.example.springsecurityjpa.model.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email", source = "userRequest.email"),
            @Mapping(target = "password", source = "userRequest.password"),
            @Mapping(target = "roles", source = "roles")

    })
    User toUser(UserRequest userRequest, Set<Role> roles);
    UserResponse toUserResponse(User user);

    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
