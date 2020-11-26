package gr11review.part2;

public class Utility {

/**
* A program that returns the sum of the numbers appearing in a given string, ignoring all other characters.  
*  @author: J. Luk
* 
*/
  public static int sumNumbers(String strInput) {

    // declare variables
    int numbersum = 0;
    String temp = "";

    // read each character in input string
    for (int i = 0; i < strInput.length(); i++) {

      // check if character is a digit
      if (Character.isDigit(strInput.charAt(i))) {

        if (i < strInput.length() - 1 && Character.isDigit(strInput.charAt(i + 1))) {
          temp += strInput.charAt(i);
        }
        else {
          temp += strInput.charAt(i);
          numbersum += Integer.parseInt(temp);
          temp = "";
        }
      }
    }
    return numbersum;

  }
}
