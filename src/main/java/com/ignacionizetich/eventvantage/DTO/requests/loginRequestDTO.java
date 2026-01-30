package com.ignacionizetich.eventvantage.DTO.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class loginRequestDTO {


    @Email(message = "El email debe tener formato de email")
    private String email;

    @NotBlank(message = "La password es obligatoria")
    private String password;
}
