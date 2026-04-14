package com.ignacionizetich.eventvantage.DTO.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class updateProfileResponseDTO {
    private boolean success;
    private String message;
    public static updateProfileResponseDTO success(){
        return updateProfileResponseDTO.builder()
                .success(true)
                .message("The profile has been updated successfully")
                .build();
    }

    public static updateProfileResponseDTO error(String message){
        return updateProfileResponseDTO.builder()
                .success(false)
                .message(message)
                .build();

    }
}
