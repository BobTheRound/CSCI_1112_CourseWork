import java.util.Scanner;

public class GCD_Main {

	int userNum;
	int gcdReal = 1;
	
	static int m;
	static int n;
	static int gcdFind = 2;
	
	public int getNumber() {
		System.out.println("Please input a non-negative integer");
		Scanner input = new Scanner(System.in);
		this.userNum = input.nextInt();
		return this.userNum;
	}

	public int resolve() {
		if (m % gcdFind== 0 && n % gcdFind == 0) {
			this.gcdReal = gcdFind;
		}
		return this.gcdReal;
	}
	
	public static void compile() {
		Problem solve = new Problem();
		m = solve.getNumber();
		n = solve.getNumber();
		while(m >= gcdFind && n >= gcdFind) {
			solve.resolve();
			gcdFind += 1;
		}
		System.out.println("The highest common denominator is: " + solve.gcdReal);
	}
	
	public static void main (String[] args) {
		compile();
	}
}

class Problem extends GCD_Main{
	public Problem() {
		
	}
}