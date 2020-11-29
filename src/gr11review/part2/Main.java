package gr11review.part2;

import gr11review.part2.Utility.*;
import java.io.*;
import java.util.Arrays;

public class Main{
  public static void main(String[] args) throws IOException{
    
    String strLongestWord;
    
    System.out.println(Utility.zipZap("zzipzap"));
    
    strLongestWord = Utility.longestWord("src/gr11review/part2/words.txt");
    System.out.println(strLongestWord);

    int[] intNums = {1, 10, 2, 20, 30, 40};
    intNums = Utility.tenRun(intNums);
    System.out.println(Arrays.toString(intNums));
  
    int[] intOuter = {1, 2, 4, 4, 6};
    int[] intInner = {2, 4};
    Utility array3 = new Utility();
    System.out.println(array3.linearIn(intOuter, intInner));
  }
}