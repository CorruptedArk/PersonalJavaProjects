package com.corruptedark.cypher;

public class Decrypter {
	
	String decryptNumber(int value){
		
		String letter;
		
		switch (value) {       
                case 833:
                     letter = "A";
                     break;
                case 523:
                     letter = "B";
                     break;
                case 213:
                     letter = "C";
                     break;                     
                case 992:
                     letter = "D";
                     break;
                case 682:
                     letter = "E";
                     break;
                case 372:
                     letter = "F";
                     break;
                case 62:
                     letter = "G";
                     break;
                case 742:
                     letter = "H";
                     break;
                case 432:
                     letter = "I";
                     break;
                case 122:
                     letter = "J";
                     break;
                case 802:
                     letter = "K";
                     break;
                case 591:
                     letter = "L";
                     break;
                case 281:
                     letter = "M";
                     break;
                case 961:
                     letter = "N";
                     break;
                case 651:
                     letter = "O";
                     break;
                case 341:
                     letter = "P";
                     break;
                case 231:
                     letter = "Q";
                     break;
                case 911:
                     letter = "R";
                     break;
                case 601:
                     letter = "S";
                     break;
                case 39:
                     letter = "T";
                     break;
                case 8:
                     letter = "U";
                     break;
                case 76:
                     letter = "V";
                     break;
                case 45:
                     letter = "W";
                     break;
                case 14:
                     letter = "X";
                     break;
                case 82:
                     letter = "Y";
                     break;
                case 51:
                     letter = "Z";
                     break;                    
                default:
                     letter = "?";
                     break;
        } 
		return letter;
	}
	
	String decryptLetter(String value){
		
		String number;
		
		switch (value) {
                 case "K":
                 case "k": 
                      number = "1";
                      break;                           
                 case "E":
                 case "e":
                      number = "2";
                      break;
                 case "Y":
                 case "y":
                      number = "3";
                      break;
                 case "T":
                 case "t":
                      number = "4";
                      break;
                 case "O":
                 case "o":
                      number = "5";
                      break;
                 case "M":
                 case "m":
                      number = "6";
                      break;
                 case "I":
                 case "i":
                      number = "7";
                      break;
                 case "N":
                 case "n":
                      number = "8";
                      break;
                 case "D":
                 case "d":
                      number = "9";
                      break;
                 case "S":
                 case "s":
                      number = "0";
                      break;
                 default:
                	  number = "?";
                	  break;
         }
		return number;
	}
	
	String decryptOther(String value){
		String symbol;
		switch(value){
			case ".":
				symbol = " ";
				break;
			case "#":
				symbol = ".";
				break;
			default:
				symbol = "?";
				break;
		}
		return symbol;
	}

}
