/*
 * Robert Henderson
 * 02/21/2021
 * Chapter 13 Assignment
 */

import static java.nio.file.StandardOpenOption.CREATE;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

public class WriteCustomerList
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		Path file = Paths.get("Customers.txt");
		String s = "";
		String delimiter = ",";
		int id;
		String fName;
		String lName;
		double bal;
		final int QUIT = 999;
		try
	      {
	         OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
	         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
	         System.out.print("Enter employee ID number >> ");
	         id = input.nextInt();
	         while(id != QUIT)
	         {
	            System.out.print("Enter first name for employee #" + id + " >> ");
	            input.nextLine();
	            fName = input.nextLine();
	            System.out.print("Enter last name for employee #" + id + " >> ");
	            lName = input.nextLine();
	            System.out.print("Enter balance owed >> ");
	            bal = input.nextDouble();
	            s = id + delimiter + fName + delimiter + lName + delimiter + bal;
	            writer.write(s, 0, s.length());
	            writer.newLine();
	            System.out.print("Enter next ID number or " + QUIT + " to quit >> ");
	            id = input.nextInt();
	         }
	         writer.close();
	      }
	      catch(Exception e)
	      {
	         System.out.println("Message: " + e);
	      }
	      input.close();
	}
}
