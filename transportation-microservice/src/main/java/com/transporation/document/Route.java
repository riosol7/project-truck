package com.transporation.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Route")
public class Route {

	@Id
	String routeId;

	int truckId;
	Date startDate;
	Date endDate;
	String startingPoint;
	String destination;
	Boolean completed;

	public void RouteEntity() {
	}

	public String getRouteId() {
		return routeId;
	};

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	};

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", truckId=" + truckId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", startingPoint=" + startingPoint + ", destination=" + destination + ", completed="
				+ completed + "]";
	};

}
