package com.baeldung.carapi.controller;

import com.baeldung.carapi.model.Car;
import com.baeldung.carapi.repository.CarRepository;
import com.baeldung.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars(
            @RequestParam(required = false) Optional<Integer> ratingAbove) {
        try {
            List<Car> cars = carService.getAllCars(ratingAbove);
            if (cars.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            return new ResponseEntity<Car>(car.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/car/brand/{brand}")
    public ResponseEntity<List<Car>> findByBrand(@PathVariable("brand") String brand) {
        try {
            List<Car> cars = carService.getCarByBrand(brand);
            if (cars.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car carReq) {
        try {
            Car car = carService.createCar(carReq);
            return new ResponseEntity<>(car, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car carReq) {
        try {
            Car car = carService.updateCar(id, carReq);
            if(car!=null)
                return new ResponseEntity<>(car, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable("id") int id) {
        try {
            carService.deleteCar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}