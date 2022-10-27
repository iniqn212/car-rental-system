package com.qa.carrental.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "customer_info")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;

	@NotNull
	@Size(min = 2, max = 50, message = "name must be between 2 and 50 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "invalid name, must contain only alphanumeric")
	@Column(name = "customer_name")
	private String name;
	
	@Column (name = "customer_dob")
	private LocalDate dob;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "invalid address, must contain only alphanumeric")
	@Column(name = "customer_address")
	private String address;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.]+@[a-zA-Z0-9.]+$", message = "Invalid car postcode  , follow XX0 0XX")
	@Column(name = "customer_postcode")
	private String postcode;
	
	@NotNull
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Invalid email")
	@Column (name = "customer_email")
	private String email;
	
	@NotNull	
	@Pattern(regexp = "^(?:(?:(?:\\+|00)44[\\s\\-\\.]?)?(?:(?:\\(?0\\)?)[\\s\\-\\.]?)?(?:\\d[\\s\\-\\.]?){10})|(?=\\(?\\d*\\)?[\\x20\\-\\d]*)(\\(?\\)?\\x20*\\-*\\d){11}", message = "invalid mobile number")
	@Column(name = "customer_phone")
	private String phoneNum;
	
	@NotNull
	@Size(min = 5, max = 50, message = "name must be between 5 and 50 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "invalid user name, must contain only alphanumeric")
	@Column (name = "customer_userName")
	private String userName;
	
	@NotNull
	@Size(min = 8, max = 20, message = "name must be between 6 and 50 characters only")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "invalid  Password must contain at least one digit.\r\n"
			+ "Password must contain at least one lowercase Latin character.\r\n"
			+ "Password must contain at least one uppercase Latin character.\r\n"
			+ "Password must contain at least one special character like ! @ # & ( ).\r\n"
			+ "Password must contain a length of at least 8 characters and a maximum of 20 characters.")
	@Column(name = "customer_password")
	private String password;
}
