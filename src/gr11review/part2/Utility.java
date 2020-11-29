package gr11review.part2;

import java.io.*;
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
}