package gr11review.part2;

public class Utility {
    
public static String zipZap(String strWord){
  int intLength;
  int intCount;
  String strNoMiddle;
  String strPFind;
  String strCharacter;
  String strMiddleFind; 
  
  intLength = strWord.length();

  strNoMiddle = "";

  for(intCount = 0; intCount < (intLength); intCount++){
    //System.out.println(intCount);
    strCharacter = strWord.substring(intCount, intCount+1);
    if(intLength - 2 <= intCount){
      strNoMiddle = strNoMiddle + strCharacter;
    }else{
      strPFind = strWord.substring(intCount+2, intCount+3);
      strMiddleFind = strWord.substring(intCount+1, intCount+2);
      if(!strCharacter.equalsIgnoreCase("Z")){
        strNoMiddle = strNoMiddle + strCharacter;
      }else if(strCharacter.equalsIgnoreCase("Z") &&  !strPFind.equalsIgnoreCase("P")){
        strNoMiddle = strNoMiddle + strCharacter;
      }else if(strCharacter.equalsIgnoreCase("Z") && strPFind.equalsIgnoreCase("P")){
        //strMiddleFind = " ";
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
}
