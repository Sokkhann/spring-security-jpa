package org.example.springsecurityjpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "role_tbl")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @ManyToMany
    Set<Authority> authorities;

    @Override
    public String getAuthority() {
        return "ROLE_"+ this.name;
    }
}
