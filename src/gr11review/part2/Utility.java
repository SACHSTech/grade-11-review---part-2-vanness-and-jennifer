package gr11review.part2;

public class Utility{

  public static int sumNumbers(String str) {

    // declare variables
    int numbersum = 0;
    
    // 
    for (int i = 0; i < str.length(); i++) {
      if (Character.isDigit(str.charAt(i))) {
        int count = 0; 
        for (count = i+1; count < str.length() && Character.isDigit(str.charAt(count)); count++) { 
          if (Character.isDigit(str.charAt(count))) {
            count++;
          }else {
            break;
          }
          numbersum = numbersum + Integer.parseInt(str.substring(i, count));
          i = count;
        }
      }
    }
    return numbersum; 

  }
}