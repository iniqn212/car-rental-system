package com.qa.carrental.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.carrental.entity.Booking;
import com.qa.carrental.exception.BookingAlreadyExistsException;
import com.qa.carrental.exception.BookingNotFoundException;
import com.qa.carrental.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBooking() {
		
	
		return this.bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(int id) throws BookingNotFoundException{

		Optional<Booking> optionalFindBookingById = bookingRepository.findById(id);
		if (!optionalFindBookingById.isPresent()) {
			
			throw new BookingNotFoundException();
		}
		
		return optionalFindBookingById.get();
	}
	
	@Override
	public List<Booking> getBookingByRentDate (LocalDate rentDate){
		
		return this.bookingRepository.findByRentDate(rentDate);
	}
	
	@Override
	public List<Booking> getBookingByReturnDate (LocalDate returnDate){
		
		return this.bookingRepository.findByReturnDate(returnDate);
	}
	
	@Override
	public List<Booking> getBookingByStatus( String status){
		
		return this.bookingRepository.findByBookingStatus(status);
	}
	
	@Override
	public List<Booking> getBookingByPrice( double bookingPrice){
		
		return this.bookingRepository.findByBookingPrice(bookingPrice);
	}
	
	@Override
	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException {
		Optional<Booking> optionalBookingFoundById = this.bookingRepository.findById(booking.getBookingId());
	if(optionalBookingFoundById.isPresent()) {
		throw new BookingAlreadyExistsException();
	}
	return this.bookingRepository.save(booking);
	}
	
	@Override
	public Booking updateBookingDetails(int id,LocalDate rentDate, LocalDate returnDate, String status ,double bookingPrice, boolean isAvailable) throws BookingNotFoundException {
		
		Booking updatedBooking = null;
		
		Optional<Booking> optionalBookingFoundById = this.bookingRepository.findById(id);
		
		if (!optionalBookingFoundById.isPresent()) {
			throw new BookingNotFoundException();
		}
		else {
			int rows = this.bookingRepository.updateBookingDetails(id, rentDate, returnDate, status, bookingPrice,isAvailable);
			if (rows > 0) {
				updatedBooking = this.bookingRepository.findById(id).get();
			}
		}

		return updatedBooking;
	}
	
	@Override
	public Booking updateBookingStatus(int id, String status, boolean isAvailable) throws BookingNotFoundException {
		
		Booking updatedBookingStatus = null;
		
		Optional<Booking> optionalBookingFoundById = this.bookingRepository.findById(id);
		
		if (!optionalBookingFoundById.isPresent()) {
			throw new BookingNotFoundException();
		}
		else {
			int rows = this.bookingRepository.updateBookingStatus(id,status,isAvailable);
			if (rows > 0) {
				updatedBookingStatus = this.bookingRepository.findById(id).get();
			}
		}

		return updatedBookingStatus;
	}
	
	@Override
	public Booking updateBookingReturnDate(int id, LocalDate returnDate) throws BookingNotFoundException {
		
		Booking updatedBookingReturnDate = null;
		
		Optional<Booking> optionalBookingFoundById = this.bookingRepository.findById(id);
		
		if (!optionalBookingFoundById.isPresent()) {
			throw new BookingNotFoundException();
		}
		else {
			int rows = this.bookingRepository.updatedBookingReturnDate(id,returnDate);
			if (rows > 0) {
				updatedBookingReturnDate = this.bookingRepository.findById(id).get();
			}
		}

		return updatedBookingReturnDate;
	}
	
	@Override
	public boolean deleteBooking(int id) throws BookingNotFoundException {
		boolean status = false;
		
		Optional<Booking> optionalBookingFoundById = this.bookingRepository.findById(id);
		
		if(!optionalBookingFoundById.isPresent()) {
			throw new BookingNotFoundException();
		}
		else {
			this.bookingRepository.delete(optionalBookingFoundById.get());
			status = true;
		}
		
		return status;	
	}
}
