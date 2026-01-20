package com.ignacionizetich.eventvantage.DTO.responses;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userResponseDTO {

    @NotEmpty(message = "El success no puede estar vacio")
    private boolean success;


    @NotEmpty(message = "El mensaje no puede estar vacio")
    private String message;
}
