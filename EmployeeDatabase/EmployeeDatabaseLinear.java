
/**
 * Class that implements a closed hash of linear probing
 * @author Michael
 *
 */
public class EmployeeDatabaseLinear
{	
	/**
	 * Entry class that initalizes the employee and their ID
	 * @author Michael
	 *
	 */
	class Entry
	{
		private int ID;
		private Employee employee;
		public Entry(int ID, Employee employee)
		{
			this.ID = ID;
			this.employee = employee;
		}
		@Override
		public String toString()
		{
			return "" + ID + "-" + employee.toString();
		}
	}

	private Entry[] hashTable;
	private int getCollide;
	private int size;
	private int numCollide;
	/**
	 * Basic constructor that initalizes hashTable with prime number 13 to avoid problems
	 * and initalizes the other vars
	 */
	public EmployeeDatabaseLinear()
	{
		hashTable = new Entry[13];
		getCollide = 0;
		size = 0;
		numCollide = 0;
	}
	/**
	 * Secondary constructor that sets the hashtable size and initalizes other values
	 * @param size
	 */
	public EmployeeDatabaseLinear(int size)
	{
		hashTable = new Entry[size];
		getCollide = 0;
		this.size = size;
		numCollide = 0;
	}
	/**
	 * Hashcode that I just did randomly 
	 * @param key - the key given to get hashCode
	 * @return the hashcode
	 */
	public int hashCode(int key)
	{
		return  (key * key + key) % hashTable.length;
	}
	/**
	 * puts the actual employee into the linear probing hashtable
	 * @param key - the key
	 * @param value - the val
	 * @return the employee
	 */
	public Employee put(int key, String value)
	{
		Employee employee = new Employee(value);
		int temp = hashCode(key);
		for(int i = 0; i < hashTable.length; i++)
		{
			if(hashTable[temp] == null)
			{
				Entry tempEnt = new Entry(key, employee); 
				hashTable[temp] = tempEnt;
				size++;
				return employee;
			}
			else
			{
				numCollide++;
			}
			temp = (temp + 1) % hashTable.length;
		}
		return employee;
	}
	/**
	 * gets the actual employee when given the key by checking its hashcode
	 * and trying to retrieve the employee name through its ID
	 * @param key
	 * @return
	 */
	public Employee get(int key)
	{
		int temp = hashCode(key);
		for(int i = 0; i < hashTable.length; i++)
		{
			if(hashTable[temp] == null)
			{
				break;
			}
			else if(hashTable[temp].ID == key)
			{
				return hashTable[temp].employee;
			}
			temp = (temp + 1) % hashTable.length;
		}
		return null;
	}
	/**
	 * Basic toString that prints out the hashTable
	 */
	@Override 
	public String toString()
	{
		String output = "";
		for(Entry ent: hashTable)
		{
			output += ent + "\n";
		}
		return output;
	}
}

