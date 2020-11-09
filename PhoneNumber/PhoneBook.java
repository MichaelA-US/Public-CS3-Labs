
public class PhoneBook implements IMap
{
	class Entry
	{
		Person person;
		PhoneNumber pNumber;
		Entry next;
		public Entry(Person person, PhoneNumber pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
		}
		@Override
		public String toString()
		{
			return "" + person.toString() + ": " + pNumber.toString();
		}
	}
	private Entry[] hashTable;
	public static int size;
	public PhoneBook()
	{
		size = 0;
		hashTable = new Entry[5001];
	}
	public PhoneBook(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
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

	@Override
	public PhoneNumber get(Person person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry temp1 = hashTable[temp];
		while(temp1 != null)
		{
			if(temp1.person.equals(person))
			{
				return temp1.pNumber;
			}
			temp1 = temp1.next;
		}
		return null;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public PhoneNumber remove(Person person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry temp1 = hashTable[temp];
		if(temp1.equals(person))
		{
			PhoneNumber back = temp1.pNumber;
			hashTable[temp] = temp1.next;
			size--;
			return back;
		}

		else
		{
			if(temp1.next.equals(person))
			{
				PhoneNumber back = temp1.pNumber;
				hashTable[temp] = temp1.next;
				size--;
				return back;
			}
		}
		return remove(person);
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
