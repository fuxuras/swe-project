package com.swe.libary_project.repositories;

import com.swe.libary_project.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Find reservations by the user who made them
    List<Reservation> findByMemberId(Long memberId);

    // Find reservations for a specific book
    List<Reservation> findByBookId(Long bookId);
}
