package org.example.springsecurityjpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

// this annotation mark that this class as JPA entity
// that can work with database data with the java object
@Entity
// we can use @Data instead below
// but if we use @Data it could be conflict if we use with relational table
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users_tbl")
public class User {
    // set primary key to the table
    @Id
    // and each id key as the uuid value
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    // the unique = true indicate that the column of the email
    // must be unique so cannot have the same email in the table
//    @Column(unique = true)
    private String email;
    private String password;
    private boolean isDisabled;
    private boolean isAccountLocked;
    private boolean isAccountExpired;
    private boolean isCredentialsExpired;
    // for this annotation indicate the relationship of many to many
    // that mean the set of role have association with the users
    // each user can have multiple role, and each role can associate with multiple users
    // as we used Set<Role> This means that a user cannot have the same role multiple times
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles;
}
