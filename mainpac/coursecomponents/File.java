package coursecomponents;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {
    private String title;

    private Date date;

    private String text;

    private String fileType;

    public File(String title, Date date, String text, String fileType) {
    	super();
    	this.title = title;
    	this.date = date;
    	this.text = text;
    	this.fileType = fileType;
    }
    
    public void viewFile() {
    	System.out.println(this.text);
    }
    
	@Override
	public String toString() {
		return "File [title=" + title + ", date=" + date + ", course=" + ", fileType="
				+ fileType + "]";
	}

    

    
}
