package model;

import builder.TransportType;

import static builder.TransportType.BUS;

public class Bus extends Transport {
    public Bus(String vin, int maxSpeed, String ecoClass, int width, int height, int length) {
        super(vin, maxSpeed, ecoClass, width, height, length);
    }

    @Override
    public TransportType getType() {
        return BUS;
    }
}
