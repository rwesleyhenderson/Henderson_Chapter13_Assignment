/*
 * Robert Henderson
 * 02/21/2021
 * Chapter 13 Assignment
 */

import java.nio.file.*;
import java.io.*;
public class DisplaySavedCustomerList
{
   public static void main(String[] args)
   {
	   Path file = Paths.get("Customers.txt");
	   String s = "";
	   try
	   {
		   InputStream input = new BufferedInputStream(Files.newInputStream(file));
		   BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		   s = reader.readLine();
		   while(s != null)
		   {
			   System.out.println(s);
			   s = reader.readLine();           
		   }
		   reader.close();
	   }
	   catch(Exception e)
	   {
		   System.out.println("Message: " + e);
	   }
   }
}