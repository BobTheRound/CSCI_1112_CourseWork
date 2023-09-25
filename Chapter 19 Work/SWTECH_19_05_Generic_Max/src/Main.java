
public class Main {

	public static <E extends Comparable<E>> E max(E[] list) {
		E maxVal = list[0];
		for(int i = 1; i < list.length; i++) {
			E holder = list[i];
			System.out.println("debugMe " + list[i]);
			if (holder.compareTo(maxVal) > 0) {
				maxVal = holder;
			}
		}
		return maxVal;
	}
	
	public static void main(String[] args) {
	
		Double[] bigPie = new Double[10];
	
		for(int i = 0; i < bigPie.length; i++) {
		bigPie[i] = (double)Math.random() * 100;
	
		}
		
		System.out.println("The biggest of pies is " + max(bigPie));
	}
}
