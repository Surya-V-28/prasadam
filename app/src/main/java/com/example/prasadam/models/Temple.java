package com.example.prasadam.models;

import java.io.Serializable;

public class Temple implements Serializable {
    public final String templeName;
    public final Address address;
    public final String mapId;
    public final String templeTime;
    public final String templeLocation;
    public final String templeDistance;
    public final int templeImage;

    public Temple(String templeName, Address address, String mapId, String templeTime, String templeLocation, String templeDistance, int templeImage) {
        this.templeName = templeName;
        this.address = address;
        this.mapId = mapId;
        this.templeTime = templeTime;
        this.templeLocation = templeLocation;
        this.templeDistance = templeDistance;
        this.templeImage = templeImage;
    }

}
