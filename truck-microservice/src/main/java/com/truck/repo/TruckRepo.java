package com.truck.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truck.entity.Truck;

public interface TruckRepo extends JpaRepository<Truck, Integer> {

	List<Truck> findByMakeAndModel(String make, String model);
	
	List<Truck> findByMake(String make);

	List<Truck> findByModel(String model);

	List<Truck> findByYear(int year);

}
