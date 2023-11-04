package com.example.speakingClock.Service;

import org.springframework.http.ResponseEntity;

public interface TimeService
{
    String getTimeToWords(String time);
}
