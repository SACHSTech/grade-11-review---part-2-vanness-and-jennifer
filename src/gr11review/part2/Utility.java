package gr11review.part2;

/**
* A program that conatins all the methods
* @author: V. Yang
*
*/
public class Utility {

/**
* A method that for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone.
*
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

  public static String longestWord(String filenametxt){
    BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));

    int intLines;
    int intCount;
    int intLength1;
    int intLength2;
    String strBigWord;
    String strSmallWord;
    String strWord;

    intLines = 0;

    while(thefile != null){
      strWord = thefile.readLine();
      intLines = intLines + 1;
    }
    thefile.close();

    String strWords[];
    strWords = new String[intLines];

    thefile = new BufferedReader(new FileReader(filenametxt));

    for(intCount = 0; intCount < intLines; intCount++){
      strWord = thefile.readLine();
      strWords[intCount] = strWord;
    }
    
    strBigWord = "";
    strSmallWord = "";
    for(intCount = 0; intCount < intLines; intCount++){
      intLength1 = strWords[intCount].length();
      intLength2 = strWords[intCount+1].length();
      if(intLength1 > intLength2){
        strBigWord = strWords[intCount];
        strSmallWord = strWords[intCount+1];
      }else if(intLength1 < intLength2){
        strBigWord = strWords[intCount+1];
        strSmallWord = strWords[intCount];
      }
    }
    thefile.close();
    return(strBigWord);
  }
}
