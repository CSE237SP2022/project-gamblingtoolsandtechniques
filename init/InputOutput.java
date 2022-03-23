package init;

import java.util.Scanner;

public class InputOutput {

	/*
	 * Class to test user i/o from the shell
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 
		System.out.println("Enter a string: ");
        String s = in.nextLine();
        System.out.println("You entered string \"" + s + "\"");
        
        in.close();
        
	}
	
}
