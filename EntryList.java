import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;

public class EntryList implements Serializable {
	private ArrayList<Entry> entryList;
	private static int count = 0;

	public EntryList() {
		entryList = new ArrayList<Entry>();
	}

	// Methods to Add and Delete Entries
	public void addEntry(Entry newEntry) {
		count++;
		newEntry.setPriority(count);
		entryList.add(newEntry);
	}

	public void deleteEntry(int indexToDelete) {
		Entry toDelete = entryList.get(indexToDelete);
		toDelete.markAsDeleted();
	}

	// Methods to Sort the List
	public void sortByDescription() {
		entryList.sort(new EntryList.DescriptionCompare());
	}

	public void sortByPriority() {
		entryList.sort(new EntryList.PriorityCompare());
	}

	public void sortByDueDate()  {
		entryList.sort(new EntryList.DueDateCompare());
	}

	public void sortByStatus() {
		entryList.sort(new EntryList.StatusCompare());
	}

	// Methods to Save and Write to A File
	public void save() {
		// save each of the Entries in the ArrayList 

	}

	public void load() {
		
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

	public void WriteObjectToFile(Object serObj) {
		final String filePath = "/home/bo/Downloads/test";

		try {
			FileOutputStream fileOut = new FileOutputStream(filePath) ;
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut) ;
			objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println("The object was successfully written");
			
			
		} catch(Exception e) {
			System.out.println("The object was not successfully written");
			e.printStackTrace();
		}
	}

   public Object ReadObjectFromFile(String filepath) {
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Object obj = objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            System.out.println("The Object has not been read from the file");
            ex.printStackTrace();
            return null;
        }
    }

	// Nested Classes used to implement sorting features
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
