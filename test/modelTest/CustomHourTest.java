package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CustomDate;
import model.CustomHour;

class CustomHourTest {
	
	//-------------------------------------
	// Associations
	//-------------------------------------
	private CustomHour cH1;
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	
	public void setUpScenary1() {
		
	}
	
	public void setUpScenary2() {
		cH1 = new CustomHour(30, 5, CustomHour.AM);
	}
	
	//-------------------------------------
	// Test
	//-------------------------------------
		
	@Test
	void customHourTest() {
		CustomHour ch = new CustomHour();
		assertNotNull("The custom hour have not been created", ch);
	}
	
	@Test
	void gettersTest() {
		setUpScenary2();
		assertTrue("The getters for minutes is not working propertly", cH1.getMinutes()==30);
		assertTrue("The getters for hours is not working propertly", cH1.getHour()== 5);
		assertTrue("The getters for format is not working propertly", cH1.getFormat( )== CustomHour.AM);
	}
	
	@Test
	void toStringTest() {
		setUpScenary2();
		assertTrue("The toString method is not working propertly", cH1.toString().equals("5:30 AM"));
	}
	
	


}
