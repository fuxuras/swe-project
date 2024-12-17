package com.swe.libary_project.services;

import com.swe.libary_project.entities.Book;
import com.swe.libary_project.entities.Member;
import com.swe.libary_project.entities.Reservation;
import com.swe.libary_project.repositories.BookRepository;
import com.swe.libary_project.repositories.MemberRepository;
import com.swe.libary_project.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookService bookService;
    private final MemberService memberService;

    public List<Reservation> getReservationsByOwnerMail(String mail) {
        return reservationRepository.findAllByOwnerMail(mail);
    }

    public void createReservation(String mail, Long bookId,int duration) {
       Book book = bookService.getBookById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
       Member member =  memberService.getMemberByMail(mail).orElseThrow(() -> new RuntimeException("User not found"));
       Reservation reservation = new Reservation();
       reservation.setOwner(member);
       reservation.setBook(book);
       reservation.setReservationStartDate(LocalDate.now());
       reservation.setReservationEndDate(LocalDate.now().plusDays(duration));
       reservationRepository.save(reservation);
    }

    public void returnBook(Long bookId) {
        Book book = bookService.getBookById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setStatus("Available");

    }
}