package com.ignacionizetich.eventvantage.service.impl;


import com.ignacionizetich.eventvantage.DTO.requests.userRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.userResponseDTO;
import com.ignacionizetich.eventvantage.entity.user;
import com.ignacionizetich.eventvantage.exception.custom.EmailAlreadyExistsException;
import com.ignacionizetich.eventvantage.repository.userRepository;
import com.ignacionizetich.eventvantage.service.userService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    private final userRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public userServiceImpl(userRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public userResponseDTO createUser(userRequestDTO request) {
        Optional<user> user = this.userRepository.findByEmail(request.getEmail());

        if(user.isPresent()){
           throw new EmailAlreadyExistsException(request.getEmail());
        }

        user newUser = new user();
        newUser.setName(request.getName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setDni(request.getDni());
        newUser.setPhoneNumber(request.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));


        System.out.println(newUser.getPassword());

        userRepository.save(newUser);

        return new userResponseDTO(true, "Usuario creado correctamente");
    }



}
