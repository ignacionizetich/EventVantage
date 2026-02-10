package com.ignacionizetich.eventvantage.DTO.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class createEventRequestDTO {

    private String title;

    private String description;

    private String location;

    private int capacity;

    private LocalDateTime eventDate;
}
