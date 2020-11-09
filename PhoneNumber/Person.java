
/**
 * This class defines the Person object with a hashcode and equals method
 * @author Michael
 *
 */
public class Person
{
	private String name;
	/**
	 * Basic constructor that initalizes the person with a name
	 * @param name - name of person
	 */
	public Person(String name)
	{
		this.name = name;
	}
	/**
	 * Hashcode that takes the length of the name and modulus by 5
	 */
	@Override
	public int hashCode()
	{
		//Might need to change
		return (name.length()) % 5;
	}
	/**
	 * Compares the given obj to the current Person and checks whether the two
	 * names are equal
	 */
	@Override
	public boolean equals(Object obj)
	{
		Person temp = (Person) obj;
		return(name.equals(temp.name));
	}
	/**
	 * Returns a string representation of the name of
	 * the person
	 */
	@Override
	public String toString()
	{
		return name;
	}
}