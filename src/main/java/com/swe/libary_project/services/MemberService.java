package com.swe.libary_project.services;

import com.swe.libary_project.entities.Member;
import com.swe.libary_project.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createMember(String name, String surname, String mail, String password) {
        if (memberRepository.existsByMail(mail)){
            return false;
        }
        Member member = new Member();
        member.setName(name);
        member.setSurname(surname);
        member.setMail(mail);
        member.setPassword(passwordEncoder.encode(password));
        member.setRole("USER");
        memberRepository.save(member);
        return true;
    }
    public Optional<Member> getMemberByMail(String mail) {return memberRepository.findByMail(mail);}

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
