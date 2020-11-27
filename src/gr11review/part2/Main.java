package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
 
    // Method 2
    // declare variables
    String str = "abc123xyz";
    String strOutput; 
    int intsum;

    intsum = Utility.sumNumbers(str);

    // print the sum
    System.out.println("The sum of the digits in the string is: " + intsum);

    // FileIO 2
    // declare variables
    
    strOutput = Utility.alphaWord("src/gr11review/part2/words.txt");

    System.out.println("this is the word: "+strOutput);


  }
}
