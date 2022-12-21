package coursecomponents;

import java.io.Serializable;

import enums.Days;
import enums.LessonType;
import users.Teacher;

public class Lesson implements Serializable {
    private String lessonRoom;
    
    private LessonType lesson;
    
    private TimeSlot timeslot;
    private int limit;
    
	public Lesson(String lessonRoom, LessonType lesson, TimeSlot timeslot, int limit) {
		super();
		this.lessonRoom = lessonRoom;
		this.lesson = lesson;
		this.timeslot = timeslot;
		this.limit = limit;
	}

	public String getLessonRoom() {
		return lessonRoom;
	}

	public void setLessonRoom(String lessonRoom) {
		this.lessonRoom = lessonRoom;
	}

	public LessonType getLesson() {
		return lesson;
	}

	public void setLesson(LessonType lesson) {
		this.lesson = lesson;
	}

	public TimeSlot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(TimeSlot timeslot) {
		this.timeslot = timeslot;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "Lesson [lessonRoom=" + lessonRoom + ", lesson=" + lesson + ", timeslot=" + timeslot + "]";
	}
   
}
