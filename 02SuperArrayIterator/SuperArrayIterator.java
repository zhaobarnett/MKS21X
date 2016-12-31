import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray superarray;
    private int element;

    public SuperArrayIterator(SuperArray x){
	superarray = x;
	element =  0;
    }

    public boolean hasNext(){
	return element < (superarray.size() - 1);
    }

    public String next(){
	if(hasNext()){
	    element++;
	    return superarray.get(element);
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

}
