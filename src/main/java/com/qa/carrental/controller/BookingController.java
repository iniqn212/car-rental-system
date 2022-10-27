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

import com.qa.carrental.entity.Booking;
import com.qa.carrental.exception.BookingAlreadyExistsException;
import com.qa.carrental.exception.BookingNotFoundException;
import com.qa.carrental.service.BookingServiceImpl;

@RestController
@RequestMapping("api/v1")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;

	ResponseEntity<?> responseEntity;

	@GetMapping("/booking")
	public ResponseEntity<?> getAllBooking() {
		try {
			List<Booking> bookingList = this.bookingService.getAllBooking();
			responseEntity = new ResponseEntity<>(bookingList, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/booking/{id}")
	public ResponseEntity<?> getBookingById(@PathVariable("id") int id) throws BookingNotFoundException {

		try {

			Booking bookingById = this.bookingService.getBookingById(id);
			responseEntity = new ResponseEntity<>(bookingById, HttpStatus.OK);
		} catch (BookingNotFoundException e) {
			throw e;
		} catch (Exception e) {

			System.out.println("Internal error");

		}

		return responseEntity;
	}

	@GetMapping("/booking/rentDate/{rentDate}")
	public ResponseEntity<?> getBookingByRentDate(@PathVariable("rentDate") LocalDate rentDate) {

		try {

			List<Booking> bookingList = this.bookingService.getBookingByRentDate(rentDate);
			responseEntity = new ResponseEntity<>(bookingList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}

	@GetMapping("/booking/returnDate/{returnDate}")
	public ResponseEntity<?> getBookingByReturnDate(@PathVariable("returnDate") LocalDate returnDate) {

		try {

			List<Booking> bookingList = this.bookingService.getBookingByReturnDate(returnDate);
			responseEntity = new ResponseEntity<>(bookingList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}

	@GetMapping("/booking/status/{status}")
	public ResponseEntity<?> getByBookingStatus(@PathVariable("returnDate") String status) {

		try {

			List<Booking> bookingList = this.bookingService.getBookingByStatus(status);
			responseEntity = new ResponseEntity<>(bookingList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}

	@GetMapping("/booking/bookingPrice/{bookingPrice}")
	public ResponseEntity<?> getByBookingPrice(@PathVariable("bookingPrice") double bookingPrice) {

		try {

			List<Booking> bookingList = this.bookingService.getBookingByPrice(bookingPrice);
			responseEntity = new ResponseEntity<>(bookingList, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Internal error");
		}

		return responseEntity;
	}

	@PostMapping("/booking")
	public ResponseEntity<?> addBooking(@RequestBody Booking booking) throws BookingAlreadyExistsException {
		try {
			Booking addedBooking = this.bookingService.addBooking(booking);
			responseEntity = new ResponseEntity<>(addedBooking, HttpStatus.CREATED);
		} catch (BookingAlreadyExistsException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PutMapping("/booking")
	public ResponseEntity<?> updateBookingStatus(@RequestBody Booking booking) throws BookingNotFoundException {

		try {
			Booking updatedBookingStatus = this.bookingService.updateBookingStatus(booking.getBookingId(),
					booking.getBookingStatus(), booking.isAvailable());
			responseEntity = new ResponseEntity<>(updatedBookingStatus, HttpStatus.OK);
		} catch (BookingNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	@PutMapping("/booking")
	public ResponseEntity<?> updateBookingDetails(@RequestBody Booking booking) throws BookingNotFoundException {

		try {
			Booking updatedBooking = this.bookingService.updateBookingDetails(booking.getBookingId(),
					booking.getRentDate(), booking.getReturnDate(), booking.getBookingStatus(),
					booking.getBookingPrice(), booking.isAvailable());
			responseEntity = new ResponseEntity<>(updatedBooking, HttpStatus.OK);
		} catch (BookingNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	@PutMapping("/booking")
	public ResponseEntity<?> updateBookingReturnDate(@RequestBody Booking booking) throws BookingNotFoundException {

		try {
			Booking updatedBookingReturnDate = this.bookingService.updateBookingReturnDate(booking.getBookingId(),
					booking.getReturnDate());
			responseEntity = new ResponseEntity<>(updatedBookingReturnDate, HttpStatus.OK);
		} catch (BookingNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}

	@DeleteMapping("/booking/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable int id) throws BookingNotFoundException {

		try {
			boolean status = this.bookingService.deleteBooking(id);
			responseEntity = new ResponseEntity<>(status, HttpStatus.OK);
		} catch (BookingNotFoundException e) {
			throw e;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
}
