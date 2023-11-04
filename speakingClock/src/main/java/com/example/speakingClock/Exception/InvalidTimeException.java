package com.example.speakingClock.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidTimeException extends RuntimeException
{

    public InvalidTimeException(String message)
    {
        super(message);
    }
}
