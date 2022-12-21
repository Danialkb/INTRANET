package coursecomponents;

import java.io.Serializable;

import enums.Days;

public class TimeSlot implements Serializable{
	private Integer limit;

	private Days day;

	private Integer startHour;

	private Integer endHour;

	private Course course;

	public TimeSlot(Integer limit, Days day, Integer startHour, Integer endHour, Course course) {
		super();
		this.limit = limit;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
		this.course = course;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "TimeSlot [limit=" + limit + ", day=" + day + ", startHour=" + startHour + ", endHour=" + endHour
				+ ", course=" + course + "]";
	}
	
	
	
}
