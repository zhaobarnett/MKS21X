import java.*;

public class Barcode implements Comparable<Barcode>{
    private String _zip;

    public Barcode(String zip){
	try{
	    Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else{
	    _zip = zip;
	}
    }

    private int checkSum(String zip){
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
	Integer.parseInt(

    public static String toCode(String zip){
	try{
	    Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	String retVal = "|";
	for (int x = 0; x < 5; x++){
	    if (zip.substring(x, x+1).equals("1")){
		retVal += ":::||";
	    }
	    
	
	    


}
