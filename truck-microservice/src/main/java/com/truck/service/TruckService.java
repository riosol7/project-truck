package com.truck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truck.entity.Truck;
import com.truck.repo.TruckRepo;

@Service
public class TruckService {

	@Autowired
	TruckRepo repo;

	public Truck post(Truck truck) {
		return repo.save(truck);
	};
	
	public List<Truck> findAll(){
		return repo.findAll();
	};
	
	public Truck findById(int id) {
		return repo.findById(id).orElse(null);
	};
	
	public List<Truck> findByMake(String make){
		return repo.findByMake(make);
	};
	
	public List<Truck> findByModel(String model){
		return repo.findByModel(model);
	};
	
	public List<Truck> findByYear(int year){
		return repo.findByYear(year);
	};
	
	
	

}
