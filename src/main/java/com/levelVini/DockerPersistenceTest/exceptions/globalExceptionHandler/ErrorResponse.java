package com.levelVini.DockerPersistenceTest.exceptions.globalExceptionHandler;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;


@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;

    private String status;

    public ErrorResponse(LocalDateTime timestamp, String message, String status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }
}
