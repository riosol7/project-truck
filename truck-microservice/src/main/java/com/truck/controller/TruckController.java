package com.truck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truck.entity.Truck;
import com.truck.service.TruckService;

@RestController
@RequestMapping("/api/v1/truck")
public class TruckController {

	@Autowired
	TruckService service;
	
	@PostMapping
	public ResponseEntity<Truck> post(@RequestBody Truck truck){
		return new ResponseEntity<>(service.post(truck), HttpStatus.CREATED);
	};
	
	@GetMapping
	public ResponseEntity <List<Truck>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<Truck> findById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	};
	
	@GetMapping("/make/{value}")
	public ResponseEntity<List<Truck>> findByMake(@PathVariable("value") String make) {
		return new ResponseEntity<>(service.findByMake(make), HttpStatus.OK);
	};
	
	@GetMapping("/model/{value}")
	public ResponseEntity<List<Truck>> findByModel(@PathVariable("value") String model) {
		return new ResponseEntity<>(service.findByModel(model), HttpStatus.OK);
	};
	
	@GetMapping("/year/{value}")
	public ResponseEntity<List<Truck>> findByModel(@PathVariable("value") int year) {
		return new ResponseEntity<>(service.findByYear(year), HttpStatus.OK);
	};
	
	
}
