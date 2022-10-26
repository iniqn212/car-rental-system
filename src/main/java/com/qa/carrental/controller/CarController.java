package com.qa.carrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.carrental.entity.Car;
import com.qa.carrental.exception.CarAlreadyExistsException;
import com.qa.carrental.exception.CarNotFoundException;
import com.qa.carrental.service.CarServiceImpl;

@RestController
@RequestMapping("api/v1")
public class CarController {

	@Autowired
	CarServiceImpl carService;
	
	ResponseEntity<?> responseEntity;
	
	@GetMapping("/car")
	public ResponseEntity<?> getAllCars(){
		
		try {
			List<Car> carList = this.carService.getAllCars();
			responseEntity = new ResponseEntity<>(carList, HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println("ERROR");
		}
		
		return responseEntity;
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<?> getCarById(@PathVariable("id") int id) throws CarNotFoundException{
		try {
			Car carById = this.carService.getCarById(id);
			responseEntity = new ResponseEntity<>(carById, HttpStatus.OK);
			}
		catch(CarNotFoundException e) {
			throw e;
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;
	}
	
	@GetMapping("/car/price/{pricePerDay}")
	public ResponseEntity<?> getCarByPrice(@PathVariable("price") double pricePerDay){
		try { 
			List<Car> carByPrice = this.carService.getCarByPrice(pricePerDay);
			responseEntity = new ResponseEntity<>(carByPrice, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		return responseEntity;	
	}
	
	@GetMapping("/car/category/{category}")
	public ResponseEntity<?> getCarByCategory(@PathVariable("category") String category){
		try { 
			List<Car> carByCategory = this.carService.getCarByCategory(category);
			responseEntity = new ResponseEntity<>(carByCategory, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;	
	}
	@GetMapping("/car/colour/{colour}")
	public ResponseEntity<?> getCarByColour(@PathVariable("category") String colour){
		try { 
			List<Car> carByColour = this.carService.getCarByColour(colour);
			responseEntity = new ResponseEntity<>(carByColour, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;	
	}
	@GetMapping("/car/regNum/{regNum}")
	public ResponseEntity<?> getCarByRegNum(@PathVariable("regNum") String regNum){
		try { 
			List<Car> carByRegNum = this.carService.getCarByRegNum(regNum);
			responseEntity = new ResponseEntity<>(carByRegNum, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;	
	}
	@GetMapping("/car/model/{model}")
	public ResponseEntity<?> getCarByModel(@PathVariable("model") String model){
		try { 
			List<Car> carByModel = this.carService.getCarByModel(model);
			responseEntity = new ResponseEntity<>(carByModel, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;	
	}
	@GetMapping("/car/Seats/{seats}")
	public ResponseEntity<?> getCarBySeats(@PathVariable("seats") int seats){
		try { 
			List<Car> carBySeats = this.carService.getCarBySeats(seats);
			responseEntity = new ResponseEntity<>(carBySeats, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;	
	}
	
	@GetMapping("/car/isAvailable/{isAvailable}")
	public ResponseEntity<?> getCarByisAvailable(@PathVariable("isAvailable") boolean isAvailable){
		try { 
			List<Car> carByIsAvailable = this.carService.getCarByIsAvailable(isAvailable);
			responseEntity = new ResponseEntity<>(carByIsAvailable, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println("Internal Error");
		}
		
		return responseEntity;	
	}
	
	@PostMapping("/car")
	public ResponseEntity<?> addCar(@RequestBody Car car) throws CarAlreadyExistsException{
		try {
			Car addedCar = this.carService.addCar(car);
			responseEntity = new ResponseEntity<>(addedCar, HttpStatus.CREATED);
			}
		catch (CarAlreadyExistsException e) {
			throw e;
		}
		catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@PutMapping("/car/update_price")
	public ResponseEntity<?> updateCarPrice(@RequestBody Car car) throws CarNotFoundException{
		try {
			Car updatedCarPrice = this.carService.updateCarDetails(car.getId(),car.getCarPricePerDay());
		responseEntity = new ResponseEntity<>(updatedCarPrice, HttpStatus.OK);
		}
		catch(CarNotFoundException e){
			throw e;	
		}
		catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;	
	}
	@DeleteMapping("/car/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id) throws CarNotFoundException {
		try {
			boolean status = this.carService.deleteCar(id);
			responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
		}
		catch(CarNotFoundException e) {
			throw e;
		}
		catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;	
	}
}
