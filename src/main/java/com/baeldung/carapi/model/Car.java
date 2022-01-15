package com.baeldung.carapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
  
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 @JsonProperty(access = JsonProperty.Access.READ_ONLY)
 private int id;
  
 @Column(name="CAR_NAME")
 private String carName;
  
 @Column(name="CATEGORY")
 private String category;
 
 @Column(name="RATING")
 private Integer rating;
  
 @Column(name="BRAND")
 private String brand;

 public Car(String carName, String category, Integer rating, String brand) {
  this.carName = carName;
  this.category = category;
  this.rating = rating;
  this.brand = brand;
 }
}