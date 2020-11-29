package gr11review.part2;

import gr11review.part2.Utility.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    
    String strLongestWord;
    
    System.out.println(Utility.zipZap("zzipzap"));
    
    strLongestWord = Utility.longestWord("src/gr11review/part2/words.txt");
    System.out.println(strLongestWord);
  }
}