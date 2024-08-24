package com.baeldung.carapi.service;

import com.baeldung.carapi.model.Car;
import com.baeldung.carapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars(Optional<Integer> ratingAbove) {
        List<Car> cars = new ArrayList<Car>();
        carRepository.findByRatingGreaterThanOrderByRatingDesc
                        (ratingAbove.orElse(-1))
                .forEach(cars::add);
        return cars;
    }

    @Override
    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    @Override
    public Car createCar(Car carReq) {
        return carRepository.save(carReq);
    }

    @Override
    public Car updateCar(int id,Car carReq) {
        Optional<Car> carData = carRepository.findById(id);
        if (carData.isPresent()) {
            carReq.setId(id);
            return carRepository.save(carReq);
        }
        else
            return null;
    }

    @Override
    public Boolean deleteCar(int id) {
        carRepository.deleteById(id);
        return true;
    }

    public List<Car> getCarByBrand(String brand) {
        return carRepository.findByBrandIgnoreCase(brand);
    }

}
