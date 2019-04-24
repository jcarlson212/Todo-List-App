//package entry;
import java.util.*;
import java.text.*;


public class Entry {
	
	/*
	public static void main(String []args)
	{
		Scanner in = new Scanner (System.in);
		StatusCompare sttComp = new StatusCompare();//status compare method object
		descriptionCompare desComp = new descriptionCompare();//description compare
		dueDateCompare dueComp = new dueDateCompare();//dueDate compare
		priorityCompare priComp = new priorityCompare();//priority compare
		SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
		
		String SdueDate = "";
		String description = "";
		Date dueDate;
		int priority;
		int decision;
		boolean stillAdding = true;
		ArrayList<Entry> todoList = new ArrayList<Entry>();// The ArrayList
		
		while(stillAdding)
		{
			
			System.out.println("Please Enter Your Due Date (In Format of MM/dd/yyyy): ");
			SdueDate = in.next();
			
			//this try part for parsing due date from string to Date Object
			try {
				dueDate = sf.parse(SdueDate);
			}catch(java.text.ParseException e) {
				System.out.println("Invalid Date Format (Format is MM/dd/yyyy) \t Please Re_enter\n");
				continue;
			}
			
			System.out.println("Please Enter Your Description: ");
			description = in.nextLine();	
			description = in.nextLine();
			System.out.println("Please Enter Your Priority: ");
			priority = in.nextInt();
			
			

			
			todoList.add(new Entry (description, dueDate, priority));
			
			System.out.println("Still adding one more entry? To enter 0 to quit");
			decision = in.nextInt();
			if(decision == 0)
				stillAdding = false;
					
		}
		
		
		
		//original order
		System.out.println("Before Sort:\n");
		Entry.printArray(todoList);

		

		//Description sort
		System.out.println("\nAfter Description Sort:\n");
		Collections.sort(todoList, desComp);
		Entry.printArray(todoList);
		
		
		//Due date sort
		System.out.println("\nAfter DueDate Sort:\n");
		Collections.sort(todoList, dueComp);
		Entry.printArray(todoList);
		
		
		//Priority Sort
		System.out.println("\nAfter Priority Sort:\n");
		Collections.sort(todoList, priComp);
		Entry.printArray(todoList);
		
		//Status sort
		System.out.println("\nAfter Status Sort:\n");
		Collections.sort(todoList, sttComp);
		Entry.printArray(todoList);
		
		System.out.println(Entry.toString(todoList));
		
	}//end of main

	
	
	
	//below part is functions and variables of entry and constructor
	static DecimalFormat df = new DecimalFormat("#");
	static DecimalFormat dff = new DecimalFormat("#.00");
	
	private boolean isDeleted = false;
	private boolean isFinished = false;
	private String description = "";
	private String currentStatus;
	private double finishDate;
	private Date dueDate;
	private int intStatus;
	private int priority;	
	private final int notStart = 0;
	private final int inProgress = 1;
	private final int finished = 2;
	private final String SnotStart =   "Not Start Yet";
	private final String SinProgress = "In Progress";
	private final String SFinished = "Event finished";
	/*private enum status{
		notStart("not Start"),
		inProgress("inProgress"),
		isFinished("isFinished");
		
		private  String SnotStart;
		private  String SinProgress;
		private  String SisFinished;
		
		status(String parsing){
			SnotStart = parsing;
		}
	}*/
	
	public Entry(String description, Date dueDate, int priority) {
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.intStatus = notStart;
		this.currentStatus = SnotStart;
		
	}//end of constructor
	
	public String getDescription(){
		return description;
	}
	
	public double getFinishDate() {
		return finishDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public double getPriority() {
		return priority;
	}
	
	public void setDescription(String des) {
		this.description  = des;
	}
	
	public void setFinishDate(double date) {
		this.finishDate = date;
	}
	
	public void setDueDate(Date date) {
		this.dueDate = date;
	}
	
	public void setPriority(int prior){
		this.priority = prior;
	}
	
	public void toDelete(Entry entry1) {
		entry1.isDeleted = true;
	}
	
	public void toFinish(Entry entry1) {
		entry1.isFinished = true;
	}
	
	public String getStatus(Entry entry1) {
		String result="";
		if(entry1.intStatus == notStart)
			result = SnotStart;
		if(entry1.intStatus == inProgress)
			result = SinProgress;
		if(entry1.intStatus == finished)
			result = SFinished;
		return result;
	}
	
	public void setStatus(int setter) {
		if(setter == inProgress)
		{
			this.currentStatus = SinProgress;
			this.intStatus = inProgress;
		}
		else if(setter == finished)
		{
			this.currentStatus = SFinished;
			this.intStatus = finished;
		}
	}
	

	public static void printArray(ArrayList<Entry> todoList) {
		for( Entry entry: todoList) {
			if(entry.isDeleted == true || entry.isFinished == true)
				continue;
			System.out.println(entry.getDescription()+ "  \tDue Date: " + entry.getDueDate()
			+"\t\tPriority: "+ df.format(entry.getPriority()) + "\tCurrent Status: " + entry.getStatus(entry));
		}
	}
	
	public static String toString(ArrayList<Entry> todoList) {
			String allEntrytoString="";			
			for( Entry entry: todoList) {
			allEntrytoString= entry.getDescription() + "\n" 
							+ entry.getStatus(entry) + "\n" 
							+ df.format(entry.getPriority()) + "\n" 
							+ entry.getDueDate() + "\n";
			}//end of for loop
			return allEntrytoString;	
	}
	
}//end of entry class


//below parts are comparing methods of different variables.
//due to Collection.Sort can receive two parameters, so I use classes instead of functions.

class descriptionCompare implements Comparator<entry> 
{ 
    public int compare(entry entry1, entry entry2) 
    { 
        if (entry1.getDescription().compareTo(entry2.getDescription()) < 0 ) 
        	return -1; 
        if (entry1.getDescription().compareTo(entry2.getDescription()) > 0) 
        	return 1; 
        
        else return 0; 
    } 
} 

class StatusCompare implements Comparator<entry> 
{ 
    public int compare(entry entry1, entry entry2) 
    { 
        if (entry1.getStatus(entry1).compareTo(entry2.getStatus(entry2)) < 0 ) 
        	return 1; 
        if (entry1.getStatus(entry1).compareTo(entry2.getStatus(entry2)) > 0) 
        	return -1; 
        
        else return 0; 
    } 
} 

class dueDateCompare implements Comparator<entry> 
{ 
    public int compare(entry entry1, entry entry2) 
    { 
        if(entry1.getDueDate().compareTo(entry2.getDueDate()) < 0 )
        	return -1;
        if(entry1.getDueDate() .compareTo(entry2.getDueDate()) > 0)
        	return 1;
        else
        	return 0;
    } 
}

class priorityCompare implements Comparator<entry> 
{ 
    public int compare(entry entry1, entry entry2) 
    { 
        if(entry1.getPriority() < entry2.getPriority())
        	return -1;
        if(entry1.getPriority() > entry2.getPriority())
        	return 1;
        else
        	return 0;
    } 
    
    */
}
  
