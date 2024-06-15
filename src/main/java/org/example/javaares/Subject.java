package org.example.javaares;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.swing.text.html.Option;
import java.util.Optional;

@Entity
public class Subject {

    @Id
    public Long id;
    public String name;
    public String street;
    public String streetNumber;
    public String city;
    public String country;
    public String postalCode;
    public String ico;
    public String dic;

    // No-argument constructor
    public Subject() {
    }

    // Constructor with arguments
    public Subject(Long id, String name, String street, String streetNumber, String city, String country, String postalCode, String ico, String dic) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.ico = ico;
        this.dic = dic;
    }
    
    public String toString() {
        return name + "\n" + street + "\n" + streetNumber + "\n" + city + "\n" + country + "\n" + postalCode + "\n" + dic;
    }

}
