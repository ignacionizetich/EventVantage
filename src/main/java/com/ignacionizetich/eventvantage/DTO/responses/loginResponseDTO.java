package com.ignacionizetich.eventvantage.DTO.responses;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class loginResponseDTO {

    @NotEmpty(message = "El success no puede estar vacio")
    public boolean success;

    @NotEmpty(message = "El mensaje no puede estar vacio")
    public String message;


    public String accessToken;

    public String refreshToken;
}
