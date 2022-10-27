package com.qa.carrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No customer found with this ID")
public class CustomerNotFoundException extends Exception {

}
