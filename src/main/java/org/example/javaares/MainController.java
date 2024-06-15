package org.example.javaares;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainController {

    private final MainService service;

    @Autowired
    public MainController(MainService ser) {
        this.service = ser;
    }


    /**
     * Main controller of the app
     *
     * @param ico ico of the subject
     * @return String representation of the subject if found, "Not found" otherwise
     */
    @GetMapping("/")
    public String testing(@RequestParam String ico) {
        if (!isIcoValid(ico))
            return "Invalid ico";

        Optional<Subject> subject = service.getSubject(ico);

        if (subject.isPresent())
            return subject.get().toString();
        return "Does not exist";
    }


    private boolean isIcoValid(String ico) {
        StringBuilder icoBuilder = new StringBuilder(ico);
        while (icoBuilder.length() < 8) {
            icoBuilder.insert(0, "0");
        }
        ico = icoBuilder.toString();

        for (int i = 0; i < ico.length(); i++) {
            if (!Character.isDigit(ico.charAt(i))) {
                return false;
            }
        }

        int[] digits = ico.chars().map(Character::getNumericValue).toArray();
        return (11 - (8 * digits[0] + 7 * digits[1] + 6 * digits[2] + 5 * digits[3] + 4 * digits[4] + 3 * digits[5] + 2 * digits[6]) % 11) % 10 == digits[7];
    }

}
