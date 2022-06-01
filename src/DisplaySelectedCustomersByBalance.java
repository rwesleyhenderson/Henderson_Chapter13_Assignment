/*
 * Robert Henderson
 * 02/21/2021
 * Chapter 13 Assignment
 */

import java.nio.file.*;
import java.io.*;
import java.util.Scanner;
public class DisplaySelectedCustomersByBalance
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      Path file = Paths.get("Customers.txt");
      String[] custArr = new String[4];
      String s = "";
      String delimiter = ",";
      double balance;
      boolean wasFound = false;
      final int BAL_POS = 3;
      try
      {
         InputStream input = new BufferedInputStream(Files.newInputStream(file));
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
     
         System.out.print("Enter minimum balance >> ");
         balance = kb.nextDouble();
         s = reader.readLine();
         while(s != null)
         {
        	custArr = s.split(delimiter);
            double custBal = Double.parseDouble(custArr[BAL_POS]);
            if(custBal >= balance)
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
           System.out.println("No IDs found with a balance of at least $" + balance);
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