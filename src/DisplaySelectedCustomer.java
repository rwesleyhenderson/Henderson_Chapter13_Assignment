/*
 * Robert Henderson
 * 02/21/2021
 * Chapter 13 Assignment
 */

import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

public class DisplaySelectedCustomer
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		Path file = Paths.get("Customers.txt");
		String[] custArr = new String[4];
		String s = "";
		String delimiter = ",";
		String searchId;
		boolean wasFound = false;
		try
		{
			InputStream input = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			System.out.print("Enter ID number to search for >> ");
			searchId = kb.nextLine();
			s = reader.readLine();
			while(s != null)
			{
				custArr = s.split(delimiter);
				if(searchId.equals(custArr[0]))
				{
					wasFound = true;
					for(int x = 0; x < custArr.length; ++x)
					{
						System.out.print(custArr[x] + " ");
					}
					System.out.println();
				}
				s = reader.readLine();
			}
			if(!wasFound)
				{
					System.out.println("No ID found for " + searchId);
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
