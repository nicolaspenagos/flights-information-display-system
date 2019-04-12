package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CustomDate;
import model.CustomHour;
import model.Flight;

class FlightTest {
	
	private Flight f1;
	private Flight f2;
	private String fToS = "";
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	public void setUpScenary1() {
		
	}
	
	public void SetUpScenary2() {
		CustomDate cd = new CustomDate();
		CustomHour ch = new CustomHour();
		f1 = new Flight (cd, ch, "AVIANCAa", "NEW YORKk", "AF45", 0); 
		fToS= ch+" | "+"AVIANCAa"+" | "+ "AF45" +" | "+ "NEW YORKk"+" | " +0+" | "+cd;
	}
	
	public void setUpSceneary3() {
		CustomDate ncd = new CustomDate(1998, 10, 10);
		CustomHour ch = new CustomHour();
		f2 =  new Flight (ncd, ch, "LATAM", "PARIS", "AF4500", 12); 
	}
	
	//-------------------------------------
	// Test
	//-------------------------------------
	@Test
	void FlightGettersSettersTest() {
		setUpScenary1();
		CustomDate cd = new CustomDate();
		CustomHour ch = new CustomHour();
		String ax = "Avianca";
		String dx = "Beijing";
		String fn = "AAA001";
		int gx = 20;
		
		Flight fx = new Flight(cd, ch, ax, dx, fn, gx); 
		
		assertNotNull("The flight was not create", fx);
		assertTrue("The date was not assigned correctly", cd.equals(fx.getDate()));
		assertTrue("The hour was not assigned correctly", ch.equals(fx.getHour()));
		assertTrue("The airline was not assigned correctly", ax.equals(fx.getAirline()));
		assertTrue("The destination was not assigned correctly", dx.equals(fx.getDestinationCity()));
		assertTrue("The flight number was not assigned correctly", fn.equals(fx.getFlightNumber()));
		assertTrue("The gate was not assigned correctly", gx == fx.getGate());
		
		cd = new CustomDate();
		ch = new CustomHour();
		ax = "LATAM";
		dx = "Panama";
		fn = "AAA000";
		gx = 21;
		
		fx.setAirline(ax);
		fx.setDestinationCity(dx);
		fx.setFlightNumber(fn);
		fx.setGate(21);
		fx.setDate(cd);
		fx.setHour(ch);
		
		assertNotNull("The flight was not create", fx);
		assertTrue("The date was not assigned correctly", cd.equals(fx.getDate()));
		assertTrue("The hour was not assigned correctly", ch.equals(fx.getHour()));
		assertTrue("The airline was not assigned correctly", ax.equals(fx.getAirline()));
		assertTrue("The destination was not assigned correctly", dx.equals(fx.getDestinationCity()));
		assertTrue("The flight number was not assigned correctly", fn.equals(fx.getFlightNumber()));
		assertTrue("The gate was not assigned correctly", gx == fx.getGate());
	}
	
	@Test 
	void toStringTest() {
		SetUpScenary2();
		assertTrue("To string method is not working correctly", f1.toString().equals(fToS));
	}
	
	@Test
	void CompareToTest() {
		SetUpScenary2();
		setUpSceneary3();
		System.out.println(f1.compareTo(f2));
		assertTrue("To string method is not working correctly", f1.compareTo(f2)>0); 
		assertTrue("To string method is not working correctly", f2.compareTo(f1)<0); 
	}

	
	
	
}
