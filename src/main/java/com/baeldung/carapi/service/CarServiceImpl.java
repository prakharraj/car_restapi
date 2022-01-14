package com.baeldung.carapi.service;

import com.baeldung.carapi.model.Car;
import com.baeldung.carapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<Car>();
        carRepository.findAll(Sort.by(Sort.Direction.ASC, "rating"))
                .forEach(cars::add);
        return cars;
    }

    @Override
    public Optional<Car> getCarById(int id) {
        Optional<Car> car = carRepository.findById(id);
        return car;
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
        }
        return carRepository.save(carReq);
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
