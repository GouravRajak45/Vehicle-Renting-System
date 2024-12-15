package com.example.vra.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.vra.service.VehicleService;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}
	
	
}
