package com.example.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 4887904943282174032L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String login;
    @NotEmpty
    @Size(min = 3, message = "Length must be more than 3")
    private String password;
    @NotNull
    private boolean active;
    @NotEmpty
    private String role = "ROLE_CUSTOMER";

    @NaturalId
    @NotEmpty
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Cart cart;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", role='" + role + '\'' +
                '}';
    }

}

