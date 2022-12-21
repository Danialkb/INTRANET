package users;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

import coursecomponents.Book;
import enums.JobTitle;

public class Librarian extends Employee implements Serializable{
    public Librarian(String password, String fullname, String id, double salary,
			JobTitle position) {
		super(password, fullname, id, salary, position);
	}

    private static HashMap<Student, Vector<Book>> studentsBook;
    private static HashMap<Book, Integer> books;
    
    static {
    	studentsBook = new HashMap<Student, Vector<Book>>();
    	books = new HashMap<Book, Integer>();
    }
    
    public static HashMap<Book, Integer> viewBooks() {
        return books;
    }
    
    public void addNewBooks(Book b, Integer numOfBooks) {
        if(books.get(b) == null)
        	books.put(b, numOfBooks);
        else 
        	books.replace(b, books.get(b) + numOfBooks);
    }
    
    public static boolean getBook(Student s, Book b) {
    	if(studentsBook.get(s) == null || !studentsBook.get(s).contains(b))
    		return false;
    	else {
    		studentsBook.get(s).remove(b);
    		books.replace(b, books.get(b) + 1);
    	}
    	return true;
    }
    
    public static boolean giveBooks(Student s, Book b) {
        if(studentsBook.get(s) != null && studentsBook.get(s).contains(b))
        	return false;
        else {
        	if(studentsBook.get(s) == null) {
        		Vector<Book> tmp = new Vector<Book>();
        		tmp.add(b);
        		studentsBook.put(s, tmp);
        	}
        	else {
        		studentsBook.get(s).add(b);
        	}
        }
        return true;
        	
    }
    
    
}
