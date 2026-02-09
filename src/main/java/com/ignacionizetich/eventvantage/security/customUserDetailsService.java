package com.ignacionizetich.eventvantage.security;

import com.ignacionizetich.eventvantage.repository.userRepository;


import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NullMarked
public class customUserDetailsService implements UserDetailsService {
    private final userRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email: "+email));
    }






}
