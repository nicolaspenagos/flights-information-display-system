package model;

import java.util.Comparator;

public class DestineComparator implements Comparator <Flight>{
	
	public DestineComparator() {
		
	}

	@Override
	public int compare(Flight flight1, Flight flight2) {
		
		int comparator;
		String destine1 = flight1.getDestinationCity();
		String destine2 = flight2.getDestinationCity();
		
		if(destine1.compareTo(destine2)>0) {
			comparator = 1;
		}else if(destine1.compareTo(destine2)<0) {
			comparator = -1;
		}else {
			comparator = 0;
		}
		return comparator;
	}
	

}
