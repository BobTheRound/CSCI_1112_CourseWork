import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Main {
	private static int total = 0;
	
	public static void outSource() throws IOException {
		try(
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
		new FileOutputStream("Exercise17_03.dat")));	
		){ 
			for(int i = 0; i <100; i++) {
			double ran = Math.random() * 10;
			int postRan = (int)ran;
			total += postRan;
			output.writeInt(postRan);
			}
			output.writeInt(total);
		}
	}
	
	public static void inSource() throws IOException{
		try {
		DataInputStream input = new DataInputStream(new BufferedInputStream(
			new FileInputStream("Exercise17_03.dat")));		
			{
			int value;
			
				while((value = input.readInt()) != -1) {
					System.out.print(value + " ");
				}
				System.out.println("");
				System.out.println("/n" + total);
			}
		}catch(EOFException e) {	
		}
	}

	public static void main(String[] args) throws IOException {
		outSource();
		inSource();
	
	
	}
}