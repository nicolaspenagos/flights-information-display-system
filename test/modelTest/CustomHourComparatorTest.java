package modelTest;
import model.CustomDate;
import model.CustomHour;
import model.CustomHourComparator;
import model.Flight;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomHourComparatorTest {
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	public void setUpScenary1() {
		
	}
	
	//-------------------------------------
	// Test
	//-------------------------------------
	@Test 
	void CustomDateComparatorTest() {
		setUpScenary1();
		CustomHourComparator cHcT = new CustomHourComparator();
		assertNotNull("The constructor is not working propertly", cHcT);
	}
	
	@Test
	void testCompare() {
		
		Flight f1 = new Flight(new CustomDate(), new CustomHour(20, 3, CustomHour.AM), "Copa Airlines", "Houston", "AM3729", 3);
		Flight f2 = new Flight(new CustomDate(), new CustomHour(20, 3, CustomHour.PM), "Copa Airlines", "Houston", "AM3729", 3);
		Flight f3 =  new Flight(new CustomDate(), new CustomHour(21, 3, CustomHour.AM), "Copa Airlines", "Houston", "AM3729", 3);
		Flight f4 = new Flight(new CustomDate(), new CustomHour(20, 4, CustomHour.AM), "Copa Airlines", "Houston", "AM3729", 3);

		
		CustomHourComparator cDc = new CustomHourComparator();
		assertTrue("The compare method is not working propertly", cDc.compare(f1, f2)<0);
		assertTrue("The compare method is not working propertly", cDc.compare(f1, f3)<0);
		assertTrue("The compare method is not working propertly", cDc.compare(f3, f1)>0);
		assertTrue("The compare method is not working propertly", cDc.compare(f3, f1)>0);
		assertTrue("The compare method is not working propertly", cDc.compare(f4, f3)>0);
		assertTrue("The compare method is not working propertly", cDc.compare(f1, f1)==0);
		
		
	}

}

