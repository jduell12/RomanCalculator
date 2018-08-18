import java.util.*;

public class RomanCalculator {
	public static void main (String [] args) {
		Scanner keyboard = new Scanner(System.in);
		RCMethods methods = new RCMethods();
		
	while (methods.doCalculation()) {
		System.out.println();
	}
	System.out.println("Finished Roman Computations");
	keyboard.close();
		
}
	 
	
}