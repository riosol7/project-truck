package com.transporation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.transporation.entity.Route;

public interface TransportationRepo extends MongoRepository<Route, Integer>{

	Route findRouteByTruckId(int truckId);
}
