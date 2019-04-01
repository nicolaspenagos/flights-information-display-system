package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Airport {
	
	//------------------------------
	// Attributes
	//------------------------------
	private ArrayList<Flight> flights;
	private String stringHour;

	
	//------------------------------
	// Constructor 
	//------------------------------
	public Airport() {
		flights = new ArrayList<>(); 
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		stringHour = dateFormat.format(date);
	}
	
	//------------------------------
	// Getters and Setters 
	//------------------------------
	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	public String getStringHour() {
		return stringHour;
	}

	public void setStringHour(String stringHour) {
		this.stringHour = stringHour;
	}
	
	//------------------------------
	// Methods
	//------------------------------
	public void updateCurrentTime() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		stringHour = dateFormat.format(date);
	}
}
