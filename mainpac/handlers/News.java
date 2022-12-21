package handlers;

import java.io.Serializable;
import java.util.Date;

import users.Manager;

public class News implements Serializable {
    private String title;

    private String description;

    private Date date;
 
    public News(String title, String description, Date date) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescribtion() {
		return description;
	}

	public void setDescribtion(String describtion) {
		this.description = describtion;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", description=" + description + ", date=" + date + "]";
	}

    
    
}
