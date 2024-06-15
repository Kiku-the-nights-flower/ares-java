package org.example.javaares;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Optional;
import org.json.JSONObject;

@Service
public class MainService {

    // Temporary in-memory database
    ArrayList<Subject> subjects = new ArrayList<>();

    public MainService() {
        initializeTestData();
    }

    /**
     * Temporary method to add test data to the "database"
     * */
    private void initializeTestData() {
        subjects.add(new Subject(1L, "Google", "USA", "Mountain View", "123456", "CZ123456"));
        subjects.add(new Subject(2L, "Microsoft", "USA", "Redmond", "654321", "CZ654321"));
        subjects.add(new Subject(3L, "Apple", "USA", "Cupertino", "987654", "CZ987654"));
    }

    /**
     * Searches the database for a subject with the given ico
     * @param ico ico of the subject
     * @return Optional of the subject if found, empty Optional otherwise
     * TODO convert to do database search instead of in-memory search
     * */
    public Optional<Subject> search(String ico) {
        return subjects.stream().filter(subject -> subject.ico.equals(ico)).findFirst();
    }

    /**
     * Adds the subject to the database
     * @param subject subject to be added
     * TODO convert to do database add instead of in-memory add
     * */
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    /**
     * Fetches the subject from the API
     * @param ico ico of the subject
     * @return Optional of the subject if found, empty Optional if ico is not valid or exception thrown
     * */
    public Optional<Subject> getSubject(String ico) {
        if (ico.isEmpty())
            return Optional.empty();
        //validate ico so that it really is ico
        Optional<Subject> subject = search(ico);

        if (subject.isPresent()) {
            return subject;
        }

        return fetchData(ico);
    }

    /**
     * Fetches the subject from the ARES API
     * @param ico ico of the subject
     * @return Optional of the subject if found, empty Optional if either not found or exception thrown
     * */
    public Optional<Subject> fetchData(String ico) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("https://ares.gov.cz/ekonomicke-subjekty-v-be/rest/ekonomicke-subjekty/" + ico))
                    .build();

            String response = client.send(req, HttpResponse.BodyHandlers.ofString()).body();
            JSONObject jsonObject = new JSONObject(response);
            Subject resultSubject = new Subject(jsonObject);
            addSubject(resultSubject);
            return Optional.of(resultSubject);
        } catch (IOException | InterruptedException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}