package com.qa.carrental.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.carrental.entity.Booking;


@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	List<Booking> findByBookingId(int bookingId);
	
	List<Booking> findByRentDate(LocalDate rentDate);
	
	List<Booking> findByReturnDate(LocalDate returnDate);
	
	List<Booking> findByBookingStatus(String status);
	
	List<Booking> findByBookingPrice(double bookingPrice);
	
	@Modifying
	@Query("update booking status b set b.status = :status, b.isAvailable = :isAvailable where b.id = :id")
	int updateBookingStatus(int id, String status ,boolean isAvailable);
	
	@Modifying
	@Query("update booking details status b set b.rentDate = :rentDate,b.returnDate = : returnDate ,b.status = :status,b.bookingPrice = : bookingPrice, b.isAvailable = :isAvailable where b.id = :id")
	int updateBookingDetails(int id,LocalDate rentDate, LocalDate returnDate, String status ,double bookingPrice, boolean isAvailable);

	@Modifying
	@Query("update booking details status b set b.returnDate = : returnDate , where b.id = :id")
	int updatedBookingReturnDate(int id, LocalDate returnDate);
	
}
