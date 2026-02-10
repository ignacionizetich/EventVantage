package com.ignacionizetich.eventvantage.DTO.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class changeEventResponseDTO {

    private boolean success;

    private String message;

    private EventDTO event;

    public static changeEventResponseDTO success(EventDTO event){
       return changeEventResponseDTO.builder()
                .success(true)
                .message("Evento actualizado correctamente")
               .event(event)
                .build();
    }


    public static changeEventResponseDTO error(String message){
        return changeEventResponseDTO.builder()
                .success(false)
                .message(message)
                .build();
    }
}
