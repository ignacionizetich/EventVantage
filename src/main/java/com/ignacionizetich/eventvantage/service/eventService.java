package com.ignacionizetich.eventvantage.service;

import com.ignacionizetich.eventvantage.DTO.requests.changeEventRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.createEventRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.*;


public interface eventService {

    createEventResponseDTO createEvent(createEventRequestDTO request);

    eventResponseDTO getEvent(Long id);

    EventsResponseDTO getEvents();

    changeEventResponseDTO updateEvent(Long id,changeEventRequestDTO request);


    deleteEventResponseDTO deleteEvent(Long id);

}
