package com.qa.carrental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	
	@NotNull
	@Size(min = 2, max = 20, message = "Car model must be between 2 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "Invalid car model, must contain only alphanumeric")
	@Column(name = "car_model")
	private String model;
	
	@NotNull
	@Size(min = 2, max = 20, message = "Category must be between 2 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "Invalid category, must contain only alphanumeric")
	@Column(name = "car_category")
	private String category;
	
	@NotNull
	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{3}", message = "Invalid car plate number , follow XX00XXX")
	@Column(name = "car_regNum")
	private String regNum;
	
	@Min(value = 4, message = "Car seat must be min 4 + 1 ")
	@Max(value = 9, message="Car seat be less than 9 + 1")
	@Column(name = "car_seats")
	private int seats;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Colour must be between 3 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "Invalid colour, must contain only alphanumeric")
	@Column(name = "car_colour")
	private String colour;
	
	@NotNull
	@Min(0)
	@Column(name = "car_price")
	private double carPricePerDay;
	
	@Column(name = "car_Available")
	private boolean isAvailable;

}
