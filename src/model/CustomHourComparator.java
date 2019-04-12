package model;

import java.util.Comparator;

public class CustomHourComparator implements Comparator<Flight>{
	
	public CustomHourComparator() {
		
	}

	@Override
	public int compare(Flight f1, Flight f2) {
		
		int comparator;
		
		String format1 = f1.getHour().getFormat();
		String format2 = f2.getHour().getFormat();
		
		int hour1 = f1.getHour().getHour();
		int hour2 = f2.getHour().getHour();
		
		int minutes1 = f1.getHour().getMinutes();
		int minutes2 = f2.getHour().getMinutes();
		
		if(format1.compareTo(format2)>0) {
			comparator = 1;
		}else if(format1.compareTo(format2)<0){
			comparator = -1;
		}else {
			if(hour1>hour2) {
				comparator = 1;
			}else if(hour1<hour2) {
				comparator = -1;
			}else{
				if(minutes1>minutes2) {
					comparator = 1;
				}else if(minutes1<minutes2) {
					comparator = -1;
				}else {
					comparator = 0;
				}
			}
		}
		
		return comparator;
	}



}
