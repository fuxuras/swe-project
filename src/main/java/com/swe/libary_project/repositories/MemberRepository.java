package com.swe.libary_project.repositories;

import com.swe.libary_project.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUsername(String username);
}
