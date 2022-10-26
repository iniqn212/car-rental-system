package com.qa.carrental.service;

import java.util.List;

import com.qa.carrental.entity.Car;
import com.qa.carrental.exception.CarAlreadyExistsException;
import com.qa.carrental.exception.CarNotFoundException;

public interface CarService {

	List<Car> getAllCars();

	 public Car getCarById(int id) throws CarNotFoundException;

	public List<Car> getCarByModel(String model);

	public List<Car> getCarByRegNum(String regNum);

	public List<Car> getCarBySeats(int seats);

	public List<Car> getCarByColour(String colour);

	public List<Car> getCarByCategory(String category);

	public List<Car> getCarByPrice(double pricePerDay);

	public List<Car> getCarByIsAvailable(boolean isAvailable);

	public Car addCar(Car car) throws CarAlreadyExistsException;

	public Car updateCarDetails(int id, double price) throws CarNotFoundException;

	public boolean deleteCar(int id) throws CarNotFoundException;

	

	
	

}
