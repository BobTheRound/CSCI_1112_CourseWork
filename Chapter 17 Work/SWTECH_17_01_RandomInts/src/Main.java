import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{

		try(
			FileOutputStream output = new FileOutputStream("Exercise17_01.txt");		
				){ for(int i = 0; i <100; i++) {
					double ran =Math.random() * 10;
					int postRan = (int)ran;
					System.out.println("debugMe" + postRan);
					output.write(postRan);
			}
		}
		
		try(
			FileInputStream input = new FileInputStream("Exercise17_01.txt");
			){
			int value;
			while((value = input.read()) != -1)
				System.out.println(value + " ");
		
			}
			
		}
}
