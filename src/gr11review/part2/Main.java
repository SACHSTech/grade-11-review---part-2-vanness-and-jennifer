package gr11review.part2;

import java.io.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
 
    // Method 2
    // declare variables
    String str = "abc123xyz";
    int intsum;

    intsum = Utility.sumNumbers(str);
    
    // print the sum
    System.out.println("The sum of the digits in the string is: " + intsum);

    // FileIO 2
    String Output = Utility.alphaWord("src/gr11review/part2/words.txt");

    // print results 
    System.out.println("The word that is alphabetically first is " +Output);

    // Arrays 2
    // int[] nums = {1, 2, 3, 2, 5, 2}; 
    // int value = 2;
    // System.out.println(notAlone(nums, value));
    
    // //Arrays 4
    int[] list = {1, 1, 1, 2, 1};
    // System.out.println(Utility.canBalance(list[]));
    if (canBalance(list[]) == true){
      System.out.println("true");
    }

    // Arrays 6 
    int n = 4; 
    int MAX = 100; 
    int[][] mat = new int[MAX][MAX];

    Utility.diagonal(n);
    
    
  }
}
