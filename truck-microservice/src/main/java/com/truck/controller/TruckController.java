package com.truck.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.truck.entity.Truck;
import com.truck.model.TruckTransportation;
import com.truck.service.TruckService;

@RestController
@RequestMapping("/api/v1/truck")
public class TruckController {

	@Autowired
	TruckService service;

	@PostMapping
	public ResponseEntity<Truck> post(@RequestBody Truck truck) {
		return new ResponseEntity<>(service.post(truck), HttpStatus.CREATED);
	};

	@GetMapping
	public ResponseEntity<List<Truck>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	};

	@GetMapping("/{id}")
	public ResponseEntity<TruckTransportation> findById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	};

	@GetMapping("/search")
	public ResponseEntity<List<Truck>> findByMakeAndModel(@RequestParam Map<String,String> requestParams) {
		return new ResponseEntity<>(service.findByMakeAndModel(requestParams.get("make"), requestParams.get("model")), HttpStatus.OK);
	};
	
//	@GetMapping("/make/{value}")
//	public ResponseEntity<List<Truck>> findByMake(@PathVariable("value") String make) {
//		return new ResponseEntity<>(service.findByMake(make), HttpStatus.OK);
//	};
//
//	@GetMapping("/model/{value}")
//	public ResponseEntity<List<Truck>> findByModel(@PathVariable("value") String model) {
//		return new ResponseEntity<>(service.findByModel(model), HttpStatus.OK);
//	};
//
//	@GetMapping("/year/{value}")
//	public ResponseEntity<List<Truck>> findByModel(@PathVariable("value") int year) {
//		return new ResponseEntity<>(service.findByYear(year), HttpStatus.OK);
//	};

	@PutMapping
	public ResponseEntity<Truck> put(@RequestBody Truck truck) {
		return new ResponseEntity<>(service.put(truck), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	};

}
