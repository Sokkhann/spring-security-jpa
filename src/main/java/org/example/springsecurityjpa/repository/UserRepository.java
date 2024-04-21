package org.example.springsecurityjpa.repository;

import org.example.springsecurityjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// in this interface it extends from JpaRepository
// it serves as crud perform create, post, delete, and update with database relational
// after we extend we can use numerous of method such as:
// save, findById, findAll, delete, etc... that we can use with database
// more than that we also can customize the query method for deal with database also
// for User: it means that it manage by User entity(table user)
// for String: it is the type of primary key of the user entity
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
