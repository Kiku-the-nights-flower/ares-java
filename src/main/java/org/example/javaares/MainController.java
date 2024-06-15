package org.example.javaares;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final MainService service;

    @Autowired
    public MainController(MainService ser) {
        this.service = ser;
    }

    @GetMapping("/testing")
    public String testing() {
        return service.test();
    }

}
