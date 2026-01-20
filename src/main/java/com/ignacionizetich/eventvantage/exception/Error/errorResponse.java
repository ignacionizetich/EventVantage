package com.ignacionizetich.eventvantage.exception.Error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class errorResponse{

    private int status;
    private String message;
    private LocalDateTime timestamp;
}
