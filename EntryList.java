import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EntryList implements Serializable {
	private ArrayList<Entry> entryList;
	private static int count = 0;
	public static String filePath = "/home/bo/Downloads/test";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.applyPattern("MM:dd:yy");
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
		newEntry.changePriority(count);
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

	// Methods to get an Entry
	public Entry getEntry(String descrip) {
		for(Entry entry : entryList) {
			if (entry.getDescription().equals(descrip)) {
				return entry;
			}
		}

		return null;
	}

	public Entry getEntry(int priority) {
		for(Entry entry : entryList) {
			if (entry.getPriority() == priority) {
				return entry;
			}
		}

		return null;
	}

	// Methods to change the parameters of an entry
	public void changeEntryName(String target, String newName) {
		if (newName.isEmpty() || target.isEmpty()) {
			System.out.println("Neither Field can be empty");
		}

		Entry toChange = getEntry(target);

		if (toChange == null) {
			System.out.print("Entry with that description is not in the list");
			return;
		}

		if (!isDescriptionUnique(newDescrip)) {
			System.out.println("The descripton you want to set is not unique");
			return;
		}

		toChange.changeDescription(newDescrip);

		// TODO: Call update function here
	}

	public void changeEntryDescription(String target, String newDescrip) {
		if (newDescrip.isEmpty() || target.isEmpty()) {
			System.out.println("Neither Field can be empty");
		}

		Entry toChange = getEntry(target);

		if (toChange == null) {
			System.out.print("Entry with that description is not in the list");
			return;
		}

		if (!isDescriptionUnique(newDescrip)) {
			System.out.println("The descripton you want to set is not unique");
			return;
		}

		toChange.changeDescription(newDescrip);

		// TODO: Call update function here
	}

	public void changeEntryDueDate(String target, String newDateString) {
		if (newDateString.isEmpty() || target.isEmpty()) {
			System.out.println("Neither Field can be empty");
			return;
		}

		Entry toChange = getEntry(target);

		if (toChange == null) {
			System.out.println("Entry with that description is not in the list");
			return;
		}
		
		Date newDate = null;
		try {
			newDate = dateFormat.parse(newDateString);
		} catch(Exception e) {
			newDate = toChane.getDueDate();
			e.printStackTrace();
		}
		
		toChange.changeDueDate(newDate);
	}

	public void changeEntryPriority(String target, int newPriority) {
		if (target.isEmpty()) {
			System.out.print("The Target Field can't be empty");
			return;
		}

		if (newPriority > count || newPriority < 1) {
			System.out.print("The Priority is out of range");
			return;
		}

		Entry toChange = getEntry(target);

		if (toChange == null) {
			System.out.println("Entry with that description is not in the list");
			return;
		}

		toChange.changePriority(newPriority);

		if (currentSort == SortedBy.byPriority) {
			int index = entryList.indexOf(toChange);

			entryList.remove(index);
			entryList.add(newPriority - 1, toChange);

			for(int i = index + 1; i < entryList.size(); i++) {
				entryList.get(i).changePriority(i + 1);
			}
		}
	}

	// Methods to Save and Write to A File
	public void saveList() {
		// save each of the Entries in the ArrayList 
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
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

	public void importEntries() {
		ArrayList<Entry> temp = new ArrayList<Entry>();
		int length = 0;
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
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
				pw.print(entry.toString() + "\n");
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
	public boolean isDescriptionUnique(String descip) {
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


	// Nested Classes used to implement sorting features
	static class NameCompare implements Comparator<Entry> 
	{ 
		public int compare(Entry entry1, Entry entry2) 
		{ 
			if (entry1.getName().compareTo(entry2.getName()) < 0 ) 
				return -1; 
			if (entry1.getName().compareTo(entry2.Name()) > 0) 
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
