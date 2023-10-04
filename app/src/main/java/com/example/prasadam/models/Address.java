package com.example.prasadam.models;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class Address implements Serializable {
    public Address(
        String streetAddress0, String streetAddress1, String city, int pinCode, String state
    ) {
        this.streetAddress0 = streetAddress0;
        this.streetAddress1 = streetAddress1;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    @NonNull
    @Override
    public String toString() {
        return streetAddress0 + ","
            + "\n" + streetAddress1 + ","
            + "\n" + city + " - " + pinCode + ","
            + "\n" + state;

    }

    public String getStreetAddress0() { return streetAddress0; }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPinCode() {
        return pinCode;
    }


    private final String streetAddress0;
    private final String streetAddress1;
    private final String city;
    private final int pinCode;
    private final String state;
}
