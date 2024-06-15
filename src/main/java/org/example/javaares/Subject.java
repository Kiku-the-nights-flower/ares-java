package org.example.javaares;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.json.JSONObject;

@Entity
public class Subject {

    @Id
    public String ico;
    public String name;
    public String country;
    public String address;
    public String dic;

    // No-argument constructor
    public Subject() {
    }

    /**
     * Constructor converting JSON object to Subject
     * */
    public Subject(JSONObject json) {
        this.ico = json.optString("ico");
        this.name = json.optString("obchodniJmeno");
        JSONObject sidlo = json.optJSONObject("sidlo");
        this.country = sidlo.optString("kodStatu");
        this.address = sidlo.optString("textovaAdresa");
        this.dic = json.optString("dic", "(Chybí)");
    }

    @Override
    public String toString() {
        return "name: " + name + "\ncountry: " + country + "\naddress: " + address + "\nico: " + ico + "\ndic: " + dic + "\n";
    }

}
