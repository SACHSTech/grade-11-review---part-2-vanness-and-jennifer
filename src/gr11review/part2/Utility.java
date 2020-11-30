import java.io.*;

/**
* A program that contains all the methods
* 
* @author: J. Luk
* 
*/
public class Utility {

  /**
  * A program that returns the sum of the numbers appearing in a given string, ignoring all other characters.
  * 
  * @param strInput A string that contatins numbers and letters
  * @return the sum o fthe numbers in strInput
  * @author: J. Luk
  * 
  */
  public static int sumNumbers(String strInput){

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
  * A method that given the name of a file filenametxt that contains a single word on each line, returns the word that is alphabetically first.
  * 
  * @author: J. Luk
  * @param filenametxt the file that contains a list of words
  * @return the alphabetically first word in the list
  * 
  */
  public static String alphaWord(String filenametxt) throws IOException{
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
        if (list[count].compareToIgnoreCase(list[count2]) > 0) {

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
    word = list[0];

    filename.close();
    return word;
  }

  /**
   * A method that returns a version of the given array where every instance of  the given value which is alone is replaced by whichever value to its left or right is larger.
   * 
   * @author: J. Luk 
   * @param nums the array of numbers
   * @param value the value which is alone and needs to be replaced
   * @return the array with the alone value replaced with the larger value on its left or right
   * 
   */
  public static int[] notAlone(int[] nums, int value){

    for (int count = 0; count < nums.length - 1; count++) {

      // check if the number in the array is the given value 
      if (nums[count] == value) {
        if ((count - 1 >= 0 && nums[count - 1] != nums[count]) && nums[count + 1] != nums[count]) {

          // check to see if left or right is larger 
          if (nums[count - 1] > nums[count + 1]) {
            nums[count] = nums[count - 1];
          } else {
            nums[count] = nums[count + 1];
          }
        }
      }
    }
    return nums;
  }  

  /**
  * A method that returns true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
  * 
  * @author: J. Luk
  * @param nums an array of numbers 
  * @return a boolean to classify if there is a split in the array if one side of the array is equal to the other side 
  * 
  */
  public static boolean canBalance(int[] nums){

    // declare variables
    int sum = 0;
    int sum2 = 0;

    for (int count = 0; count < nums.length; count++) {

      // count the sum of the array
      sum = sum + nums[count];
    }
    for (int count = 0; count <= nums.length - 2; count++) {

      // add the numbers that are side by side together
      sum = sum + nums[count];

      // subtract the numbers from the sum of the array
      sum2 = sum2 - nums[count];

      // check if the two sums are equal at each loop
      if (sum == sum2) {

        // return true if the sum on one side is equal to the other
        return true;
      }
    }

    // return false if the sums on both sides are not equal
    return false;
  }

  /**
  * A method that outputs to a text file diagonalOut.txt, a two-dimensional array of size (n×n) populated as follows, with a comma between each number: 
  * The positions on the minor diagonal receive 1
  * The positions above the diagonal receive 0
  * The positions below the diaonal receive 2
  * 
  * @author: J. Luk
  * @param n the number that determined the size of the two dimensional array (nxn) 
  * 
  */
  public static void diagonal(int n) throws IOException{
    PrintWriter theout = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt", true));

    // declare variables
    // set MAX array to be 100, can be changed
    int MAX = 100;
    int[][] mat = new int[MAX][MAX];

    int right = n - 1, left = 0;
    for (int count = 0; count < n; count++) {
      mat[count][right] = 1;

      // fill all the values below diaganol as 2
      for (int count2 = count + 1; count2 < n; count2++) {
        mat[count2][right] = 2;
      }
      right--;

      // fill all the values above diaganol as 0
      for (int count2 = count; count2 < n - 1; count2++) {
        mat[left][count2] = 0;
        left++;
      }
      left = left + 1;

    }
    for (int count = 0; count < n; count++) {
      for (int count2 = 0; count2 < n; count2++) {
        theout.print((mat[count][count2]));
        if (count2 != n - 1) {
          theout.print(", ");
        }
      }
      theout.println();
    }
  theout.close();
  }

}
