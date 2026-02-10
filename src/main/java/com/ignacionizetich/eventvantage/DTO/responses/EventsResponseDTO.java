package com.ignacionizetich.eventvantage.DTO.responses;

import com.ignacionizetich.eventvantage.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EventsResponseDTO {
    public boolean success;

    List<EventDTO> data;


    public static EventsResponseDTO success(List<EventDTO> lista){
        return EventsResponseDTO.builder()
                .success(true)
                .data(lista)
                .build();
    }


    public static EventsResponseDTO error(){
        return EventsResponseDTO.builder()
                .success(false)
                .data(List.of())
                .build();
    }


}
