/*
*Author: Robert Beauchamp
*Date: 9/25/23
*
*Description: 
*Write the following method that
*sorts an Array List:
*public static <E extends Comparable<E>> void sort(ArrayList<E> list) 
*/
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	ArrayList<E> pie = new ArrayList<>();
	for(int i = 0; i < list.size(); i++) {
		pie.add(list.get(i));
	}
	Collections.sort(pie);
	System.out.println("sorted pie " + pie);
	}
		  
  
	  
	  
	  
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Main.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  
}
