package modelTest;
import model.CustomDate;
import model.CustomHour;
import model.DestineComparator;
import model.Flight;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DestineComparatortest {
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	public void setUpScenary1() {
		
	}

	//-------------------------------------
	// Test
	//-------------------------------------
	
	@Test
	void DestineComparatorTest() {
		setUpScenary1();
		DestineComparator dC = new DestineComparator();
	}
	
	@Test
	void CompareTest() {
		setUpScenary1();
		DestineComparator dC = new DestineComparator();
		Flight f1 = new Flight(new CustomDate(), new CustomHour(20, 3, CustomHour.AM), "Copa Airlines", "Houston", "AM3729", 3);
		Flight f2 = new Flight(new CustomDate(), new CustomHour(20, 3, CustomHour.AM), "Copa Airlines", "Houston", "AM3729", 3);
		Flight f3 = new Flight(new CustomDate(), new CustomHour(20, 3, CustomHour.PM), "Copa Airlines", "New york", "AM3729", 3);
		assertTrue("The comparator is not working porpertly", dC.compare(f1, f3)<0 );
		assertTrue("The comparator is not working porpertly", dC.compare(f1, f1)==0 );
		assertTrue("The comparator is not working porpertly", dC.compare(f3, f1)>0);
	}
}

