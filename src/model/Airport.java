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

import customsExceptions.NoSortedElementsBinarySearchException;

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
	private String timeSearching;
	
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
		timeSearching = "";
	}
	
	//------------------------------
	// Getters and Setters 
	//------------------------------
	public Flight[] getFlights() {
		return flights;
	}
	
	public String[] getDestines() {
		return destines;
	}
	
	public String[] getAirlinesId() {
		return airlinesId;
	}
	
	public String[] getAirlines() {
		return airlines;
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
	
	public void setUS(ArrayList<Integer> x) {
		usedNumbers = x;
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
			list.add(line);
			line = br.readLine();
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
		return flights;
		
	}
	
	public boolean isUnic(int x) {
		for (int i = 0; i < usedNumbers.size(); i++) {
			if(x==usedNumbers.get(i)) {
				return false;
			}
		}
		return true; 
	}
	
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
	
	public void calculateTime2(long x, long y, String xx) {
		long timeT = y-x;
		setTimeSearching(xx+" "+timeT + " ms");
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
	
	public String searchByTimeLinearS(String time) {
		long timeX = System.currentTimeMillis();
		Flight fx = null; 
		for (int i = 0; i < flights.length; i++) {
			if(time.equalsIgnoreCase(flights[i].getHour().toString())) {
				fx = flights[i];
			}
		}
		long timeY = System.currentTimeMillis();
		calculateTime2(timeX, timeY, "(linear)");
		return printF(fx);
	}
	
	public String searchFlightLinearS(String fn) {
		Flight fx = null; 
		long timeX = System.currentTimeMillis();
		for (int i = 0; i < flights.length; i++) {
			if(fn.equalsIgnoreCase(flights[i].getFlightNumber())) {
				fx = flights[i];
			}
		}
		long timeY = System.currentTimeMillis();
		calculateTime2(timeX, timeY, "(linear)");
		return printF(fx);
	}
	
	public String searchDateLinearS(String fn) {
		Flight fx = null; 
		long timeX = System.currentTimeMillis();
		for (int i = 0; i < flights.length; i++) {
			if(fn.equalsIgnoreCase(flights[i].getDate().toString())) {
				fx = flights[i];
			}
		}
		long timeY = System.currentTimeMillis();
		calculateTime2(timeX, timeY, "(linear)");
		return printF(fx);
	}
	public String searchAirlineLinearS(String fn) {
		Flight fx = null; 
		long timeX = System.currentTimeMillis();
		for (int i = 0; i < flights.length; i++) {
			if(fn.equalsIgnoreCase(flights[i].getAirline())) {
				fx = flights[i];
			}
		}
		long timeY = System.currentTimeMillis();
		calculateTime2(timeX, timeY, "(linear)");
		return printF(fx);
	}
	
	public String searchDestineLinearS(String fn) {
		Flight fx = null; 
		long timeX = System.currentTimeMillis();
		for (int i = 0; i < flights.length; i++) {
			if(fn.equalsIgnoreCase(flights[i].getDestinationCity())) {
				fx = flights[i];
			}
		}
		long timeY = System.currentTimeMillis();
		calculateTime2(timeX, timeY, "(linear)");
		return printF(fx);
	}
	
	public String searchByGateBinaryS(int x) throws NoSortedElementsBinarySearchException{
			if(typeOfOrder.contentEquals(GB)) {
				Flight fx = null;
				long timeX = System.currentTimeMillis();
				
				int low = 0;
				int high = flights.length-1;
				boolean founded = false;
				
				while(low <= high&&!founded) {
					int mid = (low + high)/2;
					if(flights[mid].getGate()<x) {
						low = mid +1;
					}else if(flights[mid].getGate()>x) {
						high = mid -1;
					}else {
						fx = flights[mid];
						founded = true;  
					}
				}	
				long timeY = System.currentTimeMillis();
				calculateTime2(timeX, timeY, "(Binary)");
				return printF(fx); 
			}else {
				throw new NoSortedElementsBinarySearchException();
			}
	}
	
	
	
	public String printF(Flight fx) {
		String msg = "This flight does not exist";
		if(fx!=null) {
			msg = fx.toString();
		}
		
		return msg;
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
	
	

	public String getTimeSearching() {
		return timeSearching;
	}

	public void setTimeSearching(String timeSearching) {
		this.timeSearching = timeSearching;
	}
}

