package gr11review.part2;

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
  public static String alphaWord(String filenametxt) {
    int n = 0;
    String word;
    int count;
    String temp = "";
    String[] list = new String[1000];

    while (filenametxt.eof() == false) {
      word = filenametxt.readLine();
      list[count] = word;
      count++;
      n++; 
    }
    

    for (count = 0; count < n; count++) {
      for (int j = count + 1; j < n; j++) {
        if (list[count].compareTo(list[j]) > 0) {
          temp = list[count];
          list[count] = list[j];
          list[j] = temp;
        }
      }
    }
    System.out.print("Names in Sorted Order:");
    for (count = 0; count < n - 1; count++) {
      System.out.print(list[count] + ",");
    }
    System.out.print(list[n - 1]);
    filenametxt.close();

  }
}
