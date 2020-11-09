/**
 * This class initalizes the phone number object and defines its equal
 * method and hashcode
 * @author Michael
 *
 */
public class PhoneNumber
{
	private String pNumber;
	/**
	 * Basic constructor that initalizes the phone number string
	 * @param pNumber - the string phone number
	 */
	public PhoneNumber(String pNumber)
	{
		this.pNumber = pNumber;
	}
	/**
	 * This method defines the equals method by comparing the object's phone number to
	 * the current phone number
	 */
	@Override
	public boolean equals(Object obj)
	{
			PhoneNumber temp = (PhoneNumber) obj;
			return pNumber.equals(temp.pNumber);
	}
	/**
	 * This method defines the hashCode of the phone number by modulus it by 5
	 */
	@Override
	public int hashCode()
	{
		//Might need to change
		return pNumber.length() % 5;
	}
	/**
	 * Returns the phonenumber as a string
	 */
	@Override
	public String toString()
	{
		return "" + pNumber;
	}
}