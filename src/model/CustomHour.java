package model;

public class CustomHour {
	
	public final static String AM = "AM";
	public final static String PM = "PM";
	
	private int minutes;
	private int hour;
	private String format;
	
	public CustomHour() {
		minutes = ((int) (Math.random() * 49)+10);
		hour = ((int) (Math.random() * 12) + 1);
		format = (Math.random()<0.50)?this.AM:this.PM; 
	}
	
	public CustomHour(int m, int h, String f) {
		minutes = m;
		hour = h;
		format = f;
	}
	
	public String getFormat() {
		return format; 
	}
	
	public int getHour() {
		return hour; 
	}
	
	public int getMinutes() {
		return minutes;
	}
	public String toString() {
		String msg = hour+":"+minutes+" "+format; 
	
		return msg;	
	}
}
