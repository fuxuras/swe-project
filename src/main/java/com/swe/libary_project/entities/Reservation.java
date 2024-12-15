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

    //@ManyToOne
   // @JoinColumn(name = "member_id") // Maps to the 'user' table
    private long memberId;

    //@ManyToOne
    //@JoinColumn(name = "book_id") // Maps to the 'book' table
    private long bookId;

    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private boolean isActive;

}
