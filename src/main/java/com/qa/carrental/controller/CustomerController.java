package com.qa.carrental.controller;

import java.time.LocalDate;
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

import com.qa.carrental.entity.Customer;
import com.qa.carrental.exception.CustomerAlreadyExistsException;
import com.qa.carrental.exception.CustomerNotFoundException;
import com.qa.carrental.service.CustomerServiceImpl;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerService;

	ResponseEntity<?> responseEntity;

	@GetMapping("/customer")
	public ResponseEntity<?> getAllCustomers() {

		try {
			List<Customer> customerList = this.customerService.getAllCustomers();
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException {

		try {

			Customer customerById = this.customerService.getCustomerById(id);
			responseEntity = new ResponseEntity<>(customerById, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	
	@GetMapping("/customer/name/{name}")
	public ResponseEntity<?> getCustomerByName(@PathVariable("name") String name){

		try {

			List<Customer> customerList = this.customerService.getCustomerByName(name);
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	@GetMapping("/customer/postcode/{postcode}")
	public ResponseEntity<?> getCustomerByPostcode(@PathVariable("postcode") String postcode){

		try {

			List<Customer> customerList = this.customerService.getCustomerByPostcode(postcode);
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	
	@GetMapping("/customer/address/{address}/postcode/{postcode}")
	public ResponseEntity<?> getCustomerByAddress(@PathVariable("address") String address,
			@PathVariable("postcode") String postcode) {

		try {

			List<Customer> customerList = this.customerService.getCustomerByAddressAndPostcode(address, postcode);
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	
	@GetMapping("/customer/email/{email}")
	public ResponseEntity<?> getCustomerByEmail(@PathVariable("email") String email){

		try {

			List<Customer> customerList = this.customerService.getCustomerByEmail(email);
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	
	@GetMapping("/customer/userName/{userName}")
	public ResponseEntity<?> getCustomerByuserName(@PathVariable("userName") String userName){

		try {

			List<Customer> customerList = this.customerService.getCustomerByName(userName);
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	@GetMapping("/customer/dob/{dob}")
	public ResponseEntity<?> getCustomerByDob(@PathVariable("dob") LocalDate dob){

		try {

			List<Customer> customerList = this.customerService.getCustomerByDob(dob);
			responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}
	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {

		try {
			Customer addedCustomer = this.customerService.addCustomer(customer);
			responseEntity = new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
		} catch (CustomerAlreadyExistsException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
	
	@PutMapping("/customer/update_name")
	public ResponseEntity<?> updateCustomerName(@RequestBody Customer customer) throws CustomerNotFoundException {

		try {
			Customer updatedCustomer = this.customerService.updateCustomerName(customer.getId(),customer.getName());
			responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}
	
	@PutMapping("/customer")
	public ResponseEntity<?> updateCustomerDetails(@RequestBody Customer customer) throws CustomerNotFoundException {

		try {
			Customer updatedCustomer = this.customerService.updateCustomerDetails(customer.getId(), customer.getName(),
					customer.getAddress(), customer.getPostcode(), customer.getEmail(), customer.getPhoneNum());
			responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;

	}
	
	@PutMapping("/customer/update_email_and_phone")
	public ResponseEntity<?> updateCustomerEmailAndPhone(@RequestBody Customer customer) throws CustomerNotFoundException {

		try {
			Customer updatedCustomer = this.customerService.updateCustomerEmailAndPhone(customer.getId(),customer.getEmail(),customer.getPhoneNum());
			responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}
	
	@PutMapping("/customer/update_userName")
	public ResponseEntity<?> updateCustomerUsername(@RequestBody Customer customer) throws CustomerNotFoundException {

		try {
			Customer updatedCustomer = this.customerService.updateCustomerUserName(customer.getId(),customer.getUserName());
			responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}
	
	@PutMapping("/customer/update_password")
	public ResponseEntity<?> updateCustomerPassword(@RequestBody Customer customer) throws CustomerNotFoundException {

		try {
			Customer updatedCustomer = this.customerService.updateCustomerPassword(customer.getId(),customer.getPassword());
			responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}
	
	@PutMapping("/customer/update_address")
	public ResponseEntity<?> updateCustomerAddress(@RequestBody Customer customer) throws CustomerNotFoundException {

		try {
			Customer updatedCustomer = this.customerService.updateCustomerAddressAndPostcode(customer.getId(),
					customer.getAddress(), customer.getPostcode());
			responseEntity = new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {

		try {
			boolean status = this.customerService.deleteCustomer(id);
			responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
}
