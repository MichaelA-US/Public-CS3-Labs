

public class MyHashTable<K, V> 
{
	class Entry<K, V>
	{
		K person;
		V pNumber;
		Entry<K, V> next;
		public Entry(K person, V pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
		}
		@Override
		public String toString()
		{
			return "" + person + ": " + pNumber;
		}
	}
	private Entry<K, V>[] hashTable;
	public static int size;
	public MyHashTable()
	{
		size = 0;
		hashTable = new Entry[5002];
	}
	public MyHashTable(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	
	public V put(K person, V phone)
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int temp = person.hashCode() + phone.hashCode();
		for(int i = 0; i < hashTable.length; i++)
		{
			if(hashTable[temp] == null)
			{
				hashTable[temp] = new Entry<K, V>(person, phone);
				size++;
				return phone;
			}
			temp++;
			temp %= hashTable.length;
		}
		return phone;
	}
		

	public V get(K person)
	{
		// TODO Auto-generated method stub
		try
		{
		int temp = person.hashCode();
		//System.out.println(temp); //
		Entry<K, V> temp1 = hashTable[temp];
		//System.out.println(temp1);
		for(int i = 0; i < hashTable.length; i++)
		{
			//System.out.println("x");
			temp1 = hashTable[temp];
			if(temp1.person.equals(person))
			{
				//System.out.println("x");
				return (V) temp1.pNumber;
			}
			temp++;
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}

	public V remove(K person)
	{
		//System.out.println("WORKS");
				// TODO Auto-generated method stub
				try
				{
					int temp = person.hashCode();
					Entry<K, V> temp1 = hashTable[temp];
					for(int i = 0; i < hashTable.length; i++)
					{
						temp1 = hashTable[temp];
						if(temp1.person.equals(person))
						{
							int temp2 = person.hashCode();
							Entry<K, V> ent = temp1;
							hashTable[temp2] = null;
							return (V) ent.pNumber;
						}
						temp++;
					}
				}
				catch(Exception e)
				{
					
				}
				return null;
	}
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