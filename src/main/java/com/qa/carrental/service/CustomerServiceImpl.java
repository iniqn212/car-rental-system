package com.qa.carrental.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.carrental.entity.Customer;
import com.qa.carrental.exception.CustomerAlreadyExistsException;
import com.qa.carrental.exception.CustomerNotFoundException;
import com.qa.carrental.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public List<Customer> getAllCustomers() {

		return this.customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) throws CustomerNotFoundException{
		
		Optional<Customer> optionalCustomerFoundById = customerRepository.findById(id);
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		return optionalCustomerFoundById.get();
	}
	
	@Override
	public List<Customer> getCustomerByName(String name) {
		
		return this.customerRepository.findByName(name);
	}

	@Override
	public List<Customer> getCustomerByPostcode(String postcode) {
		
		return this.customerRepository.findByPostcode(postcode);
	}
	
	@Override
	public List<Customer> getCustomerByAddressAndPostcode(String address, String postcode) {
		
		return this.customerRepository.findByAddressAndPostcode(address, postcode);
	}
	
	@Override
	public List<Customer> getCustomerByEmail(String email){
		return this.customerRepository.findByEmail(email);
	}
	
	@Override
	public List<Customer> getCustomerByUserName(String userName){
		return this.customerRepository.findByEmail(userName);
	}
	
	@Override
	public List<Customer> getCustomerByDob(LocalDate dob){
		return customerRepository.findByDob(dob);
	}
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException{

		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(customer.getId());
		
		if (optionalCustomerFoundById.isPresent()) {
			throw new CustomerAlreadyExistsException();
		}
		
		return this.customerRepository.save(customer);
	}
	
	@Override
	public Customer updateCustomerName(int id, String name) throws CustomerNotFoundException{
		
		Customer updatedCustomerName = null;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			int rows = this.customerRepository.updateCustomerName(id, name);
			if (rows > 0) {
				updatedCustomerName = this.customerRepository.findById(id).get();
			}
		}
		
		return updatedCustomerName;
	}
	@Override
	public Customer updateCustomerDetails(int id, String name, String address, String postcode,String email, String phoneNum) throws CustomerNotFoundException{
		
		Customer updatedCustomerDetails = null;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			int rows = this.customerRepository.updateCustomerDetails(id, name, address, postcode, email, phoneNum);
			if (rows > 0) {
				updatedCustomerDetails = this.customerRepository.findById(id).get();
			}
		}
		
		return updatedCustomerDetails;
	}
	
	@Override
	public Customer updateCustomerEmailAndPhone(int id, String email, String phone) throws CustomerNotFoundException{
		
		Customer updatedCustomerEmailAndPhone = null;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			int rows = this.customerRepository.updateCustomerEmailAndPhone(id, email,phone);
			if (rows > 0) {
				updatedCustomerEmailAndPhone = this.customerRepository.findById(id).get();
			}
		}
		
		return updatedCustomerEmailAndPhone;
	}
	
	@Override
	public Customer updateCustomerUserName(int id, String userName) throws CustomerNotFoundException{
		
		Customer updatedCustomerUserName = null;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			int rows = this.customerRepository.updateCustomerUserName(id, userName);
			if (rows > 0) {
				updatedCustomerUserName = this.customerRepository.findById(id).get();
			}
		}
		
		return updatedCustomerUserName;
	}
	
	@Override
	public Customer updateCustomerPassword(int id, String password) throws CustomerNotFoundException{
		
		Customer updatedCustomerPassword = null;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			int rows = this.customerRepository.updateCustomerPassword(id, password);
			if (rows > 0) {
				updatedCustomerPassword = this.customerRepository.findById(id).get();
			}
		}
		
		return updatedCustomerPassword;	
	}
	@Override
	public Customer updateCustomerAddressAndPostcode(int id, String address, String postcode) throws CustomerNotFoundException{
		
		Customer updatedCustomerAddressAndPostcode = null;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if (!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			int rows = this.customerRepository.updateCustomerDetails(id, address, postcode);
			if (rows > 0) {
				updatedCustomerAddressAndPostcode = this.customerRepository.findById(id).get();
			}
		}
		
		return updatedCustomerAddressAndPostcode;
	}
	
	/*
	 * CHECK IF IS UNDER 18
	 * @Override
	public boolean checkCustomer(int id , LocalDate dob)  {
		boolean status = false;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if() {
			
		}
		else {
			
			status = true;
		}
		
		return status;	
	}
	 */
	
	@Override
	public boolean deleteCustomer(int id) throws CustomerNotFoundException {
		boolean status = false;
		
		Optional<Customer> optionalCustomerFoundById = this.customerRepository.findById(id);
		
		if(!optionalCustomerFoundById.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			this.customerRepository.delete(optionalCustomerFoundById.get());
			status = true;
		}
		
		return status;	
	}
	
	
	

	

}
