import java.util.ArrayList;
import java.util.Collection;

public class Main {


	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> shoppingList = new ArrayList<E>(list);
		
		boolean dupe = true;
		
		for(int i = 0; i < list.size(); i++) {		
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j) == list.get(i)) {
					dupe = false;
				} else {
				shoppingList.add(list.get(i));
				}
			}
			
		}
		return shoppingList;	
	}
}
