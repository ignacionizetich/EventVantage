package com.ignacionizetich.eventvantage.DTO.responses;

import com.ignacionizetich.eventvantage.entity.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class EventDTO {

    private Long id;
    private String title;
    private String description;
    private String location;
    private int capacity;
    private int availableSlots;
    private LocalDateTime eventDate;
    private EventStatus status;
}

