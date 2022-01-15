package com.baeldung.carapi.repository;

import com.baeldung.carapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
  List<Car> findByBrandIgnoreCase(String brand);
  List<Car> findByRatingGreaterThanOrderByRatingDesc(int rating);
}