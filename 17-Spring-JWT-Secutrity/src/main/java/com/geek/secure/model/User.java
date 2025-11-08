package com.geek.secure.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "userlogin2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotNull(message = "username required")
    private String username;
    @Column
    @JsonIgnore
    private String password;
    private String role;

}

