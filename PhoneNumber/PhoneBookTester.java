
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class implements multiple Test Cases to test the PhoneBook class
 * tests include: the PUT method - which places the new Person, the GET method -
 * which finds the location of such person and returns their phoneNumber, and the
 * REMOVE method - that removes the existing person. I also test the HashCode to make
 * sure that it is returning with guaranteed collisions.
 * @author Michael Ades
 *
 */
public class PhoneBookTester {
	public static void main(String[] args) throws FileNotFoundException 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(new File("White Pages.txt"));
		PhoneBook test = new PhoneBook();
		System.out.println("--------------PUT TEST------------------");
		System.out.println("Putting All Entries From White Pages.txt");
		System.out.println("-----------------------------------------");
		while (scan.hasNext())
		{
			String[] list = scan.nextLine().split(",");
			test.put(new Person(list[0] + list[1]), new PhoneNumber(list[2]));
			//System.out.println(new Person(list[0] + list[1]));
		}
		System.out.println("PRINTING ONLY FIRST 5 IN PHONEBOOK DUE TO CHAR LIMIT\n");
		System.out.println(test);
		
		
		//System.out.println(test.put(new Person("ArdashTizard"), new PhoneNumber("814-623-3296"))); //
		
		
		System.out.println("---HASHCODE TEST---");
		System.out.println("| People HashCode |");
		System.out.println("-------------------");
		System.out.println("HASHCODE: TiphanieCossor (PRINT: 0) --> " + new Person("TiphanieCossor").hashCode());
		System.out.println("HASHCODE: OrvilleRehn    (PRINT: 2) --> " +new Person("OrvilleRehn").hashCode());
		System.out.println("HASHCODE: AngeloGaskal   (PRINT: 5) --> " +new Person("AngeloGaskal").hashCode());
		System.out.println("HASHCODE: ArdathTizard   (PRINT: 5) --> " +new Person("ArdathTizard").hashCode());
		System.out.println("\n------HASHCODE TEST-----");
		System.out.println("| PhoneNumber HashCode |");
		System.out.println("------------------------");
		System.out.println("HASHCODE: 456-499-9393   (PRINT: 4) --> " +new PhoneNumber("456-499-9393").hashCode());
		System.out.println("HASHCODE: 756-643-8365   (PRINT: 7) --> " +new PhoneNumber("756-643-8365").hashCode());
		System.out.println("HASHCODE: 756-643-8365   (PRINT: 7) --> " +  new PhoneNumber("756-643-8365").hashCode());
		
		System.out.println();
		
		System.out.println("------GET TEST-----");
		System.out.println("Test Existing Users");
		System.out.println("-------------------");
		System.out.println("GET: Ardath Tizard      (PRINT: 814-623-3296) ------> " + test.get(new Person("ArdathTizard"))); //814-623-3296
		System.out.println("GET: Rivy Lamacraft     (PRINT: 965-459-1148) ------> " + test.get(new Person("RivyLamacraft"))); //Rivy,Lamacraft,965-459-1148
		System.out.println("GET: Torrence Wainscoat (PRINT: 239-339-4341) ------> " + test.get(new Person("TorrenceWainscoat"))); // Torrence,Wainscoat,239-339-4341
		System.out.println("GET: Tiphanie Cossor    (PRINT: 776-938-4664) ------> " + test.get(new Person("TiphanieCossor")));	//Tiphanie,Cossor,776-938-4664	
		System.out.println("\n------GET TEST--------");
		System.out.println("Test NonExisting Users");
		System.out.println("----------------------");
		System.out.println("GET: BOB       (Doesn't EXIST) --> " + test.get(new Person("Bob")));
		System.out.println("GET: JeffBezos (Doesn't EXIST) --> " + test.get(new Person("JeffBezos")));
		System.out.println("GET: Stites    (Doesn't EXIST) --> " + test.get(new Person("Stites")));
		System.out.println();
		
		System.out.println("----REMOVE TEST----");
		System.out.println("Test Existing Users");
		System.out.println("-------------------");
		System.out.println("GET: Hilliary Ybarra    (PRINT: 863-871-1169)  --------> " + test.get(new Person("HilliaryYbarra")));
		System.out.println("REMOVE: Hilliary Ybarra (PRINT: 863-871-1169)  --------> " + test.remove(new Person("HilliaryYbarra"))); //Hilliary,Ybarra,863-871-1169
		System.out.println("GET: Hilliary Ybarra    (PRINT: DOESN'T EXIST) --------> " + test.get(new Person("HilliaryYbarra")));
		System.out.println("GET: Talia Keggin       (PRINT: 724-628-1473)  --------> " + test.get(new Person("TaliaKeggin")));
		System.out.println("REMOVE: Talia Keggin    (PRINT: 724-628-1473)  --------> " + test.remove(new Person("TaliaKeggin"))); //Talia,Keggin,724-628-1473
		System.out.println("GET: Talia Keggin       (PRINT: DOESN'T EXIST) --------> " + test.get(new Person("TaliaKeggin")));
		System.out.println("\n------REMOVE TEST-----");
		System.out.println("Test NonExisting Users");
		System.out.println("----------------------");
		System.out.println("REMOVE: BOB       (Doesn't EXIST) --> " + test.remove(new Person("Bob"))); 
		System.out.println("REMOVE: JeffBezos (Doesn't EXIST) --> " + test.remove(new Person("JeffBezos")));
		System.out.println("REMOVE: Stites    (Doesn't EXIST) --> " + test.remove(new Person("Stites")));
	}
}