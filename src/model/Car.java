package model;

import builder.TransportType;

import static builder.TransportType.CAR;

public class Car extends Transport {
    public Car(String vin, int maxSpeed, String ecoClass, int width, int height, int length) {
        super(vin, maxSpeed, ecoClass, width, height, length);
    }

    @Override
    public TransportType getType() {
        return CAR;
    }
}
