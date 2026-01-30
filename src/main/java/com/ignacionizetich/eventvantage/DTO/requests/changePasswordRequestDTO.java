package com.ignacionizetich.eventvantage.DTO.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class changePasswordRequestDTO {

    @NotBlank(message = "La password actual no puede estar vacia")
    private String actualPassword;

    @NotBlank(message = "La nueva password no puede estar vacia")
    private String newPassword;
}
