import java.util.ArrayList;

public class Disk implements Comparable<Disk> 
{
	private int totalSizeGigs;
	private int numDisks;					
	private int usedSize;
	private Integer remSizeKB;	
	private ArrayList<Integer> files;
	public Disk()
	{
		totalSizeGigs = 0;
		numDisks = 0;
		usedSize = 1000000;
		remSizeKB = 1000000;
		files = new ArrayList<Integer>();
		
	}
	public Disk(int diskNum) 
	{
		totalSizeGigs = 0;
		remSizeKB = 1000000;
		files = new ArrayList<Integer>();
		numDisks = diskNum;
		usedSize = 1000000 - remSizeKB;
	}
	public boolean newDisk(Integer capacity)
	{
		return remSizeKB - capacity >= 0;
	}
	public int add(Integer other) 
	{
		files.add(other);
		remSizeKB -= other;
		usedSize = 1000000 - remSizeKB;
		totalSizeGigs += other;
		return remSizeKB;
	}
	public double getSizeGig()
	{
		return (double) totalSizeGigs / 1000000;
	}
	public int getRemSize()
	{
		return remSizeKB;
	}
	public int getUsedSize() 
	{
		return usedSize;
	}
	@Override
	public boolean equals(Object other)
	{
		return remSizeKB.equals(((Disk) other).remSizeKB);
	}
	@Override
	public int compareTo(Disk obj)
	{
		if(remSizeKB == obj.remSizeKB)
		{
			return 0;
		}
		else if (remSizeKB > obj.remSizeKB)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	@Override
	public String toString () 
	{
		String output = "";
		output += numDisks + " " + remSizeKB + ": ";
		for(Integer file : files)
		{
			output += file + " ";
		}
		return output;
	}
}
