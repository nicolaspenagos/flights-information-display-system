package model;

import javafx.beans.property.StringProperty;

public class Flight implements Comparable<Flight>{
	
	//------------------------------
	// Attributes
	//------------------------------
	private CustomDate customDate;
	private CustomHour hour;
	private String airline;
	private String flightNumber;
	private String destinationCity;
	private int gate;
	
	//------------------------------
	// Constructor 
	//------------------------------
	
	public Flight(CustomDate customDate, CustomHour hour, String airline, String destinationCity, String flightNumber, int gate) {
		this.customDate      = customDate;
		this.hour            = hour;
		this.airline         = airline;
		this.destinationCity = destinationCity;
		this.flightNumber    = flightNumber;
		this.gate            = gate; 
	}
	
	
	//------------------------------
	// Getters and Setters 
	//------------------------------
	public CustomDate getDate() {
		return customDate;
	}
	public void setDate(CustomDate date) {
		this.customDate = date;
	}
	public CustomHour getHour() {
		return hour;
	}
	public void setHour(CustomHour hour) {
		this.hour = hour;
	}
    public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public int getGate() {
		return gate;
	}
	public void setGate(int gate) {
		this.gate = gate;
	}
	
	public String toString() {
		return hour+" | "+airline +" | "+ flightNumber +" | "+ destinationCity+" | " +gate+" | "+customDate; 
				
		
	}

	
	@Override
	public int compareTo(Flight otherFlight) {
		int comparation;
		if(customDate.getYear()>otherFlight.getDate().getYear()) {
			comparation = 1;
		}else if(customDate.getYear()<otherFlight.getDate().getYear()) {
			comparation = -1;
		}else if(customDate.getMonth()>otherFlight.getDate().getMonth()) {
			comparation = 1;
		}else if(customDate.getMonth()<otherFlight.getDate().getMonth()) {
			comparation = -1;
		}else if(customDate.getDay()>otherFlight.getDate().getDay()) {
			comparation = 1;
		}else if(customDate.getDay()<otherFlight.getDate().getDay()) {
			comparation = -1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
}
