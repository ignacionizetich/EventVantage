package com.ignacionizetich.eventvantage.controller;

import com.ignacionizetich.eventvantage.DTO.requests.changeEventRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.createEventRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.*;
import com.ignacionizetich.eventvantage.service.impl.eventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/events", produces = "application/json")
public class eventController {

    private final eventServiceImpl eventService;

    public eventController(eventServiceImpl eventService){
        this.eventService = eventService;
    }


    @PostMapping
    public ResponseEntity<createEventResponseDTO> createEvent(@RequestBody createEventRequestDTO request){
        return ResponseEntity.status(201).body(this.eventService.createEvent(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<eventResponseDTO> getEvent(@PathVariable Long id){
        return ResponseEntity.status(200).body(this.eventService.getEvent(id));
    }

    @GetMapping
    public ResponseEntity<EventsResponseDTO> getEvents(){
        return ResponseEntity.status(200).body(this.eventService.getEvents());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<changeEventResponseDTO> updateEvent(@PathVariable Long id, @Valid @RequestBody changeEventRequestDTO request){
        return ResponseEntity.status(200).body(this.eventService.updateEvent(id,request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<deleteEventResponseDTO> deleteEvent(@PathVariable Long id){
        return ResponseEntity.status(200).body(this.eventService.deleteEvent(id));
    }

}
