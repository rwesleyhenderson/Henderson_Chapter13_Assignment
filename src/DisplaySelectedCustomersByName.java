/*
 * Robert Henderson
 * 02/21/2021
 * Chapter 13 Assignment
 */

import java.nio.file.*;
import java.io.*;
import java.util.Scanner;
public class DisplaySelectedCustomersByName
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		Path file = Paths.get("Customers.txt");
		String[] custArr = new String[4];
		String s = "";
		String delimiter = ",";
		String searchName;
		boolean wasFound = false;
		final int LAST_NAME_POS = 2;
	    final String HEADER_FORMAT = "%1$-5s%2$-15s%3$-12s%4$-7s%5$-10s%6$-7s\n"; 
	    final String CUSTOMER_RECORDS_FORMAT = "%1$-5s%2$-15s%3$-12s%4$";
		try
		{
			InputStream input = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));        

			System.out.print("Enter last name to search for >> ");
			searchName = kb.nextLine();
			s = reader.readLine();
			while(s != null)
			{
				custArr = s.split(delimiter);
				if(searchName.equalsIgnoreCase(custArr[LAST_NAME_POS]))
				{
					wasFound = true;
					for(int x = 0; x < custArr.length; ++x)
						{
							System.out.print(custArr[x] + "  ");
						}
					System.out.println();
				}
				s = reader.readLine();           
			}
			if(!wasFound)
			{
				System.out.println("No ID found for " + searchName);
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("Message: " + e);
		}
		kb.close();
	}
}