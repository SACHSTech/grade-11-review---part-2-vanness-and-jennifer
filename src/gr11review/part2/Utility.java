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
  int intLength;
  int intCount;
  String strNoMiddle;
  String strPFind;
  String strCharacter;
  //String strMiddleFind; 
  
  intLength = strWord.length();

  strNoMiddle = "";

  for(intCount = 0; intCount < (intLength); intCount++){
    //System.out.println(intCount);
    strCharacter = strWord.substring(intCount, intCount+1);
    if(intLength - 2 <= intCount){
      strNoMiddle = strNoMiddle + strCharacter;
    }else{
      strPFind = strWord.substring(intCount+2, intCount+3);
      //strMiddleFind = strWord.substring(intCount+1, intCount+2);
      if(!strCharacter.equalsIgnoreCase("Z")){
        strNoMiddle = strNoMiddle + strCharacter;
      }else if(strCharacter.equalsIgnoreCase("Z") &&  !strPFind.equalsIgnoreCase("P")){
        strNoMiddle = strNoMiddle + strCharacter;
      }else if(strCharacter.equalsIgnoreCase("Z") && strPFind.equalsIgnoreCase("P")){
        strNoMiddle = strNoMiddle + strCharacter + strPFind;
        if(intLength - 2 <= intCount){
        }else{
          intCount = intCount + 2;
        } 
        //System.out.println(strNoMiddle);
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

  String strWord;
  String strNextWord;
  int intWordLength;
  int intNextWordLength; 

  strWord = filename.readLine();
  strNextWord = filename.readLine();
    
  while(strNextWord != null){
    intWordLength = strWord.length();
    intNextWordLength = strNextWord.length();
    if(intNextWordLength >= intWordLength){
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
    
  int intCount; 
  int intModulus;
  int intModulus2;

  for(intCount = 0; intCount < nums.length-1; intCount++){
    intModulus = nums[intCount] % 10;
    intModulus2 = nums[intCount+1] % 10;
    if(intModulus == 0 && intModulus2 != 0){
      nums[intCount+1] = nums[intCount];
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
public boolean linearIn(int[] outer, int[] inner){

  int intCount;
  int intCounter;
  int intMatches;
  Boolean blnCheck = true;
  Boolean blnResult = true;

  intMatches = 0;

  for(intCount = 0; intCount < inner.length; intCount++){
    intCounter = 0;
    blnCheck = true;
    while(blnCheck == true){
      if(inner[intCount] == outer[intCounter]){
        intMatches = intMatches + 1;
        blnCheck = false;
      }else if(inner[intCount] != outer[intCounter]){
        intCounter = intCounter + 1;
        if(intCounter > inner.length){
          blnCheck = false;
          blnResult = false; 
        }
      }
    }
  if(intMatches == inner.length){
    blnResult = true;
  }else if(intMatches != inner.length){
    blnResult = false;
  }
  }
  return blnResult;
}
}