package model;

import builder.TransportType;

import java.time.ZonedDateTime;

public abstract class Transport {
    protected final String vin;
    protected final ZonedDateTime createDate;
    protected final int maxSpeed;
    protected String ecoClass;
    protected final Integer width;
    protected final Integer height;
    protected final Integer length;

    public Transport(String vin, int maxSpeed, String ecoClass, int width, int height, int length) {
        this.maxSpeed = maxSpeed;
        this.ecoClass = ecoClass;
        this.width = width;
        this.height = height;
        this.length = length;
        if (vin == null) {
            throw new IllegalArgumentException("Vin must be not null");
        }
        this.vin = vin;
        this.createDate = ZonedDateTime.now();
    }

    public String getVin() {
        return vin;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public String getEcoClass() {
        return ecoClass;
    }

    public abstract TransportType getType();
}
