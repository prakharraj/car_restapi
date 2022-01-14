package com.baeldung.carapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@Data
public class Car {
  
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private int id;
  
 @Column(name="CAR_NAME")
 private String carName;
  
 @Column(name="CATEGORY")
 private String category;
 
 @Column(name="RATING")
 private Integer rating;
  
 @Column(name="BRAND")
 private String brand;
 
}