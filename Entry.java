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
	private String name;
	
	public Entry(String description, Date dueDate) {
		this.description = description;
		this.dueDate = dueDate;
		this.finishDate = null;
		this.priority = 0;
		this.currentStatus = Status.notStarted;
		this.isDeleted = false;
		this.setName("");
	} //end of constructor
	
	public Entry(String name, String description, Date dueDate, int priority) {
		this.description = description;
		this.dueDate = dueDate;
		this.finishDate = null;
		this.priority = priority;
		this.currentStatus = Status.notStarted;
		this.isDeleted = false;
		this.setName(name);
	} //end of constructor
	
	public String getDescription(){
		return description;
	}
	
	public String getFinishDateAsString() {
		return finishDate.toString();
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public String getDueDateAsString() {
		return dueDate.toString();
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getPriorityAsString() {
		return String.valueOf(priority);
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
	
	public boolean isDeleted() {
		return this.isDeleted;
	}


	// Helper Functions
	public String toString() {
		String stringRep = "";
		stringRep += getDescription() + "\n";
		stringRep += getPriority() + "\n";
		stringRep += getDueDate() + "\n";
		if (getStatus() == Status.finished) {
			stringRep += getFinishDate() + "\n";
		}
		stringRep += getStatus();
		
		if (isDeleted()) {
			stringRep += "Deleted\n";
		}
		
		return stringRep;
	}

	public void print() {
		String toPrint = "";
		toPrint += getDescription() + "\n";
		toPrint += getPriority() + "\n";
		toPrint += getDueDate() + "\n";

		if (getStatus() == Status.finished) {
			toPrint += getFinishDate() + "\n";
		}

		toPrint += getStatus();
		
		if (isDeleted()) {
			toPrint += "Deleted\n";
		}
		
		System.out.println(toPrint);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}//end of entry class
