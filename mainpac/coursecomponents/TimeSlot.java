package coursecomponents;

import java.io.Serializable;

import enums.Days;

public class TimeSlot implements Serializable{
	private Days day;

	private Integer startHour;

	private Integer endHour;

	public TimeSlot(Days day, Integer startHour, Integer endHour) {
		super();
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
	}
	
	public Days getDay() {
		return day;
	}

	public void setDay(Days day) {
		this.day = day;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	@Override
	public String toString() {
		return "TimeSlot [day=" + day + ", startHour=" + startHour + ", endHour=" + endHour
				+ "]";
	}
	
	
	
}
