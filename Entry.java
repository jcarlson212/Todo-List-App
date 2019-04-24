//package entry;
import java.util.*;
import java.text.*;
import java.io.Serializable;


public class Entry {
	public enum Status {
		notStarted,
		inProgress,
		finished;
	}

	private String description;
	private Date dueDate;
	private Date finishDate;
	private Status currentStatus;
	private boolean isDeleted;
	private int priority;
	
	public Entry(String description, Date dueDate) {
		this.description = description;
		this.dueDate = dueDate;
		this.finishDate = null;
		this.priority = 0;
		this.currentStatus = Status.notStarted;
		this.isDeleted = false;
		
	} //end of constructor
	
	public String getDescription(){
		return description;
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setDescription(String des) {
		this.description  = des;
	}
	
	public void setFinishDate(Date date) {
		this.finishDate = date;
	}
	
	public void setDueDate(Date date) {
		this.dueDate = date;
	}
	
	public void setPriority(int prior){
		this.priority = prior;
	}
	
	public void markAsDeleted() {
		this.isDeleted = true;
	}
	
	public Status getStatus() {
		return currentStatus;
	}
	
	public void setStatus(Status newStatus) {
		this.currentStatus = newStatus;
	}
	

	/*
	public static void printArray(ArrayList<Entry> todoList) {
		for( Entry entry: todoList) {
			if(entry.isDeleted == true || entry.isFinished == true)
				continue;
			System.out.println(entry.getDescription()+ "  \tDue Date: " + entry.getDueDate()
			+"\t\tPriority: "+ df.format(entry.getPriority()) + "\tCurrent Status: " + entry.getStatus(entry));
		}
	}
	public String toString() {
		Stirng toReturn = "";

		toReturn +=.getDescription() + "\n";
		toReturn += getStatus() + "\n";
		toReturn += 

		toReturn += getPriotriy() + "\n";
		



			String allEntrytoString="";			
			for( Entry entry: todoList) {
			allEntrytoString= entry.getDescription() + "\n" 
							+ entry.getStatus(entry) + "\n" 
							+ df.format(entry.getPriority()) + "\n" 
							+ entry.getDueDate() + "\n";
			}//end of for loop
			return allEntrytoString;	
	}
	*/
	
}//end of entry class
