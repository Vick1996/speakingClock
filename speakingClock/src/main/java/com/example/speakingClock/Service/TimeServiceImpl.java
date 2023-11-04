package com.example.speakingClock.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService
{
    private final String[] tensNames = {
            "", " ten", " twenty", " thirty", " forty", " fifty"
    };

    private final String[] numNames = {
            "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"
    };
    @Override
    public String getTimeToWords(String time)
    {
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        String timeInWords = "It's";

        if (hours == 0 && minutes == 0) {
            timeInWords += " Midnight";
        } else if (hours == 12 && minutes == 0) {
            timeInWords += " Midday";
        } else {
            timeInWords += numNames[hours % 12];
            if (minutes != 0) {
                if (minutes < 20) {
                    timeInWords += numNames[minutes];
                } else {
                    timeInWords += tensNames[minutes / 10] + numNames[minutes % 10];
                }
            }
        }
        return timeInWords;
    }
}
