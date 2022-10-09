package com.transporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transporation.entity.Route;
import com.transporation.service.RouteService;

@RestController
@RequestMapping("/api/v1/transportation")
public class RouteController {

	@Autowired
	RouteService service;
	
	@PostMapping
	public ResponseEntity<Route> post(@RequestBody Route route){
		return new ResponseEntity<>(service.post(route), HttpStatus.CREATED);
	};
	
	@GetMapping
	public ResponseEntity<Route> findRouteByTruckId(@RequestParam int truckId){
		return new ResponseEntity<>(service.findRouteByTruckId(truckId), HttpStatus.OK);
	}
}
