package com.transporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transporation.document.Route;
import com.transporation.service.RouteService;

@RestController
@RequestMapping("/api/v1/transportation")
public class RouteController {

	@Autowired
	RouteService service;

	@PostMapping
	public ResponseEntity<Route> post(@RequestBody Route route) {
		return new ResponseEntity<>(service.post(route), HttpStatus.CREATED);
	};

	@GetMapping
	public ResponseEntity<Route> findRouteByTruckId(@RequestParam int truckId) {
		return new ResponseEntity<>(service.findRouteByTruckId(truckId), HttpStatus.OK);
	}
}
