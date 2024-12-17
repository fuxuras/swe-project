package com.swe.libary_project.controller;

import com.swe.libary_project.entities.Reservation;
import com.swe.libary_project.services.MemberService;
import com.swe.libary_project.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final MemberService memberService;

    // Display all reservations for the logged-in member
    @GetMapping
    public String getAllReservations(Model model, Principal principal) {
        List<Reservation> reservations = reservationService.getReservationsByOwnerMail(principal.getName());  //
        model.addAttribute("reservations", reservations);
        return "reservations/list"; // Refers to Thymeleaf template: reservations/list.html
    }
    // Unique username
    // Create a new reservation
    @PostMapping
    public String reserveBook(@RequestParam Long bookId,Principal principal,@RequestParam int duration) {
       reservationService.createReservation(principal.getName(), bookId,duration);
       return "redirect:/reservations/list" ;
    }

    }



