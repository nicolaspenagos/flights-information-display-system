package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import customsExceptions.NoSortedElementsBinarySearchException;
import model.Airport;
import model.CustomDate;
import model.CustomHour;
import model.Flight;

class AirportTest {
	
	private Airport a1;
	private Flight f1;

	//-------------------------------------
	// Scenarios
	//-------------------------------------
	
	public void SetUpScenary1() {
	
	}
	
	public void SetUpScenary2() {
		try {
			a1 = new Airport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SetUpScenary3() {
		f1 = new Flight (new CustomDate(),new CustomHour(), "AVIANCAa", "NEW YORKk", "AF45", 0); 
	}
	
	//-------------------------------------
	// Test
	//-------------------------------------
	
	@Test 
	void AirportTest() {
		SetUpScenary1();
	
		String[] airlines = {"Avianca", "American Airlines", "EasyFly", "LATAM", "Satena", "Viva Air", "Wingo", "Areolíneas Argentinas", "Aereoméxico", "Air Canada", "Air Europa", "Air France", "Volaris", "Viva Colombia", "Iberia", "JetBlue", "KLM", "Lufthansa", "Spirit", "United Airlines"};
		
		String[] destines = {"BEIJING", "NEW YORK", "LIMA", "CHICAGO", "ROMA","DUBAI", "HOUSTON", "BUENOS AIRES", "MADRID", "LONDRES", "PARIS", "MOSCU", "SINGAPUR", "TORONTO", "BRUSELAS"};
		
		String[] ids = {"AV", "AA", "EF", "LA", "SA", "VA", "WI", "AG", "AM", "AC", "AE", "AF", "VO", "VC", "IB", "JB","KL","LF", "SP", "UA"};
	
		try {
			a1 = new Airport();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			assertTrue("The ", a1.getStringHour().equals(dateFormat.format(date)));
			assertNotNull("The new Airport object is null", a1);
			for (int i = 0; i < 20; i++) {
				assertTrue("The airlines were not succesfully loaded", airlines[i].equals(a1.getAirlines()[i]));
				if(i<15) {
					assertTrue("The destines were not succesfully loaded", destines[i].equals(a1.getDestines()[i]));
				}
				assertTrue("The airlinesId were not succesfully loaded", ids[i].equals(a1.getAirlinesId()[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void gettersAndSettersTest() {
		SetUpScenary2();
		CustomDate datex = new CustomDate();
		String test = "x";	
		a1.setStringHour(test);
		a1.setTimeSearching(test);
		assertTrue("The hour is no working correctly", a1.getStringHour().equals(test));	
		assertTrue("The hour is no working correctly", a1.getTimeSearching().equals(test));	
	}
	
	@Test
	void UpdateTimeTest() {
		SetUpScenary2();
		a1.updateCurrentTime();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		assertTrue("The date is not updating correctly", a1.getStringHour().equals(dateFormat.format(date)));
	}
	
	@Test
	void generateFlightsTest() {
		SetUpScenary2();
		Flight[] array = a1.generateFlights(20);
		assertTrue("The flights array were not generate", array instanceof Flight[]);
		
		for(int i=0; i<array.length-1; i++) {
			assertTrue("The flights are not different", !(array[i].getFlightNumber().equals(array[i+1].getFlightNumber())));
		}
	}
	
	@Test 
	void isUnicTest() {
		SetUpScenary2(); 
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		a1.setUS(ints);
		assertTrue("The number is have been already used", !(a1.isUnic(1)));
		assertTrue("The number is have been not used", (a1.isUnic(6)));
	}
	
	@Test
	void sortByFullHourTest() {
		SetUpScenary2(); 
		Flight[] array = a1.getFlights();
		a1.sortByFullHour();
		for (int i = 0; i < array.length-1; i++) {
			if(array[i].getHour().toString().charAt(6)=='A'&&array[i+1].getHour().toString().charAt(6)=='A') {
				assertTrue("The array is not oerdered", array[i].getHour().toString().compareTo(array[i+1].getHour().toString())<=0);	
			}else if(array[i].getHour().toString().charAt(6)=='P'&&array[i+1].getHour().toString().charAt(6)=='P'){
				assertTrue("The array is not oerdered", array[i].getHour().toString().compareTo(array[i+1].getHour().toString())<=0);
			}
		}
	}
	
	@Test
	void sortByGateBubbleTest() {
		SetUpScenary2(); 
		Flight[] array = a1.getFlights();
		a1.sortByGateBubble();
		for (int i = 0; i < array.length-1; i++) {
			assertTrue("The array is not oerdered",array[i].getGate()<=array[i+1].getGate());
		}
	}
	
	@Test
	void sortByDateComparable() {
		SetUpScenary2(); 
		Flight[] array = a1.getFlights();
		a1.sortByDateComparable();
		for (int i = 0; i < array.length-1; i++) {
		
				assertTrue("The array is not oerdered", array[i].getDate().toString().compareTo(array[i+1].getDate().toString())<=0||array[i].getDate().toString().compareTo(array[i+1].getDate().toString())>0);	
		}
	}
	
	@Test
	void sortByAirlineSelectionTest() {
		SetUpScenary2(); 
		Flight[] array = a1.getFlights();
		a1.sortByAirlineSelection();
		for (int i = 0; i < array.length-1; i++) {
			assertTrue("The array is not oerdered", array[i].getAirline().compareTo(array[i+1].getAirline())<=0);	
		}
	}
	
	@Test
	void sortByDestineComparatorTest() {
		SetUpScenary2(); 
		Flight[] array = a1.getFlights();
		a1.sortByDestineComparator();
		for (int i = 0; i < array.length-1; i++) {
			assertTrue("The array is not oerdered", array[i].getDestinationCity().compareTo(array[i+1].getDestinationCity())<=0);	
		}
	}
	
	@Test
	void sortByFlightNumberInsertionTest() {
		SetUpScenary2(); 
		Flight[] array = a1.getFlights();
		a1.sortByFlightNumberInsertion();
		for (int i = 0; i < array.length-1; i++) {
			assertTrue("The array is not oerdered", array[i].getFlightNumber().compareTo(array[i+1].getFlightNumber())<=0);	
		}
	}
	
	@Test
	void calculateTime1Test() {
		SetUpScenary2(); 
		long x = System.currentTimeMillis();
		long y = x+100;
		a1.calculateTime(x, y);
		assertTrue("The time is not good", a1.getTimeO().equals((y-x)+" ms"));
	}
	
	@Test
	void calculateTime2Test() {
		SetUpScenary2(); 
		long x = System.currentTimeMillis();
		long y = x+100;
		a1.calculateTime2(x, y, "Linear");
		assertTrue("The time is not good", a1.getTimeSearching().equals("Linear "+(y-x)+" ms"));
	}
	
	@Test 
	void printFTest() {
		SetUpScenary3(); 
		SetUpScenary2();
		Flight f2 = null;

		assertTrue("The method is not working correctly", a1.printF(f1).equals(f1.toString()));
		assertTrue("The method is not working correctly", a1.printF(f2).equals("This flight does not exist"));
	}
	
	@Test
	void linearSTests() {
		SetUpScenary2();
		SetUpScenary3();
		a1.getFlights()[0]=f1;
	
		assertTrue("The method is not working correctly", a1.searchAirlineLinearS("AVIANCAa").equals(f1.toString()));
		assertTrue("The method is not working correctly", a1.searchByTimeLinearS(f1.getHour().toString()).equals(f1.toString()));
		assertTrue("The method is not working correctly", a1.searchDateLinearS(f1.getDate().toString()).equals(f1.toString()));
		assertTrue("The method is not working correctly", a1.searchDestineLinearS("NEW YORKk").equals(f1.toString()));
		assertTrue("The method is not working correctly", a1.searchFlightLinearS("AF45").equals(f1.toString()));
		
	}
	
	@Test
	void binarySearchTest() {
		SetUpScenary2();
		SetUpScenary3();
		a1.getFlights()[0]=f1;
		a1.sortByGateBubble();
		try {
			assertTrue("The method is not working correctly", a1.searchByGateBinaryS(0).equals(f1.toString()));
		} catch (NoSortedElementsBinarySearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
