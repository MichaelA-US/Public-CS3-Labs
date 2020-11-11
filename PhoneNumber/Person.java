
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
	 * Hashcode that takes the character of the name and modulus it by the length of the name and modulus that by 11 to have
	 * only 11 chains.
	 * @return the hashcode of the Person - name.charAt(0) % (name.length()) % 11
	 */
	@Override
	public int hashCode()
	{
		//Might need to change
		return name.charAt(0) % (name.length()) % 11;
	}
	/**
	 * Compares the given obj to the current Person and checks whether the two
	 * names are equal
	 * @param the object to check if it's equal
	 * @return whether the two names are equal of the object (true/false)
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
	 * @return the name of the person
	 */
	@Override
	public String toString()
	{
		return name;
	}
}