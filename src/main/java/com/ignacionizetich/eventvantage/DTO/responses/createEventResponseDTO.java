package com.ignacionizetich.eventvantage.DTO.responses;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class createEventResponseDTO {

    private final boolean success;
    private final String message;

    public static createEventResponseDTO success(String message) {
        return createEventResponseDTO.builder()
                .success(true)
                .message(message)
                .build();
    }

    public static createEventResponseDTO error(String message) {
        return createEventResponseDTO.builder()
                .success(false)
                .message(message)
                .build();
    }
}
