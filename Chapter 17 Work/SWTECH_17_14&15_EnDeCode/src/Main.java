/*
 *	(Encrypt files) Encode the file by adding 5 to every 
 * 	byte in the file. Write a program that prompts the user 
 * 	to enter an input file name and an output file name 
 * 	and saves the encrypted version of the input file to 
 * 	the output file.
 *
 *	(Decrypt files) Suppose a file is encrypted using the 
 *	scheme in Programming Exercise 17.14. Write a program 
 *	to decode an encrypted file. Your program should prompt 
 *	the user to enter an input file name for the encrypted 
 *	file and an output file name for the unencrypted version 
 *	of the input file.
 */


import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable{

	private static String inName;
	private static String outName;
	private static int defNotEncodeValue = 5;
	
	public static String getInputName() {
		Scanner input = new Scanner(System.in);
		inName = input.nextLine();
		return inName;
	}
	
	public static String getOutputName() {
		Scanner input = new Scanner(System.in);
		outName = input.nextLine();
		return outName;
	}
	
	public static String setOutputName(String pickMe) {
		pickMe = outName;
		return outName;
	}
	public static void makeOutFile() throws IOException {
		System.out.println("please input a file name");
		try(
			DataOutputStream output = new DataOutputStream(new FileOutputStream(getOutputName() + ".dat"));
				){
			System.out.println("DebugMe " + output.toString());
			output.writeInt(defNotEncodeValue + 5);
			}
		catch (IOException e){
			System.out.println("debugMe makeOutFile");
		}
	}
		
	public static void makeInFile() throws IOException {

		try(
			DataInputStream input = new DataInputStream(new FileInputStream(setOutputName(outName) + ".dat"));
				
				){	
			System.out.println("DebugMe " + input.toString());
			}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("debugMe makeInFile");
		}
	}
	
	public static void makeDecodeFile() throws IOException {
		System.out.println("please input a file name");
			DataOutputStream output = new DataOutputStream(new FileOutputStream(getOutputName() + ".dat"));
			System.out.println("DebugMe " + output.toString());
			output.writeInt(-5);
			System.out.println("DebugMe " + output.toString());
	}
	
	public static void blender() throws IOException {
		makeOutFile();
		makeInFile();
		makeDecodeFile();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, NotSerializableException{
		blender();
	}
		
}
	

