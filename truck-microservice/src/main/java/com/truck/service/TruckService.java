package com.truck.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.truck.entity.Truck;
import com.truck.model.TruckTransportation;
import com.truck.repo.TruckRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class TruckService {

	@Autowired
	TruckRepo repo;

	@Autowired
	RestTemplate rest;

	@Value("${transportation.url}")
	String url;

	public Truck post(Truck truck) {
		return repo.save(truck);
	};

	public List<Truck> findAll() {
		return repo.findAll();
	};

	@CircuitBreaker(name = "transportation", fallbackMethod = "findTruckRouteByTruckId")
	public TruckTransportation findById(int id) {

		Truck foundTruck = repo.findById(id).orElse(null);

		ResponseEntity<TruckTransportation> res = ResponseEntity
				.ok(rest.getForObject(url + id, TruckTransportation.class));

		TruckTransportation details = res.getBody();

		details.setMake(foundTruck.getMake());
		details.setModel(foundTruck.getModel());
		details.setYear(foundTruck.getYear());

		return details;
	};

	public TruckTransportation findTruckRouteByTruckId(int id, Exception e) {

		Truck foundTruck = repo.findById(id).orElse(null);

		TruckTransportation stale = new TruckTransportation();

		stale.setTruckId(id);
		stale.setMake(foundTruck.getMake());
		stale.setModel(foundTruck.getModel());
		stale.setYear(foundTruck.getYear());

		stale.setRouteId("10001");
		stale.setStartDate(new Date());
		stale.setEndDate(new Date());
		stale.setStartingPoint(null);
		stale.setDestination(null);
		stale.setCompleted(false);

		return stale;
	}

	public List<Truck> findByMake(String make) {
		return repo.findByMake(make);
	};

	public List<Truck> findByModel(String model) {
		return repo.findByModel(model);
	};

	public List<Truck> findByYear(int year) {
		return repo.findByYear(year);
	};

	public Truck put(Truck truck) {
		Truck updatedTruck = repo.findById(truck.getId()).orElse(null);

		updatedTruck.setMake(truck.getMake());
		updatedTruck.setModel(truck.getModel());
		updatedTruck.setYear(truck.getYear());

		return repo.save(updatedTruck);
	};

	public String delete(int id) {
		repo.deleteById(id);

		return "Truck ID: " + id + " has been deleted";
	}

}
