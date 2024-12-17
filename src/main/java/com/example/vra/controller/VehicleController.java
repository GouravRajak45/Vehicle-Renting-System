package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vra.entity.Vehicle;
import com.example.vra.responsestructure.ResponseStructure;
import com.example.vra.service.VehicleService;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}
	
	@PostMapping("/save-vehicle")
	public ResponseEntity<ResponseStructure<Vehicle>> saveVehicle(@RequestBody Vehicle vehicle) {
		Vehicle vehicle2= vehicleService.addVehicle(vehicle);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "Vehicle Data inserted", vehicle2));
	}
}
