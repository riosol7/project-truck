package com.truck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck {
	
	@Id
	@Column(name = "truck_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	String make;
	String model;
	int year;
	
	public void truckEntity() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + "]";
	};
	
}
