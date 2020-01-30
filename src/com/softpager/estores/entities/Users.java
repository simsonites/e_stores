package com.softpager.estores.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "Users.FindAll", query = "SELECT u from Users u order by lastName"),
        @NamedQuery(name = "Users.Count", query = "select count(*) from Users")
})
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public Users(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Users() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getUserId() == users.getUserId() &&
                getEmail().equals(users.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getEmail());
    }


}
