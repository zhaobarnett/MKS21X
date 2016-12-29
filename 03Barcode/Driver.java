public class Driver{
    public static void main(String[] args){
	//testing constructor
	try{
	    Barcode a = new Barcode("|v800");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    Barcode b = new Barcode("2963266");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	Barcode c = new Barcode("06488");
	Barcode d = new Barcode("12345");

	//testing toString()
	System.out.println(c.toString());
	System.out.println(d.toString());

	//testing compareTo
	System.out.println(c.compareTo(d)); //should return -1

	//testing toCode
       	try{
	    System.out.println(Barcode.toCode("|v800"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toCode("2963266"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	System.out.println(Barcode.toCode("06488"));
	System.out.println(Barcode.toCode("08451")); //"|||:::|::|::|::|:|:|::::|||::|:|"

	//testing toZip
	try{
	    System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|||||||||"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|::"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toZip(":||:::|::|::|::|:|:|::::|||::|::"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toZip("|||:::|::|::|g:|:|:|::::|||::|:|"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toZip("|:::::|::|::|::|:|:|::::|||::|:|"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	try{
	    System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::||||:::|"));
	}catch(IllegalArgumentException e){
	    e.printStackTrace();
	}
	System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|")); //08451
	System.out.println(Barcode.toZip("|||::::||:::|::||::|:|::|::||::|")); //06488
	System.out.println(Barcode.toZip("|:::||::|:|::||::|::|:|:|::|:|:|")); //12345
	
    }
}
