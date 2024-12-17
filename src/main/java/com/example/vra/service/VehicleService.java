package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vra.entity.Vehicle;
import com.example.vra.exception.VehicleNotFoundByIdException;
import com.example.vra.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public VehicleService(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		Vehicle vehicle2= vehicleRepository.save(vehicle);
		return vehicle2;
	}

	public Vehicle update(Vehicle vehicle) {
		Optional<Vehicle> optional = vehicleRepository.findById(vehicle.getVehicleId());
		if(optional.isPresent()) {
			return vehicleRepository.save(vehicle);
		}else {
			throw new VehicleNotFoundByIdException("Vehicle not found");
		}
	}
	
	
}
