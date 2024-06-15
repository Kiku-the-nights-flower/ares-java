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

    @GetMapping("/testing")
    public String testing(@RequestParam String ico) {
        Optional<Subject> subject = service.getSubject(ico);
        if (subject.isPresent()) {
            return subject.get().toString();
        }
        return "Not found";
    }

}
