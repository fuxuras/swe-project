package com.swe.libary_project.repositories;

import com.swe.libary_project.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    List<Reservation> findAllByOwnerMail(String ownerMail) ;


}
