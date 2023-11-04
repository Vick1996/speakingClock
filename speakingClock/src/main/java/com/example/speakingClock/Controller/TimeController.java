package com.example.speakingClock.Controller;

import com.example.speakingClock.Exception.InvalidTimeException;
import com.example.speakingClock.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/time")
public class TimeController
{

    @Autowired
    private TimeService timeService;


    @GetMapping("/{time}")
    public ResponseEntity<String> getTime(@PathVariable("time") String time)
    {
        boolean flag = true;
        try
        {
            String convTime = timeService.getTimeToWords(time);
            return ResponseEntity.ok(convTime);
        }
        catch(InvalidTimeException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
