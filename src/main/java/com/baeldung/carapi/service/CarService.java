package com.baeldung.carapi.service;

import com.baeldung.carapi.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(int id);

    Car createCar(Car carReq);

    Car updateCar(int id, Car carReq);

    Boolean deleteCar(int id);

    List<Car> getCarByBrand(String brand);
}
