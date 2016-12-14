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

    public static void main(String[] args){
	//basic
	int[] a = {7,3,8,1,9,4,6};
	selectionSort(a);
	System.out.println(Arrays.toString(a));
	System.out.println("same as [1, 3, 4, 6, 7, 8, 9]");

	//repeated element
	int[] b = {7,3,8,1,9,4,7,6};
	selectionSort(b);
	System.out.println(Arrays.toString(b));
	System.out.println("same as [1, 3, 4, 6, 7, 7, 8, 9]");	

	//empty array
	int[] c = {};
	selectionSort(c);
	System.out.println(Arrays.toString(c));
	System.out.println("same as []");	

	//edge case: 1 element
	int[] d = {55};
	selectionSort(d);
	System.out.println(Arrays.toString(d));
       	System.out.println("same as [55]");
    }

}
