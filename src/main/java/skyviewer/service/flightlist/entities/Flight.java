package skyviewer.service.flightlist.entities;


import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity

public class Flight {
	
	@Id
	@GeneratedValue
	Long Id;
	@Column
	String origin;
	@Column
	String destination;
	@Column
	LocalDate date;
	@Column
	LocalTime departureTime;
	@Column
	LocalTime travelDuration;//LocalTime arrivalTime;
	@Column
	Integer layovers;
	@Column
	Boolean allowsBaggage;
	@Column
	Float price;
	@Column
	Boolean roundTrip;
	
	public Flight()
	{
		
	}

	public Flight(Long id, String origin, String destination, LocalDate date, LocalTime departureTime,
			LocalTime travelDuration, Integer layovers, Boolean allowsBaggage, Float price, Boolean roundTrip) {
		super();
		this.Id = id;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.departureTime = departureTime;
		this.travelDuration = travelDuration;
		this.layovers = layovers;
		this.allowsBaggage = allowsBaggage;
		this.price = price;
		this.roundTrip = roundTrip;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(LocalTime travelDuration) {
		this.travelDuration = travelDuration;
	}

	public Integer getLayovers() {
		return layovers;
	}

	public void setLayovers(Integer layovers) {
		this.layovers = layovers;
	}

	public Boolean getAllowsBaggage() {
		return allowsBaggage;
	}

	public void setAllowsBaggage(Boolean allowsBaggage) {
		this.allowsBaggage = allowsBaggage;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(Boolean roundTrip) {
		this.roundTrip = roundTrip;
	}

	@Override
	public String toString() {
		return "Flight [id=" + Id + ", origin=" + origin + ", destination=" + destination + ", date=" + date
				+ ", departureTime=" + departureTime + ", travelDuration=" + travelDuration + ", layovers=" + layovers
				+ ", allowsBaggage=" + allowsBaggage + ", price=" + price + ", roundTrip=" + roundTrip + "]";
	}
	
	
}
