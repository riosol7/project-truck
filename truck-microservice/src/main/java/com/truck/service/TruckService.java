package com.truck.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.truck.entity.Truck;
import com.truck.enums.*;
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
		details.setWeight(foundTruck.getWeight());
		details.setWeight(foundTruck.getVolume());
		details.setMpg(foundTruck.getMpg());
		details.setSpace(foundTruck.getSpace());
		details.setType(foundTruck.getType());

		return details;
	};

	public TruckTransportation findTruckRouteByTruckId(int id, Exception e) {

		Truck foundTruck = repo.findById(id).orElse(new Truck());

		if (foundTruck.getMake() == null && foundTruck.getModel() == null && foundTruck.getWeight() == null
				&& foundTruck.getVolume() == null && foundTruck.getSpace() == null && foundTruck.getType() == null) {

			TruckTransportation stale = new TruckTransportation();

			stale.setTruckId(id);
			stale.setMake("honda");
			stale.setModel("ridgeline");
			stale.setYear(2020);
			stale.setWeight("5000 kg");
			stale.setVolume("15 M");
			stale.setMpg(30);
			stale.setSpace("10m x 2m");
			stale.setType(Type.ELECTRIC);

			stale.setRouteId("10001");
			stale.setStartDate(new Date());
			stale.setEndDate(new Date());

			Time time = new Time(0L);
			stale.setStartTime(time);
			stale.setEndTime(time);
			stale.setStatus(Status.valueOf("IN_PROGRESS"));

			return stale;

		}

		TruckTransportation stale = new TruckTransportation();

		stale.setTruckId(id);
		stale.setMake(foundTruck.getMake());
		stale.setModel(foundTruck.getModel());
		stale.setYear(foundTruck.getYear());
		stale.setWeight(foundTruck.getWeight());
		stale.setVolume(foundTruck.getVolume());
		stale.setMpg(foundTruck.getMpg());
		stale.setSpace(foundTruck.getSpace());
		stale.setType(foundTruck.getType());

		stale.setRouteId("10001");
		stale.setStartDate(new Date());
		stale.setEndDate(new Date());

		Time time = new Time(0L);
		stale.setStartTime(time);
		stale.setEndTime(time);
		stale.setStatus(Status.valueOf("IN_PROGRESS"));

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
		updatedTruck.setWeight(truck.getWeight());
		updatedTruck.setWeight(truck.getVolume());
		updatedTruck.setMpg(truck.getMpg());
		updatedTruck.setSpace(truck.getSpace());
		updatedTruck.setType(truck.getType());

		return repo.save(updatedTruck);
	};

	public String delete(int id) {
		repo.deleteById(id);

		return "Truck ID: " + id + " has been deleted";
	}

}
