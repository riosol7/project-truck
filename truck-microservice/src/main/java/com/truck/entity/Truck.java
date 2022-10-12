package com.truck.entity;

import javax.persistence.*;

import com.truck.enums.Type;

@Entity
@Table(name = "truck")
public class Truck {

	@Id
	@Column(name = "truck_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	String make;
	String model;

	@Column(name = "yr")
	int year;
	String weight;
	String volume;
	int mpg;
	String space;

	@Column(columnDefinition = "ENUM('GAS', 'HYBRID', 'ELECTRIC')")
	@Enumerated(EnumType.STRING)
	Type type;

	public void truckEntity() {
	}

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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public int getMpg() {
		return mpg;
	}

	public void setMpg(int mpg) {
		this.mpg = mpg;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", weight=" + weight
				+ ", volume=" + volume + ", mpg=" + mpg + ", space=" + space + "]";
	};

}
