package com.swe.libary_project.repositories;

import com.swe.libary_project.entities.Furkan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurkanRepository extends JpaRepository<Furkan,Long> {
}
