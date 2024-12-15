package com.swe.libary_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String mail;

    private String password;

    private String role;
}
