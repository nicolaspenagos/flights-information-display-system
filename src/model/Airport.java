package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Airport {
	
	public final static String HC = "HOUR - COMPARATOR"; 
	public final static String DC = "DESTINE - COMPARATOR";
	public final static String DCO ="DATE - COMPARABLE";
	public final static String FNI = "F. NUMBER. - INSERTION";
	public final static String GB = "GATE - BUBBLE";
	public final static String AS = "AIRLINE - SELECTION";
	
	//------------------------------
	// Attributes
	//------------------------------
	private Flight[] flights;
	private ArrayList<Integer> usedNumbers;
	private String stringHour;
	private String[] airlines;
	private String[] destines;
	private String[] airlinesId;
	private String typeOfOrder;
	private String timeOrdering;
	
	//------------------------------
	// Constructor 
	//------------------------------
	public Airport() throws IOException {
		usedNumbers = new ArrayList<>(); 
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		stringHour = dateFormat.format(date);
		airlines = loadTextFileToArray("data/airlines.txt");
		destines = loadTextFileToArray("data/destines.txt");
		airlinesId = loadTextFileToArray("data/airlinesId.txt");
		generateFlights(20);
		typeOfOrder = "";
		timeOrdering = "";
	}
	
	//------------------------------
	// Getters and Setters 
	//------------------------------
	public Flight[] getFlights() {
		return flights;
	}

	public void setFlights(Flight[] flights) {
		this.flights = flights;
	}

	public String getStringHour() {
		return stringHour;
	}

	public void setStringHour(String stringHour) {
		this.stringHour = stringHour;
	}
	
	public String getTypeO() {
		return typeOfOrder; 
	}
	
	public String getTimeO() {
		return timeOrdering; 
	}
	//------------------------------
	// Methods
	//------------------------------
	public void updateCurrentTime() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		stringHour = dateFormat.format(date);
	}
	public String[] loadTextFileToArray(String path) throws IOException {
		
		ArrayList<String> list = new ArrayList<>();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
	
		
		String line = br.readLine(); 
		while(line != null) {
			line = br.readLine();
			list.add(line);
		}
		
		String[] array = new String[list.size()]; 
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}
	
	public Flight[] generateFlights(int size) {
	
		flights = new Flight[size];
		
		for (int i = 0; i < flights.length; i++) {
			
			boolean finish = false;
			
			int a = (int) (Math.random() * 19);
			int d = (int) (Math.random() * 14);
			int id = (int) (Math.random() * 9999);;
			int g = (int) (Math.random() * 35)+1;
			while(!finish) {
				if(isUnic(id)) {
					finish=true;
				}else {
					id = (int) (Math.random() * 9999);
				}
			}
			
		
			Flight fx = new Flight(new CustomDate(), new CustomHour(), airlines[a], destines[d], (airlinesId[a]+ id), g);
			flights[i]=fx; 
			
		}
		return null;
		
	}
	
	public boolean isUnic(int x) {
		for (int i = 0; i < usedNumbers.size(); i++) {
			if(x==usedNumbers.get(i)) {
				return false;
			}
		}
		return true; 
	}
	//Comparae to
	public void sortByFullHour() {
		typeOfOrder = HC;
		long xTime = System.currentTimeMillis();
		Arrays.sort(flights,new CustomHourComparator());
		long yTime = System.currentTimeMillis();
		calculateTime(xTime, yTime);
	}
	
	public void sortByGateBubble() {
		typeOfOrder = GB;
		long timeX = System.currentTimeMillis();
		for (int i = flights.length; i>0 ; i--) {
			for (int j = 0; j < i-1; j++) {
				if(flights[j].getGate()>flights[j+1].getGate()) {
					Flight temp = flights[j+1]; 
					flights[j+1]=flights[j];
					flights[j]= temp;
				}
			}
		}
		long timeY = System.currentTimeMillis();
		calculateTime(timeX, timeY);
	}
	
	public void sortByDateComparable() {
		typeOfOrder = DCO;
		long timeX = System.currentTimeMillis();
		Arrays.sort(flights);
		long timeY = System.currentTimeMillis();
		calculateTime(timeX, timeY);
	}
	
	
	public void calculateTime(long x, long y) {
		long timeT = y-x;
		timeOrdering = timeT + " ms";
	}
	
	public void sortByAirlineSelection() {
		typeOfOrder = AS;
		long timeX=System.currentTimeMillis();
		for (int i = 0; i<flights.length; i++) {
			int pos=i;
			String minS= flights[i].getAirline();
			Flight min = flights[i];
			for (int j = i; j < airlines.length; j++) {
				if(minS.compareToIgnoreCase(flights[j].getAirline())>0) {
					min=flights[j];
					minS= flights[j].getAirline();
					pos = j;
				}
			}
			Flight temp = flights[i];
			flights[i]  = min;
			flights[pos]=temp;
		}
		long timeY=System.currentTimeMillis();
		calculateTime(timeX, timeY);
	}
	
	public void sortByDestineComparator() {
		typeOfOrder = DC; 
		long timeX = System.currentTimeMillis();
		Arrays.sort(flights,new DestineComparator());
		long timeY = System.currentTimeMillis();
		calculateTime(timeX, timeY);
	}
	
	public void sortByFlightNumberInsertion() {
		typeOfOrder = FNI; 
		long timeX = System.currentTimeMillis();
		for (int i = 1; i < flights.length; i++) {
			Flight aux = flights[i];
			int j;
			for (j=i-1; j >=0 && flights[j].getFlightNumber().compareTo(aux.getFlightNumber())>0; j--) {
				flights[j+1] = flights[j];
			}
			flights[j+1] = aux;
		 }
		long timeY = System.currentTimeMillis();
		calculateTime(timeX, timeY);	
	}
}

