package users; 
 
import java.util.Vector;

import handlers.Paper; 
 
public class Researcher { 
  
	 Vector<Paper> allResearch; 
	  
	 void writePaper(String title, String description) { 
		  Paper newResearch = new Paper(title, description); 
		  allResearch.add(newResearch); 
	 } 
	 
	 {
		 this.allResearch = new Vector<Paper>();
	 }
	  
	 public void viewAllResearch() { 
		  for(Paper i: this.allResearch) { 
		   System.out.println(i); 
		  } 
	 } 
}