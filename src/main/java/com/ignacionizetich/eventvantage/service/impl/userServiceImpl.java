package com.ignacionizetich.eventvantage.service.impl;


import com.ignacionizetich.eventvantage.DTO.requests.changePasswordRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.loginRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.userRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.changePasswordResponseDTO;
import com.ignacionizetich.eventvantage.DTO.responses.loginResponseDTO;
import com.ignacionizetich.eventvantage.DTO.responses.userResponseDTO;
import com.ignacionizetich.eventvantage.entity.User;
import com.ignacionizetich.eventvantage.exception.custom.EmailAlreadyExistsException;
import com.ignacionizetich.eventvantage.repository.userRepository;
import com.ignacionizetich.eventvantage.security.JwtService;
import com.ignacionizetich.eventvantage.service.userService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    private final userRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public userServiceImpl(JwtService jwtService, userRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public userResponseDTO createUser(userRequestDTO request) {
        Optional<User> user = this.userRepository.findByEmail(request.getEmail());

        if(user.isPresent()){
           throw new EmailAlreadyExistsException(request.getEmail());
        }

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setDni(request.getDni());
        newUser.setPhoneNumber(request.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(newUser);

        return new userResponseDTO(true, "Usuario creado correctamente");
    }

    @Override
    public loginResponseDTO login(loginRequestDTO credentials) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getEmail(),
                        credentials.getPassword()
                )
        );

        var optionalUser = userRepository.findByEmail(credentials.getEmail()).orElseThrow( () -> new RuntimeException("Usuario no encontrado"));

        var accessToken = jwtService.createAccessToken(optionalUser,optionalUser.getRole());
        var refreshToken = jwtService.createRefreshToken(optionalUser);

        return loginResponseDTO.builder()
                .success(true)
                .message("Inicio de sesion exitoso!")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }

    @Override
    public changePasswordResponseDTO changePassword(String username, changePasswordRequestDTO request) throws UserPrincipalNotFoundException {
        Optional<User> optUser = userRepository.findByEmail(username);
        User authUser = optUser.orElseThrow(() -> new UserPrincipalNotFoundException("No se encontro el usuario autenticado"));

        if (!passwordEncoder.matches(request.getActualPassword(), authUser.getPassword())) {
            throw new RuntimeException("La password actual no coincide");
        }

        authUser.setPassword(passwordEncoder.encode(request.getNewPassword()));


        userRepository.save(authUser);

        return changePasswordResponseDTO.builder()
                .success(true)
                .message("the password has been successfully changed!")
                .build();
    }
}
