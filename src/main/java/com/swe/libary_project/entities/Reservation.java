package com.swe.libary_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;

    @ManyToOne
    @JoinColumn(name = "member_id") // Maps to the 'user' table
    private Member owner;


    @ManyToOne
    @JoinColumn(name = "book_id") // Maps to the 'book' table
    private Book book;


}
