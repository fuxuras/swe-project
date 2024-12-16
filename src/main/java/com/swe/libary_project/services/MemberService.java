package com.swe.libary_project.services;

import com.swe.libary_project.entities.Member;
import com.swe.libary_project.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public boolean createMember(String username, String mail, String password) {
        if (memberRepository.existsByUsername(username)){
            return false;
        }
        Member member = new Member();
        member.setUsername(username);
        member.setMail(mail);
        member.setPassword(password);
        member.setRole("USER");
        memberRepository.save(member);
        return true;
    }

    public Optional<Member> getMemberByUsername(String username) {
        return Optional.ofNullable(memberRepository.findByUsername(username));
    }
}
