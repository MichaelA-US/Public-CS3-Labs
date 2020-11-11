/**
 * This class implements the IMap class and defines multiple methods for the phonebook
 * such as put, remove, get
 * @author Michael
 *
 */
public class PhoneBook implements IMap
{
	/**
	 * Basic class that define the Entry of the person and their phonenumber
	 * @author Michael
	 *
	 */
	class Entry
	{
		Person person;
		PhoneNumber pNumber;
		Entry next;
		/**
		 * Entry Class that is practically a custom linked list to
		 * navigate through the hashtable of Entries
		 * @author Michael
		 *
		 * @param <Person> - the Person object with a name
		 * @param <PhoneNumber> - the PhoneNumber object with a pNumber
		 */
		public Entry(Person person, PhoneNumber pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
			this.next = null;
		}
		/**
		 * Print a string representation of each entry with the Person object
		 * to its given PhoneNumber object
		 */
		@Override
		public String toString()
		{
			return " " + person.toString() + ": " + pNumber.toString();
		}
	}
	private Entry[] hashTable;
	public static int size;
	/**
	 * Basic constructor that initalizes the hashTable to a size of 11 individual 
	 * hashcodes with a chain of the entries
	 */
	public PhoneBook()
	{
		size = 0;
		hashTable = new Entry[11];
	}
	/**
	 * Secondary constructor that initalizes the hashTable to any
	 * given size through the parameters
	 * @param size - the size of the hashTable
	 */
	@SuppressWarnings("static-access")
	public PhoneBook(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	/**
	 * Put method that enters in the Entry into the hashTable, does this by
	 * creating a new entry of the two objects given and locates the index of its
	 * hashcode. If the hashcode already exists we just place in the item and continue on
	 * the chain of objects. However, if it already exists we don't add it. And if there is no
	 * index at that hashcode we add the object to the index in the linkedList with the 
	 * hashcode of the entry.
	 * @param person - the first object for the entry
	 * @param phone - the second object in the entry
	 * @return - the second object of the entry which is the PhoneNumber.
	 */
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone)
	{
//		// TODO Auto-generated method stub
//		int temp = person.hashCode() + phone.hashCode();
//		Entry ent = new Entry(person, phone); //
//		for(int i = 0; i < hashTable.length; i++) //loop through the hashtable
//		{
//			if(hashTable[temp] == null) 
//			{
//				hashTable[temp] = new Entry(person, phone); //create a new entry of the person with their phone at the hashtable hashcode
//				size++;
//				return phone;
//			}
//			temp++; //increment the hashcode
//			temp %= hashTable.length; //modlus by the length of the hashtable to repeat put
//		}
//		return phone;
		
		Entry ent = new Entry(person, phone);
		int temp = person.hashCode();
		Entry othEnt = hashTable[temp];
		if(othEnt == null)
		{
			hashTable[temp] = ent;
			//System.out.println(ent);
		}
		else
		{
			//System.out.println(ent);
			while(othEnt.next != null)
			{
				//System.out.println(ent);
				if(othEnt.person.equals(person)) //if already exist DONT ADD
				{
					//System.out.println(ent);
					return othEnt.pNumber;
				}
				othEnt = othEnt.next;
			}
			size++;
			othEnt.next = ent;
		}
		return phone;
//		while(ent.next != null)
//		{
//			if(othEnt.pNumber.hashCode() == (phone.hashCode()))
//			{
//				return ent.pNumber;
//			}
//			othEnt = othEnt.next;
//		}
//		othEnt = ent.next;
//		size++;
//		return phone;
	}
	/**
	 * The get method retrieves a given Person object and finds the PhoneNumber value of the object and
	 * returns it. I do this by tracking the hashCode of the given Person object and create a new entry of
	 * our current hashTable at the given index, then we check whether the K obj is equal to the current K
	 * object that we are indexing, and if it is we found it. However, if it's not we continue to iterate through the chain of
	 * the hashCode and get each next object until they are equal. If it doesn't exist just return null.
	 * @param person - the Person object that we want to find
	 * @return phone - the PhoneNumber of the person, or a failedFind object that shows we couldn't find it
	 */
	@Override
	public PhoneNumber get(Person person)
	{
		// TODO Auto-generated method stub
		PhoneNumber failedFind = new PhoneNumber("No Number Found For User");
		int temp = person.hashCode();
		
		Entry ent = this.hashTable[temp];
		while(ent != null)
		{
			if(ent.person.equals(person)) 
			{
				return ent.pNumber;
			}
			ent = ent.next;
		}
		return failedFind;
	}
	/**
	 * Gets the size of the phonebook
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}
	/**
	 * The remove method removes the given Person with their PhoneNumber object. We do this by storing the hashCode of the given Person object,
	 * and go into the current chain with the given index. Then we first find if the entry at that person equals the person we set
	 * it to the next person and return the VPhoneNumber object. If we haven't found it in the first iteration then we have to store a new entry
	 * with the previous entry at the next inde of the chain then we iterate through their and check if that next entry is equal to the K
	 * object we are trying to find. If it is we just remove it; however, if it's not we have to go to the next position in the chain and change
	 * both positions of the entries until we locate the object. If we still can't find the object return the failedFind.
	 * @param person - the Person object to remove with the PhoneNumber value
	 * @return phone - the PhoneNumber value that was removed, or failedFind if it didn't exist
	 */
	@Override
	public PhoneNumber remove(Person person)
	{
		//System.out.println("WORKS");
		// TODO Auto-generated method stub
		PhoneNumber failedFind = new PhoneNumber("No Number Found For User");
		try
		{
			int temp = person.hashCode();
			Entry ent = hashTable[temp];
			
			if(ent.person.equals(person)) //If already equal automatically remove
			{
				hashTable[temp] = ent.next;
				return ent.pNumber;
			}
			Entry nextEnt = ent.next;
			//for(int i = 0; i < hashTable.length; i++) //loop through the hashtable
			while(nextEnt != null)
			{
				if(nextEnt.person.equals(person))
				{
					hashTable[temp] = ent.next;
					return ent.pNumber;
				}
				ent = ent.next;
				nextEnt = nextEnt.next;
				
				if(nextEnt != null)
				{
					ent.next = nextEnt.next;
					
				}
				size--;
				//ent = hashTable[temp]; // store the entry at the hashcode index of the person
				//System.out.println(temp1);
//				if(ent.person.equals(person))
//				{
//					int temp2 = person.hashCode(); //get the hashcode of the person
//					//System.out.println(temp2);
//					Entry entry = ent; //update the entry with the hashtable index
//					//System.out.println(hashTable[temp2]);
//					hashTable[temp2] = ent.next; //get the next person
//					//System.out.println(hashTable[temp2]);
//					return entry.pNumber; //return the phonenumber of the person removed
//				}
//				temp++; //increment the temp
			}
			return ent.pNumber;
			
		}
		catch(Exception e)
		{
			
		}
		return failedFind;
	}
	/**
	 * Basic toString method that prints out a representation of the hashTable we do this by getting each index hashCode which is practically each
	 * chain, and then we print out each entry within that chain. Then once the chain ends we move on to the next one. 
	 * 
	 * NOTE: I break the count at 5 due to having so many entries causing the char limit to be reached and having it only print from 5 - 11, so I print only the first 5 CHAINS
	 * @return the hashTable as a string
	 */
	@Override 
	public String toString()
	{
		int count = 0;
		String s = "";
		for(Entry temp: hashTable)
		{
			if(count == 5) //do this to print first 5 because char limit problem with so many entries
			{
				break;
			}
			count++;
			s += count + ": ";
			while(temp != null)
			{
				s += temp;
				temp = temp.next;
				s += " -->";
			}
			s += "\n";
		}
		return s;
	}
	
	

}
