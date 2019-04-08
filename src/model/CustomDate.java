package model;

public class CustomDate {
	
	private int year;
	private int month;
	private int day;
	
	public CustomDate() {
		year = ((int) (Math.random() * 3) + 1)+2017;
		month = ((int) (Math.random() * 12) + 1);
		day = ((int) (Math.random() * 30) + 1);
		
	}
	
	public String toString() {
		return year+"/"+month+"/"+day;	
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
}
