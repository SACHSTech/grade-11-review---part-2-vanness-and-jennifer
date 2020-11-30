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
