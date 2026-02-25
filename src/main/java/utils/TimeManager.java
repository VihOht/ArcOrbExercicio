package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeManager {

    public static String getCurrentTime() {
        String FormattedTime;
        try {
            // Get current time and date;
            LocalDateTime now = LocalDateTime.now();

            // Define the desired format;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format the current time as a String;
            FormattedTime = now.format(formatter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return FormattedTime;
    }

}

