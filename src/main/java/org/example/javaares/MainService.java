package org.example.javaares;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MainService {

    ArrayList<Subject> subjects = new ArrayList<>();

    public MainService() {
        initializeTestData();
    }

    private void initializeTestData() {
        subjects.add(new Subject(1L, "Subject1", "Street1", "1", "City1", "Country1", "PostalCode1", "ico1", "DIC1"));
        subjects.add(new Subject(2L, "Subject2", "Street2", "2", "City2", "Country2", "PostalCode2", "ico2", null));
        subjects.add(new Subject(3L, "Subject3", "Street3", "3", "City3", "Country3", "PostalCode3", "ico3", "DIC3"));
    }

    public Optional<Subject> search(String ico) {
        return subjects.stream().filter(subject -> subject.ico.equals(ico)).findFirst();
    }
}