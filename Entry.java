//package entry;
import java.util.*;
import java.text.*;
import java.io.*;

public class Entry implements Serializable {
	public enum Status {
		notStarted,
		inProgress,
		finished;

		public String toString() {
			String name = this.name() ;

			if (name.equals("notStarted")) {
				return "Not Started";
			}

			if (name.equals("inProgress")) {
				return "In Progress";
			}

			if (name.equals("finished")) {
				return "Finished";
			}

			return name;
		}
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


	// Helper Functions
	public void print() {
		String toPrint = "";
		toPrint += getDescription() + "\n";
		toPrint += getPriority() + "\n";
		toPrint += getDueDate() + "\n";
		toPrint += getStatus();

		System.out.println(toPrint);
	}

}//end of entry class
