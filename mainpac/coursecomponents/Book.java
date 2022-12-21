package coursecomponents;

import java.io.Serializable;

import users.Librarian;

/**
* @generated
*/
public class Book implements Serializable {
    private String title;

    private String author;

    private Integer numofPages;

  

	public Book(String title, String author, Integer numofPages) {
		super();
		this.title = title;
		this.author = author;
		this.numofPages = numofPages;
	}
	
	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public Integer getNumofPages() {
		return numofPages;
	}



	public void setNumofPages(Integer numofPages) {
		this.numofPages = numofPages;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", numofPages=" + numofPages + ", numOfBooks="
				+ "]";
	}
    

    
}
