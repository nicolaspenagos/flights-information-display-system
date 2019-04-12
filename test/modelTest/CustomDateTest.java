package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CustomDate;

class CustomDateTest {
	
	//-------------------------------------
	// Associations
	//-------------------------------------
	
	private CustomDate d1;
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	
	public void setUpScenary1() {
		int y = 1998;
		int m = 10;
		int d = 20;
		d1 = new CustomDate(y, m, d);
	}
	public void setUpScenary2() {
		int y = 1998;
		int m = 10;
		int d = 20;
		CustomDate d1 = new CustomDate(1998,10,20);
	}
	
	//-------------------------------------
	// Test
	//-------------------------------------
	
	@Test 
	void customDateTest() {
		CustomDate cd = new CustomDate();
		assertNotNull("The custom date have not been created", cd);
	}
	
	@Test
	void gettersAndSettertsTest() {
		setUpScenary1();
		assertTrue("The day getter is not working propertly", d1.getDay() == 20);
		assertTrue("The month getter is not working propertly", d1.getMonth() == 10);
		assertTrue("The year getter is not working propertly", d1.getYear() == 1998);
	}
	
	@Test
	void toStringTest() {
		setUpScenary1();
		assertTrue("The toString method is not working propertly", d1.toString().equals("1998/10/20"));
	}

}
