package model;

public class Flight {
	
	//------------------------------
	// Attributes
	//------------------------------
	private String date;
	private String hour;
	private String airline;
	private int flightNumber;
	private String destinationCity;
	private String gate;
	
	//------------------------------
	// Constructor 
	//------------------------------
	public Flight(String date, String hour, String airline, int flightNumber, String gate) {
		this.date         = date;
		this.hour         = hour;
		this.airline      = airline;
		this.flightNumber = flightNumber;
		this.gate         = gate; 
	}
	
	
	//------------------------------
	// Getters and Setters 
	//------------------------------
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	
	
}
