package com.swe.libary_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String surname;

    private String mail;

    private String password;

    private String role;

    @OneToMany(mappedBy = "owner")
    private List<Reservation> reservations;
}
