package com.swe.libary_project.services;

import com.swe.libary_project.entities.Furkan;
import com.swe.libary_project.repositories.FurkanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FurkanService {

    private final FurkanRepository furkanRepository;

    public List<Furkan> getAll(){
        return furkanRepository.findAll();
    }
}
