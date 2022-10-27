package com.qa.carrental.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.carrental.entity.Customer;
import com.qa.carrental.exception.CustomerAlreadyExistsException;
import com.qa.carrental.exception.CustomerNotFoundException;

@Service
public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int id) throws CustomerNotFoundException;

	public List<Customer> getCustomerByName(String name);

	public List<Customer> getCustomerByPostcode(String postcode);

	public List<Customer> getCustomerByAddressAndPostcode(String address, String postcode);

	public List<Customer> getCustomerByEmail(String email);

	public List<Customer> getCustomerByUserName(String userName);

	public List<Customer> getCustomerByDob(LocalDate dob);

	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;

	public Customer updateCustomerName(int id, String name) throws CustomerNotFoundException;

	public Customer updateCustomerDetails(int id, String name, String address, String postcode, String email, String phoneNum)
			throws CustomerNotFoundException;

	public Customer updateCustomerEmailAndPhone(int id, String email, String phone) throws CustomerNotFoundException;

	public Customer updateCustomerUserName(int id, String userName) throws CustomerNotFoundException;

	public Customer updateCustomerPassword(int id, String password) throws CustomerNotFoundException;

	public Customer updateCustomerAddressAndPostcode(int id, String address, String postcode) throws CustomerNotFoundException;

	public boolean deleteCustomer(int id) throws CustomerNotFoundException;
	

}
