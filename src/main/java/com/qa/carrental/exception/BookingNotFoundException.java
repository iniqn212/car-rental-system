package com.qa.carrental.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No booking found with this ID")
public class BookingNotFoundException extends Exception {

}
