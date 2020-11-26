package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
 
    // instantiate BufferedReader object
    BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

    // declare variables
    String strInput;
    int intsum;

    // ask for string input
    System.out.print("Enter a string: ");
    strInput = key.readLine();

    intsum = Utility.sumNumbers(strInput);

    // print the sum
    System.out.println("The sum of the digits in the string is: " + intsum);

  }
}
