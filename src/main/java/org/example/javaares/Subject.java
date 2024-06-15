package org.example.javaares;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.json.JSONObject;

@Entity
public class Subject {

    @Id
    public Long id;
    public String ico;
    public String name;
    public String country;
    public String address;
    public String dic;

    // No-argument constructor
    public Subject() {
    }

    public Subject(Long id, String name, String country, String address, String ico, String dic) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.ico = ico;
        this.dic = dic;
    }

    public Subject(JSONObject json) {
        this.id = -1L;
        this.ico = json.optString("ico");
        this.name = json.optString("obchodniJmeno");
        JSONObject sidlo = json.optJSONObject("sidlo");
        this.country = sidlo.optString("kodStatu");
        this.address = sidlo.optString("textovaAdresa");
        this.dic = json.optString("dic");
    }

    @Override
    public String toString() {
        return id + " " + name + " " + country + " " + address + " " + ico + " " + dic;
    }

}
