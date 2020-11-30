import java.util.Arrays.*;
/**
* A program that conatins all the methods
* @author: V. Yang
*
*/
public class Utility {

/**
* A method that for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. 
* @param strWord The word that will be analyzed to see if it has sections that beging with "z" and end with "p" and will have the middle letter of that section taken out 
* @return The word without the middle letter of each section of the word that begins with "z" and ends with "p"
* @author V. Yang
*/
public static String zipZap(String strWord){
  
  // Variables
  int intLength;
  int intCount;
  String strNoMiddle;
  String strPFind;
  String strCharacter;
  
  // Getting the length of the input 
  intLength = strWord.length();

  // Initializing variables
  strNoMiddle = "";

  // for loop runs until the end of the word is reached 
  for (intCount = 0; intCount < (intLength); intCount++) {
    // Grabbing each individual letter of the word
    strCharacter = strWord.substring(intCount, intCount + 1);
    // if statement to prevent intCount from going over the word length 
    if (intLength - 2 <= intCount) {
      strNoMiddle = strNoMiddle + strCharacter;
    }else{
      strPFind = strWord.substring(intCount + 2, intCount + 3);
      if (!strCharacter.equalsIgnoreCase("Z")) {
        strNoMiddle = strNoMiddle + strCharacter;
      }else if (strCharacter.equalsIgnoreCase("Z") && !strPFind.equalsIgnoreCase("P")) {
        strNoMiddle = strNoMiddle + strCharacter;
      // Runs if the character is equal to z and the next letter is equal to p 
      }else if (strCharacter.equalsIgnoreCase("Z") && strPFind.equalsIgnoreCase("P")) {
        // Takes out the middle letter
        strNoMiddle = strNoMiddle + strCharacter + strPFind;
        if (intLength - 2 <= intCount) {
        }else{
          // Moves onto the next section of the word 
          intCount = intCount + 2;
        } 
      }
    }
  }
  return strNoMiddle; 
}

/**
* A method such that given the name of a file filenametxt that contains a single word on each line, returns the longest word in the file.
* @param filenametxt The file that will contain the list of words 
* @return The longest word
* @author V. Yang
*/
public static String longestWord(String filenametxt) throws IOException{
  BufferedReader filename = new BufferedReader(new FileReader(filenametxt));

  // Variables 
  String strWord;
  String strNextWord;
  int intWordLength;
  int intNextWordLength; 

  // Reading from the file and inputting into the variables
  strWord = filename.readLine();
  strNextWord = filename.readLine();
    
  // Runs until the variable equals nothing 
  while (strNextWord != null) {
    // Getting the lengths of the words
    intWordLength = strWord.length();
    intNextWordLength = strNextWord.length();
    // Comparing the lengths of the words
    if (intNextWordLength >= intWordLength) {
      strWord = strNextWord; 
    }
    strNextWord = filename.readLine();
  }
  filename.close();

  return strWord;
}

/**
* A method that for each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10. 
* @param nums The array that will store all the values 
* @return The changed values so they will all be multiples of 10 
* @author V. Yang
*/
public static int[] tenRun(int[] nums){
    
  // Variables  
  int intCount; 
  int intModulus;
  int intModulus2;

  // for loops runs until the length of the array subtract 1 is reached 
  for (intCount = 0; intCount < nums.length - 1; intCount++) {
    // Getting the modulus of the values in the array 
    intModulus = nums[intCount] % 10;
    intModulus2 = nums[intCount + 1] % 10;
    // If the modulus is 0, the value is a mutliple of 10 
    if(intModulus == 0 && intModulus2 != 0){
      nums[intCount + 1] = nums[intCount];
    }
  }
  
  return nums;
}

/**
* A method that given two arrays of ints sorted in increasing order, outer and inner.
* @param outer The outer values 
* @param inner The inner values 
* @return The result. True if all of the numbers in inner appear in outer.
* @author V. Yang
*/
public static boolean linearIn(int[] outer, int[] inner){

  // Variables
  int intCount;
  int intCounter;
  int intMatches;
  Boolean blnCheck = true;
  Boolean blnResult = true;

  // Initializing variables
  intMatches = 0;

  // for loop that runs until the length of the inner set of values is reached 
  for (intCount = 0; intCount < inner.length; intCount++) {
    // Re-initializing variables 
    intCounter = 0;
    blnCheck = true;
    // while loop runs until the blnCheck is true 
    while (blnCheck == true) {
      // If the inner value matches the outer value 
      if (inner[intCount] == outer[intCounter]) {
        intMatches = intMatches + 1;
        // Exits the while loop 
        blnCheck = false;
      // If the inner value does not match the outer value 
      }else if (inner[intCount] != outer[intCounter]) {
        intCounter = intCounter + 1;
        // If the end of the word is reached and there are no matches
        if (intCounter > inner.length) {
          // Exits the while loop 
          blnCheck = false;
          blnResult = false; 
        }
      }
    }
  }

  // Checking to see if the result is true or false
  if (intMatches == inner.length) {
    blnResult = true;
  }else if (intMatches != inner.length) {
    blnResult = false;
  }
  
  return blnResult;
}

/**
* A method that outputs to a text file pascalOut.txt, a comma separted table containing i rows and j columns of pascal's triangle. 
* @param i The rows of the array 
* @param j The columns of the array 
* @author V. Yang
*/
public static void pascalTri(int i, int j) throws IOException{ 
  // Setting up the pascalOut.txt file 
  PrintWriter pascalOut = new PrintWriter(new FileWriter("src/gr11review/part2/pascalOut.txt"));

  // Variables
  int[][] intPascal = new int[i][j];
  int intCount;
  int intCount2;

  // Setting up the 2-dimensional array 
  for (intCount = 0; intCount < i; intCount++) {
    for (intCount2 = 0; intCount2 < j; intCount2++) {
      // Setting up the first column to equal 1
      if (intCount2 == 0) {
        intPascal[intCount][intCount2] = 1;
      // Setting up the first row to equal 1
      }else if (intCount == 0) {
        intPascal[intCount][intCount2] = 1;
      // Setting up the rest of the pascal triangle 
      }else{
        intPascal[intCount][intCount2] = intPascal[intCount - 1][intCount2]+ intPascal[intCount][intCount2 - 1];
      }
      // Printing out the results to the pascalOut.txt file 
      if (intCount2 == j - 1) {
        // No comma at the end of the number 
        pascalOut.print(intPascal[intCount][intCount2]);
      }else{
        // Commas and space to separate the numbers
        pascalOut.print(intPascal[intCount][intCount2] + ", ");
      }
    }
    pascalOut.println("");
  }
  pascalOut.close();
}
=======

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