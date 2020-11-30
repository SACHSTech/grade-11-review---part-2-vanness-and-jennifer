
import gr11review.part2.Utility.*;
import java.io.*;
import java.util.Arrays;

/**
* A program that tests all the methods.
* @author: V. Yang
*
*/
public class Main{
  public static void main(String[] args) throws IOException{
    
    // Testing Methods 1 
    String strLongestWord;

    System.out.println(Utility.zipZap("zzipzap"));
    
    // Testing FileIO 1
    strLongestWord = Utility.longestWord("src/gr11review/part2/words.txt");

    System.out.println(strLongestWord);

    // Testing Arrays 1 
    int[] intNums = {1, 10, 2, 20, 30, 40};
    intNums = Utility.tenRun(intNums);

    System.out.println(Arrays.toString(intNums));
  
    // Testing Arrays 3
    int[] intOuter = {1, 2, 4, 4, 6};
    int[] intInner = {2, 4};

    System.out.println(Utility.linearIn(intOuter, intInner));

    // Testing Arrays 5 
    Utility.pascalTri(4, 5);
  }
}
=======
import java.io.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException{
 
    // Testing Method 2
    // declare variables
    String str = "abc123xyz";
    int intsum;

    intsum = Utility.sumNumbers(str);
    
    // print the sum
    System.out.println("The sum of the digits in the string is: " + intsum);

    // Testing FileIO 2
    String Output = Utility.alphaWord("src/gr11review/part2/words.txt");

    // print results 
    System.out.println("The word that is alphabetically first is " +Output);

    // Testing Arrays 2
    int[] nums = {1, 2, 3, 2, 5, 2}; 
    int value = 2;

    Utility array2 = new Utility();
    System.out.println(java.util.Arrays.toString(array2.notAlone(nums, value)));
    
    // Testing Arrays 4
    int[] list = {1, 1, 1, 2, 1};

    Utility array4 = new Utility();
    System.out.println(array4.canBalance(list));

    // Testing Arrays 6 
    int n = 9; 
    int MAX = 100; 
    int[][] mat = new int[MAX][MAX];

    Utility.diagonal(n);
    
    
  }
}
