package com.qa.carrental.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Booking with this ID already exists")
public class BookingAlreadyExistsException extends Exception {

}
