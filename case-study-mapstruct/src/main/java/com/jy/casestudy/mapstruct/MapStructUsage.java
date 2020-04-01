package com.jy.casestudy.mapstruct;

public class MapStructUsage {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("amen");
        car.setNumberOfSeats(100);
        car.setType(CarType.SEDAN);
        System.out.println(CarMapper.INSTANCE.carToCarDto(car));
    }
}
