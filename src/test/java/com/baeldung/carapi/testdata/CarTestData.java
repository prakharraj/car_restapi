package com.baeldung.carapi.testdata;

import com.baeldung.carapi.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarTestData {

    public static String carsJson = "[{\"id\":1,\"carName\":\"A6\",\"category\":\"Audi\",\"rating\":8,\"brand\":\"Sedan\"},{\"id\":2,\"carName\":\"Baleno\",\"category\":\"Maruti\",\"rating\":4,\"brand\":\"Mini\"}]";
    public static String carJson = "{\"id\":2,\"carName\":\"Baleno\",\"category\":\"Maruti\",\"rating\":4,\"brand\":\"Mini\"}";
    public static String createCarJson = "{\"carName\":\"Baleno\",\"category\":\"Maruti\",\"rating\":4,\"brand\":\"Mini\"}";

    public static List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"A6","Audi",8,"Sedan"));
        cars.add(new Car(2,"Baleno","Maruti",4,"Mini"));
        return cars;
    }

    public static Car getCar(){
       return new Car(2,"Baleno","Maruti",4,"Mini");
    }

    public static Car createCar(){
        return new Car("Baleno","Maruti",4,"Mini");
    }
}
