package com.qa.carrental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.carrental.entity.Car;
import com.qa.carrental.exception.CarAlreadyExistsException;
import com.qa.carrental.exception.CarNotFoundException;
import com.qa.carrental.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {

		return carRepository.findAll();
	}

	@Override
	public Car getCarById(int id) throws CarNotFoundException {
		Optional<Car> optionalCarFoundById = carRepository.findById(id);
		if (!optionalCarFoundById.isPresent()) {
			throw new CarNotFoundException();
		}

		return optionalCarFoundById.get();
	}

	@Override
	public List<Car> getCarByModel(String model) {

		return this.carRepository.findByModel(model);
	}
	
	@Override
	public List<Car> getCarByRegNum(String regNum){
		return this.carRepository.findByRegNum(regNum);
	}
	
	@Override
	public List<Car> getCarBySeats(int seats){
		return this.carRepository.finBySeats(seats);
	}
	@Override
	public List<Car> getCarByColour(String colour){
		return this.carRepository.findByColour(colour);
	}
	@Override
	public List<Car> getCarByCategory(String category){
		return this.carRepository.findByCategory(category);
	}
	@Override
	public List<Car> getCarByPrice(double pricePerDay){
		return this.carRepository.findByPrice(pricePerDay);
	}
	
	@Override
	public List<Car> getCarByIsAvailable(boolean isAvailable){
		return this.carRepository.findByIsAvailable(isAvailable);
	}
	
	@Override
	public Car addCar(Car car) throws CarAlreadyExistsException  {
		
		Optional<Car> optionalCarFoundById = this.carRepository.findById(car.getId());
	     if(optionalCarFoundById.isPresent()) {
	    	 throw new CarAlreadyExistsException();
	     }
	     
	     return this.carRepository.save(car);
	}
	
	@Override
	public Car updateCarDetails (int id, double price) throws CarNotFoundException {
		
		Car updatedCarPrice = null;
		
		Optional<Car> optionalCarFoundById = this.carRepository.findById(id);
	     if(optionalCarFoundById.isPresent()) {
	    	 
	    	 throw new CarNotFoundException();
	     }
	     else {
	    	 int rows = this.carRepository.updateCarDetails(id, price);
	    	
	    	 if(rows > 0) {
	    		 updatedCarPrice = this.carRepository.findById(id).get();
	    	 }
	     }
	     
	     return updatedCarPrice;
	}
	
	@Override
	public boolean deleteCar(int id) throws CarNotFoundException {
		boolean status = false;
		
		Optional<Car> optionalCarFoundById = this.carRepository.findById(id);
		if(!optionalCarFoundById.isPresent()) {
			
			throw new CarNotFoundException();
		}
		else {
			this.carRepository.delete(optionalCarFoundById.get());
			status = true;
		}
		return status;
	}

	
	
	
}
