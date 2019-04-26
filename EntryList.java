import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;

public class EntryList implements Serializable {
	private ArrayList<Entry> entryList;
	private static int count = 0;
	//public static String filePath = "/home/bo/Downloads/test";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM:dd:yy");
	public enum SortedBy {
		byName,
		byDescription,
		byPriority,
		byDueDate,
		byStatus;
	}
	private static SortedBy currentSort = SortedBy.byPriority;
	public EntryList() {
		entryList = new ArrayList<Entry>();
	}

	// Methods to Add and Delete Entries
	public void addEntry(Entry newEntry) {
		count++;
		for(int i = 0; i < entryList.size(); ++i) {
			if(entryList.get(i).getPriority() == newEntry.getPriority()) {
				//shift them up
				entryList.get(i).setPriority(entryList.get(i).getPriority() + 1);
				int priorityTemp = entryList.get(i).getPriority();
				int index = i;
				boolean needsToGoAgain = true;
				while(needsToGoAgain == true) {
					needsToGoAgain = false;
					for(int j =0; j < entryList.size(); ++j) {
						if(entryList.get(j).getPriority() == priorityTemp && j != index) {
							entryList.get(j).setPriority(entryList.get(j).getPriority() + 1);
							needsToGoAgain = true;
							priorityTemp = entryList.get(j).getPriority();
							index = j;
							break;
						}
					}
				}
				
			}
		}
		entryList.add(newEntry);
	}

	public void deleteEntry(int indexToDelete) {
		Entry toDelete = entryList.get(indexToDelete);
		toDelete.markAsDeleted();
	}


	// Methods to Sort the List
	public void sortByName() {
		entryList.sort(new EntryList.NameCompare());
		currentSort = SortedBy.byName;
	}

	public void sortByDescription() {
		entryList.sort(new EntryList.DescriptionCompare());
		currentSort = SortedBy.byDescription;
	}

	public void sortByPriority() {
		entryList.sort(new EntryList.PriorityCompare());
		currentSort = SortedBy.byPriority;
	}

	public void sortByDueDate()  {
		entryList.sort(new EntryList.DueDateCompare());
		currentSort = SortedBy.byDueDate;
	}

	public void sortByStatus() {
		entryList.sort(new EntryList.StatusCompare());
		currentSort = SortedBy.byStatus;
	}
	public Entry getEntryWithIndex(int index) {
		return entryList.get(index);
	}

	public int getSize() {
		return entryList.size();
	}
	
	public Entry getEntryWithDescription(String descr) {
		for(int i =0; i < entryList.size(); ++i) {
			if(entryList.get(i).getDescription() == descr) {
				return entryList.get(i);
			}
		}
		return null;
	}
	
	public void setDueDateGiveDescription(String descr, Date newDueDate) {
		for(int i =0; i < entryList.size(); ++i) {
			if(entryList.get(i).getDescription() == descr) {
				entryList.get(i).setDueDate(newDueDate);
			}
		}
	}
	
	public boolean DescripExists(String descr) {
		for(int i =0; i < entryList.size(); ++i) {
			if(entryList.get(i).getDescription() == descr) {
				return true;
			}
		}
		
		return false;
	}
	
	public int indexForDescription(String descr) {
		
		for(int i =0; i < entryList.size(); ++i) {
			if(entryList.get(i).getDescription() == descr) {
				return i;
			}
		}
		return 0; //it should always find it
	}
	
	// Methods to Save and Write to A File
	public void save(String nameOfFile) {
		// save each of the Entries in the ArrayList 
		try {
			FileOutputStream fos = new FileOutputStream(nameOfFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Write the number of Entries that will be written
			oos.writeInt(count);
		
			for(Entry entry : entryList) {
				oos.writeObject(entry);
			}

			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void load(String nameOfFile) {
		ArrayList<Entry> temp = new ArrayList<Entry>();

		try {
			FileInputStream fis = new FileInputStream(nameOfFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			int length = ois.readInt();

			for(int i = 0; i < length; i++) {
				temp.add((Entry) ois.readObject());
			}

			ois.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		entryList = temp;
	}
	
	public void importEntries(String nameOfFile) {
		ArrayList<Entry> temp = new ArrayList<Entry>();
		int length = 0;
		
		try {
			FileInputStream fis = new FileInputStream(nameOfFile);
			ObjectInputStream ois = new ObjectInputStream(fis);

			length = ois.readInt();

			for(int i = 0; i < length; i++) {
				temp.add((Entry) ois.readObject());
			}

			ois.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		entryList = temp;
		count = length;
	}

	public void generateReport(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);

			for(Entry entry : entryList) {
				pw.print(entry.toString() + "                    \n");
			}

			pw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		entryList = new ArrayList<Entry>();
	}

	/* Helper Functions */
	public boolean uniqueDescrip(String descip) {
		for(int i = 0; i < entryList.size(); i++) {
			if (entryList.get(i).getDescription().equals(descip)) {
				return false;
			}
		}

		return true;
	}

	public void printEntries() {
		for(Entry entry : entryList) {
			entry.print();
			System.out.println();
		}
	}
	
	public boolean isNameUnique(String newName) {
		for(int i = 0; i < entryList.size(); i++) {
			if (entryList.get(i).getName().equals(newName)) {
				return false;
			}
		}

		return true;
	}

	// Nested Classes used to implement sorting features
	static class NameCompare implements Comparator<Entry> 
	{ 
		public int compare(Entry entry1, Entry entry2) 
		{ 
			if (entry1.getName().compareTo(entry2.getName()) < 0 ) 
					return -1; 
			if (entry1.getName().compareTo(entry2.getName()) > 0) 
				return 1; 
	        
			else return 0; 
		} 
	} 
		
	static class DescriptionCompare implements Comparator<Entry> 
	{ 
		public int compare(Entry entry1, Entry entry2) 
		{ 
			if (entry1.getDescription().compareTo(entry2.getDescription()) < 0 ) 
				return -1; 
			if (entry1.getDescription().compareTo(entry2.getDescription()) > 0) 
				return 1; 
        
			else return 0; 
		} 
	} 

	static class StatusCompare implements Comparator<Entry> 
	{ 
		public int compare(Entry entry1, Entry entry2) 
		{ 
			if (entry1.getStatus().compareTo(entry2.getStatus()) < 0 ) 
				return 1; 
			if (entry1.getStatus().compareTo(entry2.getStatus()) > 0) 
				return -1; 
        
			else return 0; 
		} 
	} 

	static class DueDateCompare implements Comparator<Entry> 
	{ 
		public int compare(Entry entry1, Entry entry2) 
		{ 
			if(entry1.getDueDate().compareTo(entry2.getDueDate()) < 0 )
				return -1;
			if(entry1.getDueDate() .compareTo(entry2.getDueDate()) > 0)
				return 1;
			else
				return 0;
		} 
	}

	static class PriorityCompare implements Comparator<Entry> 
	{ 
		public int compare(Entry entry1, Entry entry2) 
		{ 
			if(entry1.getPriority() < entry2.getPriority())
				return -1;
			if(entry1.getPriority() > entry2.getPriority())
				return 1;
			else
				return 0;
		} 
	}
}
