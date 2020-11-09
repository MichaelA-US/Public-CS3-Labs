
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBookTester {
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scan = new Scanner(new File("White Pages.txt"));
		PhoneBook test = new PhoneBook();

		while (scan.hasNext())
		{
			String[] list = scan.nextLine().split(",");
			test.put(new Person(list[0] + list[1]), new PhoneNumber(list[2]));
			//System.out.println(new Person(list[0] + list[1]).hashCode());
		}
		System.out.println(test);
		
		System.out.println("---HASHCODE TEST---");
		System.out.println(new Person("TiphanieCossor").hashCode());
		System.out.println(new Person("HilliaryYbarra").hashCode());
		System.out.println(new Person("ArdathTizard").hashCode());
		System.out.println(new PhoneNumber("456-499-9393").hashCode());
		System.out.println(new Person("123-459-8798").hashCode());
		System.out.println(new Person("756-643-8365").hashCode());
		System.out.println();
		
		System.out.println("---GET TEST---");
		System.out.println("GET: Ardath Tizard --------> " + test.get(new Person("ArdathTizard"))); //814-623-3296
		System.out.println("GET: Rivy Lamacraft -------> " + test.get(new Person("RivyLamacraft"))); //Rivy,Lamacraft,965-459-1148
		System.out.println("GET: Torrence Wainscoat ---> " + test.get(new Person("TorrenceWainscoat"))); // Torrence,Wainscoat,239-339-4341
		System.out.println("GET: Tiphanie Cossor ------> " + test.get(new Person("TiphanieCossor")));	//Tiphanie,Cossor,776-938-4664															//Tiphanie,Cossor,776-938-4664
		System.out.println("GET: BOB (Doesn't EXIST) --> " + test.get(new Person("Bob")));
		System.out.println();
		
		System.out.println("---REMOVE TEST---");
		System.out.println("GET: Hilliary Ybarra ---------> " + test.get(new Person("HilliaryYbarra")));
		System.out.println("REMOVE: Hilliary Ybarra ------> " + test.remove(new Person("HilliaryYbarra"))); //Hilliary,Ybarra,863-871-1169
		System.out.println("GET: Hilliary Ybarra ---------> " + test.get(new Person("HilliaryYbarra")));
		System.out.println("REMOVE: BOB (Doesn't EXIST) --> " + test.remove(new Person("Bob"))); 
	}
}