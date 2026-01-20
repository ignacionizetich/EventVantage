package com.ignacionizetich.eventvantage.service;

import com.ignacionizetich.eventvantage.DTO.requests.userRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.userResponseDTO;
import com.ignacionizetich.eventvantage.entity.user;


public interface userService {


    userResponseDTO createUser(userRequestDTO user);



}
