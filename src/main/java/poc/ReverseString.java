package poc;


import java.util.*;

class ReverseString
{
   private static Scanner in;

public static void main(String args[])
   {
	 String original, reverse = "";
      in = new Scanner(System.in);
 
      System.out.println("Enter a string to reverse");
      original = in.nextLine();
 
      int length = original.length();
 
      for ( int i = length - 1 ; i >= 0 ; i-- )
         reverse = reverse + original.charAt(i);
 
      System.out.println("Reverse of entered string is: "+reverse);
   }
}