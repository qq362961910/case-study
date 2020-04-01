package com.jy.casestudy.mapstruct;

public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("make='").append(make).append('\'');
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
