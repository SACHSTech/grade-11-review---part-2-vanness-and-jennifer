package gr11review.part2;

import java.io.*;

public class Utility {

  /**
   * A program that returns the sum of the numbers appearing in a given string,
   * ignoring all other characters.
   * 
   * @author: J. Luk
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
        } else {
          temp += strInput.charAt(i);
          numbersum += Integer.parseInt(temp);
          temp = "";
        }
      }
    }
    return numbersum;
  }

  /**
   * A method that given the name of a file filenametxt that contains a single
   * word on each line, returns the word that is alphabetically first.
   * 
   * @author: J. Luk
   * 
   */
  public static String alphaWord(String filenametxt) throws IOException {
    BufferedReader filename = new BufferedReader(new FileReader(filenametxt));

    // declare variables 
    int numlines = 0;
    int count;
    String temp;

    String word = filename.readLine();
    
    // count the number of lines 
    while (word != null) {
      word = filename.readLine();
      numlines++;
    }

    String[] list = new String[numlines];

    filename.close();
    filename = new BufferedReader(new FileReader(filenametxt));

    // set each line into the string array
    for (count = 0; count < numlines; count++) {
      word = filename.readLine();
      list[count] = word;
    }
    
    for (count = 0; count < numlines; count++) {
      for (int count2 = count + 1; count2 < numlines; count2++) {

        // compare the lines to see if swapping is needed
        if (list[count].compareTo(list[count2]) > 0) {

          // store the first element in a temporary element
          temp = list[count];

          // replace the first element by the second element
          list[count] = list[count2];

          // replace the second element by the temporary element
          list[count2] = temp;
        }
      }
    }

    // set the string as the top word after sorting
    word = list[1];

    filename.close();
    return word;
  }

}
