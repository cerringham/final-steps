package it.proactivity.finalsteps.utility;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class ParsingUtility {

    public String parseLocalDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return date.format(formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
