
/**
 * This class is a replica of the phonebook class but uses generics that can be universal
 * between the two objects used
 * @author Am10073106
 *
 * @param <K> - generic 1
 * @param <V> - generic 2
 */
public class MyHashTable<K, V> 
{
	/**
	 * Entry Class that is practically a custom linked list to
	 * navigate through the hastable of Entries
	 * @author Michael
	 *
	 * @param <K> - generic 1
	 * @param <V> - generic 2
	 */
	@SuppressWarnings("hiding")
	class Entry<K, V>
	{
		K person;
		V pNumber;
		Entry<K, V> next;
		/**
		 * Basic constructor that initalizes the two generics that
		 * are used
		 * @param person - generic 1 (can be any obj)
		 * @param pNumber - generic 2 (can be  any obj)
		 */
		public Entry(K person, V pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
		}
		/**
		 * Print a string representation of each entry with the generic one object
		 * to its given second generic object
		 */
		@Override
		public String toString()
		{
			return "" + person + ": " + pNumber;
		}
	}
	private Entry<V, K>[] hashTable;
	public static int size;
	/**
	 * Basic constructor that initalizes the hashTable to a size of 11 individual 
	 * hashcodes with a chain of the entries
	 */
	@SuppressWarnings("unchecked")
	public MyHashTable()
	{
		size = 0;
		hashTable = new Entry[11];
	}
	/**
	 * Secondary constructor that initalizes the hashTable to any
	 * given size through the parameters
	 * @param size - the size of the hashTable
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public MyHashTable(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	/**
	 * Put method that enters in the item into the hashTable, does this by
	 * creating a new entry of the two objects given and locates the index of its
	 * hashcode. If the hashcode already exists we just place in the item and continue on
	 * the chain of objects. However, if it already exists we don't add it. And if there is no
	 * index at that hashcode we add the object to the index in the linkedList with the 
	 * hashcode of the entry.
	 * @param person - the first object for the entry
	 * @param phone - the second object in the entry
	 * @return - the second object of the entry which is (V).
	 */
	@SuppressWarnings("unlikely-arg-type")
	public V put(K person, V phone)
	{
		// TODO Auto-generated method stub
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Entry<V, K> ent = new Entry(person, phone);
		int temp = person.hashCode();
		Entry<V, K> othEnt = hashTable[temp];
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
					return (V) phone;
				}
				othEnt = othEnt.next;
			}
			size++;
			othEnt.next = ent;
		}
		return phone;
	}
		
	/**
	 * The get method retrieves a given K object and finds the V value of the object and
	 * returns it. I do this by tracking the hashCode of the given K object and create a new entry of
	 * our current hashTable at the given index, then we check whether the K obj is equal to the current K
	 * object that we are indexing, and if it is we found it. However, if it's not we continue to iterate through the chain of
	 * the hashCode and get each next object until they are equal. If it doesn't exist just return null.
	 * @param person - the K object that we want to find
	 * @return phone - the V object of the K object
	 */
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	public V get(K person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		
		Entry<V,K> ent = this.hashTable[temp];
		while(ent != null)
		{
			if(ent.person.equals(person)) 
			{
				return (V) ent.pNumber;
			}
			ent = ent.next;
		}
		return null;
	}

	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}
	/**
	 * The remove method removes the given K person with their V object. We do this by storing the hashCode of the given K object,
	 * and go into the current chain with the given index. Then we first find if the entry at that person equals the person we set
	 * it to the next person and return the V object. If we haven't found it in the first iteration then we have to store a new entry
	 * with the previous entry at the next inde of the chain then we iterate through their and check if that next entry is equal to the K
	 * object we are trying to find. If it is we just remove it; however, if it's not we have to go to the next position in the chain and change
	 * both positions of the entries until we locate the object. If we still can't find the object return null.
	 * @param person - the K object to remove with the V value
	 * @return phone - the V value that was removed, or null if it didn't exist
	 */
	@SuppressWarnings("unchecked")
	public V remove(K person)
	{
		//System.out.println("WORKS");
				// TODO Auto-generated method stub
		try
		{
			int temp = person.hashCode();
			Entry<V, K> ent = hashTable[temp];
			
			if(ent.person.equals(person)) //If already equal automatically remove
			{
				hashTable[temp] = ent.next;
				return (V) ent.pNumber;
			}
			Entry<V, K> nextEnt = ent.next;
			//for(int i = 0; i < hashTable.length; i++) //loop through the hashtable
			while(nextEnt != null)
			{
				if(nextEnt.person.equals(person))
				{
					hashTable[temp] = ent.next;
					return (V) ent.pNumber;
				}
				ent = ent.next;
				nextEnt = nextEnt.next;
				
				if(nextEnt != null)
				{
					ent.next = nextEnt.next;
					
				}
				size--;
			}
			return (V) ent.pNumber;
			
		}
		catch(Exception e)
		{
			
		}
		return null;
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
		for(Entry<V,K> temp: hashTable)
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