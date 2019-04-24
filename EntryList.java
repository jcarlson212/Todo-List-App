import java.util.ArrayList;
import java.util.Comparator;
import java.io.Serializable;

public class EntryList {
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
