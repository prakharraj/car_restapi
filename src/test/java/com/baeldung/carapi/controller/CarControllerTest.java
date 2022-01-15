package com.baeldung.carapi.controller;


import com.baeldung.carapi.service.CarService;
import com.baeldung.carapi.testdata.CarTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static com.baeldung.carapi.testdata.CarTestData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService carService;

    @Test
    public void getAllCarsSuccessfully() throws Exception {

        when(carService.getAllCars(Optional.of(2))).thenReturn(CarTestData.getCars());

        this.mvc.perform(get("/v1/car?ratingAbove=2"))
                .andExpect(status().isOk())
                .andExpect(content().json(carsJson));
    }

    @Test
    public void getAllCarsNoContent() throws Exception {

        when(carService.getAllCars(Optional.of(2))).thenReturn(Collections.emptyList());

        this.mvc.perform(get("/v1/car?ratingAbove=2"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getCarFromIdSuccessfully() throws Exception {

        when(carService.getCarById(2)).thenReturn(Optional.of(CarTestData.getCar()));

        this.mvc.perform(get("/v1/car/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(carJson));
    }

    @Test
    public void getCarFromIdNotFound() throws Exception {

        when(carService.getCarById(2)).thenReturn(Optional.empty());

        this.mvc.perform(get("/v1/car/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createCarSuccessfully() throws Exception {

        when(carService.createCar(CarTestData.createCar()))
                .thenReturn(CarTestData.getCar());

        this.mvc.perform(post("/v1/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createCarJson))
                .andExpect(status().isCreated())
                .andExpect(content().json(carJson));
    }

    @Test
    public void deleteCarSuccessfully() throws Exception {

        when(carService.deleteCar(2))
                .thenReturn(null);

        this.mvc.perform(delete("/v1/car/2"))
                .andExpect(status().isNoContent());
    }
}
