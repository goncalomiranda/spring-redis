package com.mbakongo.webservices.redis.plant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlantNotFoundException extends RuntimeException {

	public PlantNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
