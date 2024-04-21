package org.example.springsecurityjpa.model.dto;

import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.springsecurityjpa.model.Role;

import java.util.Set;

@Builder
public record UserRequest (
        String email,
        String password,
        Set<String> roles
) {
}
