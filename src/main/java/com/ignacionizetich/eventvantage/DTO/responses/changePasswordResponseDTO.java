package com.ignacionizetich.eventvantage.DTO.responses;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class changePasswordResponseDTO {

    private boolean success;

    private String message;
}
