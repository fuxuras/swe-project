package com.swe.libary_project.services;

import com.swe.libary_project.entities.Member;
import com.swe.libary_project.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public boolean createMember(String name, String surname, String mail, String password) {
        if (memberRepository.existsByMail(mail)){
            return false;
        }
        Member member = new Member();
        member.setName(name);
        member.setSurname(surname);
        member.setMail(mail);
        member.setPassword(password);
        member.setRole("USER");
        memberRepository.save(member);
        return true;
    }

    public Optional<Member> getMemberByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
