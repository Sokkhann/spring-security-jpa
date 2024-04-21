package org.example.springsecurityjpa.repository;

import jakarta.annotation.PostConstruct;
import org.example.springsecurityjpa.model.Authority;
import org.example.springsecurityjpa.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataInitializer {
    private RoleRepository roleRepository;
    private AuthorityRepository authorityRepository;

    @PostConstruct
    void initData(){
        initAuthorities();
        initRoles();
    }

    // this method is for initialize the value to authority
    // there's a list of authorities: read, write, and delete
    // before create it check the auth in the database first if it exists
    // prevent the duplicate
    // after set the auth one by one and then save into the database
    private void initAuthorities() {
        List<String> authorities = List.of("READ", "WRITE", "DELETE");
        if(authorityRepository.count() == 0) {
            for(String auth : authorities) {
                Authority authority = new Authority();
                authority.setName(auth);
                authorityRepository.save(authority);
            }
        }
    }

    private void initRoles() {
        List<String> roles = List.of("USER", "ADMIN");
        if(roleRepository.count() == 0) {
            Role userRole = new Role();
            userRole.setName("USER");
            userRole.setAuthorities(Set.of(authorityRepository.findByName("READ").get()));
            roleRepository.save(userRole);

            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            adminRole.setAuthorities(new HashSet<>(authorityRepository.findAll()));
            roleRepository.save(adminRole);
        }
    }
}
