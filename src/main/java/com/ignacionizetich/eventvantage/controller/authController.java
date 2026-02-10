package com.ignacionizetich.eventvantage.controller;

import com.ignacionizetich.eventvantage.DTO.requests.changePasswordRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.loginRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.userRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.changePasswordResponseDTO;
import com.ignacionizetich.eventvantage.DTO.responses.loginResponseDTO;
import com.ignacionizetich.eventvantage.DTO.responses.userResponseDTO;
import com.ignacionizetich.eventvantage.service.impl.userServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = "application/json")
public class authController {

    private final userServiceImpl userService;

    public authController(userServiceImpl userService){
        this.userService = userService;
    }



    @PostMapping("/register")
    public ResponseEntity<userResponseDTO> register( @Valid @RequestBody userRequestDTO request){
       return ResponseEntity.status(201).body(this.userService.createUser(request));
    }


    @PostMapping("/login")
    public ResponseEntity<loginResponseDTO> login(@Valid @RequestBody loginRequestDTO request){
        return ResponseEntity.status(200).body(this.userService.login(request));
    }


    @PutMapping("/changePassword")
    public ResponseEntity<changePasswordResponseDTO> changePassword(@AuthenticationPrincipal UserDetails userDetails
    , @RequestBody() changePasswordRequestDTO request){
        try {
            return ResponseEntity.status(200).body(this.userService.changePassword(userDetails.getUsername(),request));
        } catch (UserPrincipalNotFoundException e) {
            System.out.println(e.getMessage());
        }
       return null;
    }



}
