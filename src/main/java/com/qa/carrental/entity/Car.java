package com.qa.carrental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "car_rent")

public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "car_id")
	private int id;
	
	
	@Column(name = "car_model")
	private String model;
	
	@Column(name = "car_category")
	private String category;
	
	@Column(name = "car_regNum")
	private String regNum;
	
	@Column(name = "car_seats")
	private int seats;
	
	@Column(name = "car_colour")
	private String colour;
	
	@Column(name = "car_price")
	private double carPricePerDay;
	
	@Column(name = "car_Available")
	private boolean isAvailable;

}
