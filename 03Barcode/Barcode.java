import java.*;

public class Barcode implements Comparable<Barcode>{
    private String _zip;

    public Barcode(String zip){
	//checks if the String contains only digits
	try{
	    Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException("zip contains a non digit");
	}
	//checks if the String is correct length
	if (zip.length() != 5){
	    throw new IllegalArgumentException("zip is not the correct length");
	}
	else{
	    _zip = zip;
	}
    }

    private static int checkSum(String zip){
	int retVal = 0;
	for (int x = 0; x < 5; x++){
	    retVal += Integer.parseInt(zip.substring(x,x+1));
	}
	retVal = retVal % 10;
	return retVal;
    }

    public String toString(){
	return _zip + checkSum(_zip) + " " + toCode(_zip);
    }

    public int compareTo(Barcode other){
	return Integer.valueOf(_zip+checkSum(_zip)).compareTo(Integer.valueOf(other._zip+checkSum(other._zip)));
    }

    public static String toCode(String zip){
	try{
	    Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException("zip contains a non digit");
	}
	if (zip.length() != 5){
	    throw new IllegalArgumentException("zip is not the correct length");
	}
	zip = zip + checkSum(zip);
	String retVal = "|";
	for (int x = 0; x < 6; x++){
	    if (zip.substring(x,x+1).equals("1")){
		retVal += ":::||";
	    }
	    else if (zip.substring(x,x+1).equals("2")){
		retVal += "::|:|";
	    }
	    else if (zip.substring(x,x+1).equals("3")){
		retVal += "::||:";
	    }	    
	    else if (zip.substring(x,x+1).equals("4")){
		retVal += ":|::|";
	    }	
	    else if (zip.substring(x,x+1).equals("5")){
		retVal += ":|:|:";
	    }	    
	    else if (zip.substring(x,x+1).equals("6")){
		retVal += ":||::";
	    }
	    else if (zip.substring(x,x+1).equals("7")){
		retVal += "|:::|";
	    }
	    else if (zip.substring(x,x+1).equals("8")){
		retVal += "|::|:";
	    }
	    else if (zip.substring(x,x+1).equals("9")){
		retVal += "|:|::";
	    }
	    else {
		retVal += "||:::";
	    }
	}
	retVal += "|";
	return retVal;
    }

    public static String toZip(String code){
	if (code.length() != 32){
	    throw new IllegalArgumentException("code is not the correct length");
	}
	if (! (code.substring(0,1).equals("|") && code.substring(31,32).equals("|"))){
	    throw new IllegalArgumentException("left and rightmost charcters are not '|'");
	}
	for (int x = 0; x < 32; x++){
	    if (! (code.substring(x, x+1).equals("|") || code.substring(x, x+1).equals(":"))){
		throw new IllegalArgumentException("non-barcode characters are used");
	    }
	}
	code = code.substring(1,31);
	String retVal = "";
	for (int x = 0; x < 30; x=x+5){
	    if (code.substring(x,x+5).equals(":::||")){
		retVal += "1";
	    }
	    else if (code.substring(x,x+5).equals("::|:|")){
		retVal += "2";
	    }
	    else if (code.substring(x,x+5).equals("::||:")){
		retVal += "3";
	    }	    
	    else if (code.substring(x,x+5).equals(":|::|")){
		retVal += "4";
	    }	
	    else if (code.substring(x,x+5).equals(":|:|:")){
		retVal += "5";
	    }	    
	    else if (code.substring(x,x+5).equals(":||::")){
		retVal += "6";
	    }
	    else if (code.substring(x,x+5).equals("|:::|")){
		retVal += "7";
	    }
	    else if (code.substring(x,x+5).equals("|::|:")){
		retVal += "8";
	    }
	    else if (code.substring(x,x+5).equals("|:|::")){
		retVal += "9";
	    }
	    else if (code.substring(x,x+5).equals("||:::")){
		retVal += "0";
	    }
	    else {
		throw new IllegalArgumentException("encoded ints are invalid");	        
	    }
	}
	if (checkSum(retVal.substring(0,5)) != Integer.parseInt(retVal.substring(5,6))){
	    throw new IllegalArgumentException("checkSum is invalid");
	}
	else {
	    return retVal.substring(0,5);
	}
    }
}


 
