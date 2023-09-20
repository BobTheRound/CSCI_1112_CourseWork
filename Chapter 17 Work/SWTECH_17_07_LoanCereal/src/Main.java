/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
        
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData();
    }
    public static void outputData()  throws IOException{
    	try(
    	ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
    	){
    		while(true) {
    		Loan loanX = (Loan) input.readObject();
    		System.out.print(loanX);
    		double amount = loanX.getLoanAmount();
    		
    		System.out.println(": $"+ amount);
    		}
    	}
       	catch(EOFException ex) {
    		System.out.println("All Loans Displayed");
    		
    	} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
    	
    }
        
}
/*
*
*Modify Exercise17_07 by adding a void function called outputData 
*that reads the Loan objects from the file and displays the total 
*loan amount. 
*Suppose you don’t know how many Loan objects are there in the 
*file, 
*use EOFException to end the loop.
*
*/