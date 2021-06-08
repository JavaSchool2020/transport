package model;

import builder.TransportType;

public class Motorcycle extends Transport{
    public Motorcycle(String vin, int maxSpeed, String ecoClass, int width, int height, int length) {
        super(vin, maxSpeed, ecoClass, width, height, length);
    }

    @Override
    public TransportType getType() {
        return TransportType.MOTORCYCLE;
    }
}
