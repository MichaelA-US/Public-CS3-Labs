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
	 * @param obj - the Object to compare whether it is equal to the PhoneNumber
	 * @return whether the object is equal to the PhoneNumber (true/false)
	 */
	@Override
	public boolean equals(Object obj)
	{
			PhoneNumber temp = (PhoneNumber) obj;
			return pNumber.equals(temp.pNumber);
	}
	/**
	 * This method defines the hashcode of the phoneNumber by taking the first
	 * char of the phoneNumber and modulusly dividing it by the length and modulus that by 11 to make sure
	 * it stays within the 11 buckets.
	 * @return the hashcode of the phoneNumber -  pNumber.charAt(0) % pNumber.length() % 11
	 */
	@Override
	public int hashCode()
	{
		//Might need to change
		return pNumber.charAt(0) % pNumber.length() % 11;
	}
	/**
	 * Returns the phonenumber as a string
	 * @return the phonenumber of the PhoneNumber object
	 */
	@Override
	public String toString()
	{
		return "" + pNumber;
	}
}