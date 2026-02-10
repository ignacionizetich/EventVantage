package com.ignacionizetich.eventvantage.DTO.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class changeEventRequestDTO {

    @Size(min = 3, max = 100)
    private String title;

    @Size(max = 1000)
    private String description;

    @Min(1)
    private Integer capacity; // wrapper

    @Size(min = 3, max = 150)
    private String location;

    @Future
    private LocalDateTime eventDate;
}
