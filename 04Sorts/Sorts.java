import java.util.*;

public class Sorts{

  public static String name(){
    return "10.Zhao.Barnett"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      //Outer loop determines which index I at start each time.
      //It also replaces the number at the index.
      for (int i = 0; i < data.length; i++){
	  //smart design because both have counter i
	  int temp = data[i];
	  int startLocation = i;
	  //Inner loop finds and replaces smaller number
	  for (int x = i; x < data.length; x++){
	      if (data[x] < temp){
		  //copy smaller value into temp
		  temp = data[x];
		  //replace smaller value (back) with larger value (front)
		  data[x] = data[i];
		  //replace larger value (front) with temp
		  data[i] = temp;
	      }
	  }
      }
  }
    

    public static void insertionSort(int[] data){
	//start with the first two books (Janice's video), so i = 1
	for (int i = 1; i < data.length; i++){
	    //variable to put temp number in
	    int temp = data[i];
	    //move ints over to the right until the correct location for temp is reached
	    int x;
	    for(x = i; x > 0; x--){
		if (temp < data[x-1]){
		    data[x] = data[x-1];
		}
		else {
		    break; //1 is not subtracted
		}
	    }
	    data[x] = temp;
	    }
	//after each outer loop, you introduce "another book" and the inner loop loops towards zero and places temp in the appropriate location
    }

    
    public static void bubbleSort(int[] data){
	//outer loop pervents checking end elements which are already in place
	int x;
	for(x = data.length; x > 0; x--){
	    for(int i = 0; i < x-1; i++){
		if(data[i] > data[i+1]){
		    //switching two adjacent elements
		    int temp = data[i];
		    data[i] = data[i+1];
		    data[i+1] = temp;
		}
	    }
	}
    }
	

    public static void main(String[] args){
	int[] a = {1,3,4,6,7,8,9};
	int[] b = {1,3,4,6,7,7,8,9};
	int[] c = {};
	int[] d = {55};

	//selectionSort
	//basic with time testing
	int[] a1 = {7,3,8,1,9,4,6};
	selectionSort(a1);
	System.out.println(Arrays.equals(a,a1));
	//repeated element
	int[] b1 = {7,3,8,1,9,4,7,6};
	selectionSort(b1);
	System.out.println(Arrays.equals(b,b1));
	//empty array
	int[] c1 = {};
	selectionSort(c1);
	System.out.println(Arrays.equals(c,c1));	
	//edge case: 1 element
	int[] d1 = {55};
	selectionSort(d1);
	System.out.println(Arrays.equals(d,d1));


	//insertionSort
	//basic
	int[] a2 = {7,3,8,1,9,4,6};
	insertionSort(a2);
	System.out.println(Arrays.equals(a,a2));
	//repeated element
	int[] b2 = {7,3,8,1,9,4,7,6};
	insertionSort(b2);
	System.out.println(Arrays.equals(b,b2));
	//empty array
	int[] c2 = {};
	insertionSort(c2);
	System.out.println(Arrays.equals(c,c2));	
	//edge case: 1 element
	int[] d2 = {55};
	insertionSort(d2);
	System.out.println(Arrays.equals(d,d2));


	//bubbleSort
	//basic
	int[] a3 = {7,3,8,1,9,4,6};
        bubbleSort(a3);
	System.out.println(Arrays.equals(a,a3));
	//repeated element
	int[] b3 = {7,3,8,1,9,4,7,6};
	bubbleSort(b3);
	System.out.println(Arrays.equals(b,b3));
	//empty array
	int[] c3 = {};
	bubbleSort(c3);
	System.out.println(Arrays.equals(c,c3));	
	//edge case: 1 element
	int[] d3 = {55};
	bubbleSort(d3);
	System.out.println(Arrays.equals(d,d3));


	//time testing
	Random randgen = new Random();
	int[] test1 = new int[1000];
	int[] test2 = new int[1000];
	int[] test3 = new int[1000];
	for (int i = 0; i < 1000; i++){
	    int x = randgen.nextInt(1000);
	    test1[i] = x;
	    test2[i] = x;
	    test3[i] = x;
	}

	//selectionSort
        long startTime = System.currentTimeMillis();
	selectionSort(test1);
	long endTime = System.currentTimeMillis();
	System.out.println(endTime-startTime);
	
	//insertionSort
        long startTime1 = System.currentTimeMillis();
	insertionSort(test2);
	long endTime1 = System.currentTimeMillis();
	System.out.println(endTime1-startTime1);
	
	//bubbleSort
        long startTime2 = System.currentTimeMillis();
	bubbleSort(test3);
	long endTime2 = System.currentTimeMillis();
	System.out.println(endTime2-startTime2);	

    }

}
