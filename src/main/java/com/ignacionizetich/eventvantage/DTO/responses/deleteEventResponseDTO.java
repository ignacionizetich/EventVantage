package com.ignacionizetich.eventvantage.DTO.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class deleteEventResponseDTO {
    private boolean success;
    private String message;

    public static deleteEventResponseDTO success(){
        return deleteEventResponseDTO.builder()
                .success(true)
                .message("Evento eliminado correctamente")
                .build();
    }

    public static deleteEventResponseDTO error(String message){
        return deleteEventResponseDTO.builder()
                .success(false)
                .message(message)
                .build();
    }
}
