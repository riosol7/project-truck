package com.transporation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transporation.entity.Route;
import com.transporation.repo.TransportationRepo;

@Service
public class RouteService {

	@Autowired
	TransportationRepo repo;
	
	public Route post(Route route) {
		return repo.save(route);
	};
	
	public Route findRouteByTruckId(int truckId) {
		return repo.findRouteByTruckId(truckId);
	};
}
