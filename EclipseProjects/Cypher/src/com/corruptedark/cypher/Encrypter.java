package com.corruptedark.cypher;

public class Encrypter {
	
	String encryptNumber(String value){
		
		String letter;
		
		switch(value){
			case "1":
				letter = "K";
				break;
			case "2":
				letter = "E";
				break;
			case "3":
				letter = "Y";
				break;
			case "4":
				letter = "T";
				break;
			case "5":
				letter = "O";
				break;
			case "6":
				letter = "M";
				break;
			case "7":
				letter = "I";
				break;
			case "8":
				letter = "N";
				break;
			case "9":
				letter = "D";
				break;
			case "0":
				letter = "S";
				break;
			default:
				letter = "?";
				break;
				
		}
		return letter;
	}

	String encryptLetter(String value){

		value = value.toUpperCase();
		
		String number;
		
		switch(value){
			case "A":
				number = "833";
				break;
			case "B":
				number = "523";
				break;
			case "C":
				number = "213";
				break;
			case "D":
				number = "992";
				break;
			case "E":
				number = "682";
				break;
			case "F":
				number = "372";
				break;
			case "G":
				number = "62";
				break;
			case "H":
				number = "742";
				break;
			case "I":
				number = "432";
				break;
			case "J":
				number = "122";
				break;
			case "K":
				number = "802";
				break;
			case "L":
				number = "591";
				break;
			case "M":
				number = "281";
				break;
			case "N":
				number = "961";
				break;
			case "O":
				number = "651";
				break;
			case "P":
				number = "341";
				break;
			case "Q":
				number = "231";
				break;
			case "R":
				number = "911";
				break;
			case "S":
				number = "601";
				break;
			case "T":
				number = "39";
				break;
			case "U":
				number = "8";
				break;
			case "V":
				number = "76";
				break;
			case "W":
				number = "45";
				break;
			case "X":
				number = "14";
				break;
			case "Y":
				number = "82";
				break;
			case "Z":
				number = "51";
				break;
			default:
				number = "?";
				break;
		}
		return number;
	}
	
	String encryptOther(String value){
		String symbol;
		switch(value){
		case " ":
			symbol = ".";
			break;
		case ".":
			symbol = "#";
			break;
		default:
			symbol = "?";
			break;
	}
	return symbol;
	}
}

