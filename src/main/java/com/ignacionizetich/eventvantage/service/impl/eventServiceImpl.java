package com.ignacionizetich.eventvantage.service.impl;

import com.ignacionizetich.eventvantage.DTO.requests.changeEventRequestDTO;
import com.ignacionizetich.eventvantage.DTO.requests.createEventRequestDTO;
import com.ignacionizetich.eventvantage.DTO.responses.*;
import com.ignacionizetich.eventvantage.entity.Event;
import com.ignacionizetich.eventvantage.entity.enums.EventStatus;
import com.ignacionizetich.eventvantage.exception.custom.DuplicateEventException;
import com.ignacionizetich.eventvantage.exception.custom.EventNotFoundException;
import com.ignacionizetich.eventvantage.repository.eventRepository;
import com.ignacionizetich.eventvantage.service.eventService;

import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class eventServiceImpl implements eventService {

    private final eventRepository eventRepository;

    public eventServiceImpl(eventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public createEventResponseDTO createEvent(createEventRequestDTO request) {
        if(eventRepository.existsByTitleAndLocationAndEventDate(request.getTitle(),request.getLocation(),request.getEventDate())){
                throw new DuplicateEventException("El evento: "+ request.getTitle()+ "Ya existe.");
        }

        Event event = new Event();

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setCapacity(request.getCapacity());
        event.setAvailableSlots(request.getCapacity());
        event.setEventDate(request.getEventDate());
        event.setStatus(EventStatus.ACTIVE);

        try{
            eventRepository.save(event);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEventException("Ya existe un evento con ese título, lugar y fecha");
        }

        return createEventResponseDTO.success("Evento creado correctamente!");
    }

    @Override
    public eventResponseDTO getEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("El evento solicitado no existe"));

        return eventResponseDTO.success(event);
    }


    @Override
    public EventsResponseDTO getEvents() {

        List<EventDTO> events = eventRepository.findAll()
                .stream()
                .map(this::toEventDTO)
                .toList();

        return EventsResponseDTO.success(events);
    }

    @Override
    @Transactional
    public changeEventResponseDTO updateEvent(Long id, changeEventRequestDTO request) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("El evento no existe"));

        if (request.getTitle() != null) {
            event.setTitle(request.getTitle());
        }

        if (request.getDescription() != null) {
            event.setDescription(request.getDescription());
        }

        if (request.getCapacity() != null) {
            if (request.getCapacity() < event.getAvailableSlots()) {
                throw new IllegalArgumentException(
                        "La capacidad no puede ser menor a los slots ya ocupados"
                );
            }
            event.setCapacity(request.getCapacity());
        }

        if (request.getLocation() != null) {
            event.setLocation(request.getLocation());
        }

        if (request.getEventDate() != null) {
            event.setEventDate(request.getEventDate());
        }

        // version, createdAt, updatedAt se manejan solos
        eventRepository.save(event);

        return changeEventResponseDTO.success(toEventDTO(event));
    }

    @Override
    public deleteEventResponseDTO deleteEvent(Long id) {
        Event deletedEvent = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("El evento solicitado no existe."));


        eventRepository.delete(deletedEvent);


        return deleteEventResponseDTO.success();

    }



    /// METODOS PRIVATE PARA PASAR DE UN EVENTO A UN DTO
    private EventDTO toEventDTO(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .location(event.getLocation())
                .eventDate(event.getEventDate())
                .capacity(event.getCapacity())
                .availableSlots(event.getAvailableSlots())
                .build();
    }


}
