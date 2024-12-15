package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public VehicleService(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}
	
	
}
