package com.qa.carrental.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.carrental.entity.Booking;
import com.qa.carrental.exception.BookingAlreadyExistsException;
import com.qa.carrental.exception.BookingNotFoundException;

@Service
public interface BookingService {

	public List<Booking> getAllBooking();

	public Booking getBookingById(int id) throws BookingNotFoundException;

	public List<Booking> getBookingByRentDate(LocalDate rentDate);
	
	public List<Booking> getBookingByReturnDate(LocalDate returnDate);

	public List<Booking> getBookingByStatus(String status);

	public List<Booking> getBookingByPrice(double bookingPrice);

	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException;

	public Booking updateBookingDetails(int id, LocalDate rentDate, LocalDate returnDate, String status, double bookingPrice,
			boolean isAvailable) throws BookingNotFoundException;

	public Booking updateBookingStatus(int id, String status, boolean isAvailable) throws BookingNotFoundException;

	Booking updateBookingReturnDate(int id, LocalDate returnDate) throws BookingNotFoundException;
	
	public boolean deleteBooking(int id) throws BookingNotFoundException;

	

	
	

}
