package org.example.springsecurityjpa.model.dto;

import org.example.springsecurityjpa.model.Role;

import java.util.Set;

public record UserResponse (
        String id,
        String email,
        Set<String> roles
){
}
