
public class BackwardsMain {

	static String string = "I was crazy once, so crazy they threw me in a room....";
	static String gnirts = "";
	
	public static int backwardsMarch(char q) {
		int i = string.length() -1;
		
		while(i >= 0) {
			q = fromTheBack(i);
			System.out.print(q);
			gnirts += q + "";
			i--;
		}
		System.out.println("\n");
		reverseDisplay(gnirts);
		
		return i;
	}
	
	public static char fromTheBack(int i) {
		char[] querry = string.toCharArray();
		char q = querry[i];
		return q;
	}
	
	public static String fromTheBackToString(int i) {
		char[] querry = gnirts.toCharArray();
		String q = querry[i] + "";
		return q;
	}
	
	public static void reverseDisplay(String value) {
		int i = gnirts.length() - 1;
		
		while(i >= 0) {
			value = fromTheBackToString(i);
			System.out.print(value);
			i--;
		}
	}
	
	public static void runner() {
		char p = 0;
		backwardsMarch(p);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			runner();
	}

}
