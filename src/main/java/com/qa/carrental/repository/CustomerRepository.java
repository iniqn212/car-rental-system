package com.qa.carrental.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.carrental.entity.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// get by id
	List<Customer> findByName(String name);

	// get by post code
	List<Customer> findByPostcode(String postcode);

	// get by userName
	List<Customer> findByUserName(String userName);

	// get by email
	List<Customer> findByEmail(String email);

	// get by phone number
	List<Customer> findByPhone(String phoneNum);

	// get by date of birth
	List<Customer> findByDob(LocalDate dob);

	// get by address and post code
	@Query("select c from Customer c where = c.address =:address and c.postcode =:postcode")
	List<Customer> findByAddressAndPostcode(String address, String postcode);

	// modifying customer name
	@Modifying
	@Query("update customer c set c.name = :name, where c.id = :id")
	int updateCustomerName(int id, String name);

	// modifying customer details
	@Modifying
	@Query("update customer c set c.name = :name, c.address = :address, c.postcode = :postcode, c.email= :email, c.phoneNum = :phoneNum")
	int updateCustomerDetails(int id, String name, String address, String postcode, String email,String phoneNum);

	// modifying customer email and phone
	@Modifying
	@Query("update customer c set  c.email= :email, c.phoneNum = :phoneNum where c.id = :id")
	int updateCustomerEmailAndPhone(int id, String email, String phoneNum);

	// modifying customer user name
	@Modifying
	@Query("update customer c set c.userName = :userName where c.id = :id")
	int updateCustomerUserName(int id, String userName);

	// modifying customer password
	@Modifying
	@Query("update customer c set c.password = :password where c.id = :id")
	int updateCustomerPassword(int id, String password);

	// modifying customer address
	@Modifying
	@Query("update customer c set c.address = :address, c.postcode = :postcode where c.id = :id")
	int updateCustomerDetails(int id, String address, String postcode);

}
