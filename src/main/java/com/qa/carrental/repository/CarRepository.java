package com.qa.carrental.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.carrental.entity.Car;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Integer> {

	// Get car by model
	List<Car> findByModel(String model);

	// Get car by RegNum
	List<Car> findByRegNum(String regNum);
	
	//Get car by seats
	List<Car> finBySeats(int seats);
	
	//Get car by colour
	List<Car> findByColour(String colour);
	
	// Get car by category
	List<Car> findByCategory(String category);
	
	// Get car by price
	@Query("select c from Car c where c.price <= :price")
	List<Car> findByPrice( double carPricePerDay);
	
	// Get car if is available
	List<Car> findByIsAvailable(boolean isAvailable);
	
	//Modifying
	@Modifying
	@Query("Update CarPrice c set c.price = :price where c.id = :id")
	int updateCarDetails(int id, double carPricePerDay);
}
