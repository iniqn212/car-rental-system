package com.qa.carrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.carrental.entity.Car;
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
}
