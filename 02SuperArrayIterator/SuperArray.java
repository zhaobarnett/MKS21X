import java.util.*;

public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;
    private SuperArray x;

    public SuperArray(){
	data = new String[10];
	size = 0;
	x = this;
    }


    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	else{
	data = new String[initialCapacity];
	size = 0;
	x = this;
	}
    }

    
  public int size(){
    return size;
  }

    
    private void grow(){
      String[] temp = new String[size+1];
      for (int x = 0; x < size; x++){
	  temp[x] = data[x];
      }
      data = temp;
  }

    
  public boolean add(String n){
      if (size < data.length){
	  data[size] = n;
	  size += 1;
      }
      else {
	  grow();
	  data[size] = n;
	  size += 1;
      }
      return true;
  }

 
  public String toString(){
      String retVal = "[";
      for (int x = 0; x < size-1; x++){
	  retVal += data[x] + ", ";
      }
      if (size > 0){
      retVal += data[size-1] + "]";
      }
      else{
	  retVal += "]";
      }
      return retVal;
  }


public String toStringDebug(){
    String retVal = "[";
    for (int x = 0; x < size-1; x++){
	  retVal += data[x] + ", ";
      }
    if (size > 0){
	retVal += data[size-1];
	if (size < data.length){
	    for (int x = size; x < data.length; x++){
		retVal += ", " + "_";
	    }
	}
    }
    else{
	if (size < data.length){
	    for (int x = 0; x < data.length-1; x++){
		retVal += "_" + ", ";
	    }
	    retVal += "_";
	}
    }
    retVal += "]";
    return retVal;
}


    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	return data[index];
	}
    }


    public void clear(){
	size = 0;
    }


    public boolean isEmpty(){
	return size == 0;
    }


    public String set(int index, String element){
	if (index < 0 || index >= size()){
	     throw new IndexOutOfBoundsException();
	}
	else{   
	String retVal = data[index];
	data[index] = element;
        return retVal;
	}
    }


    public void add(int index, String element){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
      	if (data.length == size){
	    grow();
	}
	for (int x = size; x > index; x--){
	    data[x] = data[x-1];
	}
	data[index] = element;
	size += 1;
	}
    }


    public String remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	String retVal = data[index];
	for (int x = index; x < size-1; x++){
	    data[x] = data[x+1];
	}
	size -= 1;
	return retVal;
	}
    }


    public String[] toArray(){
	String[] retVal = new String[size];
	for (int x = 0; x < size; x++){
	    retVal[x] = data[x];
	}
	return retVal;
    }
	

    public int indexOf(String i){
	int x = 0;
	while (x < size){
	    if (data[x].equals(i)){
		return x;
	    }
	    x++;
	}
	return -1;
    }
		

    public int lastIndexOf(String i){
	int x = size-1;
	while (x > 0){
	    if (data[x].equals(i)){
		return x;
	    }
	    x--;
	}
	return -1;
    }


    public void trimToSize(){
	String[] temp = new String[size];
	for (int x = 0; x < size; x++){
	    temp[x] = data[x];
	}
	data = temp;
    }

    
    public Iterator<String> iterator(){
	return new SuperArrayIterator(x);
    }
	    
			  
}
