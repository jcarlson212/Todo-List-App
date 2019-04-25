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

	private String name;
	private String description;
	private Date dueDate;
	private Date finishDate;
	private Status currentStatus;
	private boolean isDeleted;
	private int priority;
	
	public Entry(String name, String description, Date dueDate) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.finishDate = null;
		this.priority = 0;
		this.currentStatus = Status.notStarted;
		this.isDeleted = false;
		
	} //end of constructor
	
	public String getName() {
		return name;
	}
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
	
	public Status getStatus() {
		return currentStatus;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public void changeDescription(String des) {
		this.description  = des;
	}
	
	public void setFinishDate() {
		this.finishDate = new Date();
	}
	
	public void changeDueDate(Date date) {
		this.dueDate = date;
	}
	
	public void changePriority(int prior){
		this.priority = prior;
	}
	
	public void markAsDeleted() {
		this.isDeleted = true;
	}
	
	public void changeStatus(Status newStatus) {
		this.currentStatus = newStatus;
	}


	// Helper Functions
	public String toString() {
		String stringRep = "";
		stringRep += getName() + "\n";
		stringRep += getDescription() + "\n";
		stringRep += getPriority() + "\n";
		stringRep += getDueDate() + "\n";
		if (getStatus() == finished) {
			stringRep += getFinishDate() + "\n";
		}
		stringRep += getStatus();

		if (isDeleted()) {
			stringRep += "Deleted\n"
		}

		return stringRep;
	}

	public void print() {
		String toPrint = "";
		toPrint += getName() + "\n";
		toPrint += getDescription() + "\n";
		toPrint += getPriority() + "\n";
		toPrint += getDueDate() + "\n";

		if (getStatus() == finished) {
			toPrint += getFinishDate() + "\n";
		}

		toPrint += getStatus();

		if (isDeleted()) {
			toPrint += "Deleted\n"
		}

		System.out.println(toPrint);
	}

}//end of entry class
