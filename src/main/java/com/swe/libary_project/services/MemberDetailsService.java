package com.swe.libary_project.services;


import com.swe.libary_project.entities.Member;
import com.swe.libary_project.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Member member = memberRepository.findByMail(mail).orElseThrow(() -> new UsernameNotFoundException("User not found with mail: " + mail));
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(member.getRole()));
            }

            @Override
            public String getPassword() {
                return member.getPassword();
            }

            @Override
            public String getUsername() {
                return member.getMail();
            }
        };
    }
}
