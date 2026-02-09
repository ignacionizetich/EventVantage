package com.ignacionizetich.eventvantage.service;

import com.ignacionizetich.eventvantage.DTO.requests.changePasswordRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.loginRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.userRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.changePasswordResponseDTO;
import com.ignacionizetich.eventvantage.DTO.responses.loginResponseDTO;
import com.ignacionizetich.eventvantage.DTO.responses.userResponseDTO;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public interface userService {


    userResponseDTO createUser(userRequestDTO user);

    loginResponseDTO login(loginRequestDTO credentials);

    changePasswordResponseDTO changePassword(String username,changePasswordRequestDTO request) throws UserPrincipalNotFoundException;


}
