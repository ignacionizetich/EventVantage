package com.ignacionizetich.eventvantage.DTO.responses;

import com.ignacionizetich.eventvantage.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class eventResponseDTO {
    public boolean success;

    public EventDTO data;


    public static eventResponseDTO success(Event event) {
        return eventResponseDTO.builder()
                .success(true)
                .data(EventDTO.builder()
                        .id(event.getId())
                        .title(event.getTitle())
                        .description(event.getDescription())
                        .location(event.getLocation())
                        .capacity(event.getCapacity())
                        .availableSlots(event.getAvailableSlots())
                        .eventDate(event.getEventDate())
                        .status(event.getStatus())
                        .build())
                .build();
    }

    public static eventResponseDTO error(){
        return eventResponseDTO.builder()
                .success(false)
                .data(null)
                .build();
    }
}
