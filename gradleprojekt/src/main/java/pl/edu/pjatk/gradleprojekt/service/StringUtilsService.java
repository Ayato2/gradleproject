package pl.edu.pjatk.gradleprojekt.service;

import org.springframework.stereotype.Service;

@Service
public class StringUtilsService {

    public String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public String toUpperCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.toUpperCase();
    }

    public String toLowerCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.toLowerCase();
    }
}
