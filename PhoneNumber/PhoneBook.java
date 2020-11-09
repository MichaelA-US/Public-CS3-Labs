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
		 * Basic constructor that initalizes the person and phonenumber
		 * @param person
		 * @param pNumber
		 */
		public Entry(Person person, PhoneNumber pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
		}
		/**
		 * Returns a string representation of the person and their number
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
	 * Basic constructor that defines the size and hashtable size of the phonelist
	 */
	public PhoneBook()
	{
		size = 0;
		hashTable = new Entry[5002];
	}
	/**
	 * Secondary constructor that defines the size through a value and sets the curr size
	 * @param size
	 */
	public PhoneBook(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	/**
	 * Puts the person with their phonenumber into the list
	 */
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode() + phone.hashCode();
		for(int i = 0; i < hashTable.length; i++)
		{
			if(hashTable[temp] == null)
			{
				hashTable[temp] = new Entry(person, phone);
				size++;
				return phone;
			}
			temp++;
			temp %= hashTable.length;
		}
		return phone;
	}
	/**
	 * Gets the person with their phonenumber from the list
	 */
	@Override
	public PhoneNumber get(Person person)
	{
		// TODO Auto-generated method stub
		try
		{
		int temp = person.hashCode();
		//System.out.println(temp); //
		Entry temp1 = hashTable[temp];
		//System.out.println(temp1);
		for(int i = 0; i < hashTable.length; i++)
		{
			//System.out.println("x");
			temp1 = hashTable[temp];
			if(temp1.person.equals(person))
			{
				//System.out.println("x");
				return temp1.pNumber;
			}
			temp++;
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
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
	 * Removes the person from the phonebook
	 */
	@Override
	public PhoneNumber remove(Person person)
	{
		//System.out.println("WORKS");
		// TODO Auto-generated method stub
		try
		{
			int temp = person.hashCode();
			Entry temp1 = hashTable[temp];
			for(int i = 0; i < hashTable.length; i++)
			{
				temp1 = hashTable[temp];
				//System.out.println(temp1);
				if(temp1.person.equals(person))
				{
					int temp2 = person.hashCode();
					//System.out.println(temp2);
					Entry ent = temp1;
					//System.out.println(hashTable[temp2]);
					hashTable[temp2] = temp1.next;
					//System.out.println(hashTable[temp2]);
					return ent.pNumber;
				}
				temp++;
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	/**
	 * Returns a string representation of the phonebook
	 */
	@Override 
	public String toString()
	{
		String s = "";
		for (int i = 0; i < hashTable.length; i++) 
		{
			s += i + ":" + hashTable[i] + "\n";
		}
		return s;
	}
	
	

}
