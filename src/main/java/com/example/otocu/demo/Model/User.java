package com.example.otocu.demo.Model;


import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "The name of user can't be null")
    @Size(min = 5,max = 20)
    private String name;

    @Column(name = "sdt")
    @NotNull
    private int sdt;

    @Column(name = "email")
    @Email
    @NotEmpty
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @ManyToMany(targetEntity =Role.class,fetch = FetchType.EAGER)
    @JoinTable(
            name = "cat_user",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_cat")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<New> news;


    public void addRole(Role role) {
        roles.add(role);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sdt=" + sdt +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", news=" + news +
                '}';
    }
}
