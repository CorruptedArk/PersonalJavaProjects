/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passwordgenerator;

import java.util.Random;
/**
 *
 * @author Noah
 */
public class RandomString {
    
    private static final char[] symbols;
    private final int length;
    

  static {
    StringBuilder tmp = new StringBuilder();
    for (char ch = '0'; ch <= '9'; ++ch)
      tmp.append(ch);
    for (char ch = 'a'; ch <= 'z'; ++ch)
      tmp.append(ch);
    symbols = tmp.toString().toCharArray();
  }   

  private final Random random = new Random();

  private final char[] buf;

  public RandomString(int length) {
    if (length < 1) {
        this.length = 0;
    }
    else{
        this.length = length;
    }
    buf = new char[this.length];
  }

  public String nextString() {
    String returnedString = null;
    if(length == 0){
        returnedString = "";
    }
    else{
        for (int idx = 0; idx < buf.length; ++idx){ 
            buf[idx] = symbols[random.nextInt(symbols.length)];
            returnedString = new String(buf);
        }
    }
    
    return returnedString;  
  }
  
}
