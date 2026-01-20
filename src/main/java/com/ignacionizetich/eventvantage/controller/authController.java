package com.ignacionizetich.eventvantage.controller;

import com.ignacionizetich.eventvantage.DTO.requests.userRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.userResponseDTO;
import com.ignacionizetich.eventvantage.service.impl.userServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = "application/json")
public class authController {

    private final userServiceImpl userService;

    public authController(userServiceImpl userService){
        this.userService = userService;
    }



    @PostMapping("/register")
    public ResponseEntity<userResponseDTO> register(@RequestBody userRequestDTO request){
       return ResponseEntity.status(201).body(this.userService.createUser(request));
    }



}
