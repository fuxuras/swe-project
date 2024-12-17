package com.swe.libary_project.repositories;

import com.swe.libary_project.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUsername(String username);
    Optional<Member> findByMail(String mail);
    boolean existsByMail(String mail);
}
