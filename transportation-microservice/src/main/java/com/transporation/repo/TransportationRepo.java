package com.transporation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.transporation.document.Route;

public interface TransportationRepo extends MongoRepository<Route, Integer> {

	Route findRouteByTruckId(int truckId);
}
