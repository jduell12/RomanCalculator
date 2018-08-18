import java.util.*;



public class RCMethods {
	Scanner scan = new Scanner(System.in);
	char operator = 'q';
	int answer, operand1, operand2, sum;
	
	
// Prompts user for Operator
	public char getOperator() {
		boolean operator_is_good = false;
		
		do {
			System.out.println("Enter an Operator: + - * / q for quit: ");
			String strOperator = scan.nextLine();
			strOperator = strOperator.trim();
			if (strOperator.length() == 0) {
				continue;
			}
			operator = strOperator.charAt(0);
			operator_is_good = false;
			
			switch (operator) {
				case 'q': 
					operator_is_good = true;
					break;
				case '+': 
					operator_is_good = true;
					break;
				case '-':
					operator_is_good = true;
					break;
				case '*':
					operator_is_good = true;
					break;
				case '/':
					operator_is_good = true;
					break; 
				default:
					System.out.println("Your operator is bad ... try again");
					break;
			}
		} while (!operator_is_good);
		
	return operator;
	}

// Converts from Roman numeral operand to integer
	public int convert_from_Roman(String value) {
		
		sum = 0;
		
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) {
				sum = -1;
				break;
			} else if (value.charAt(i) == 'M') {
				sum += 1000;
			
			} else if (value.charAt(i) == 'D') {
				sum += 500;
				
			} else if (value.charAt(i) == 'C') {
				sum += 100;
				
			} else if (value.charAt(i) == 'L') {
				sum += 50;
				
			} else if (value.charAt(i) == 'X') {
				sum += 10;
			
			} else if (value.charAt(i) == 'V') {
				sum += 5;
				
			} else if (value.charAt(i) == 'I') {
				sum += 1;
				
			} else {
				sum = -1;
			}
			
		}
		return sum;
	}

// Prompts user for oeprand1 as a Roman Numeral if user puts in an invalid response it prompts the user again
	public int getOperand1() {
		
		System.out.println("Enter in a Roman Numeral for your first operand: ");
		String input = scan.nextLine();
		String roman = input.toUpperCase();
		int operand1 = convert_from_Roman(roman);
		if (operand1 < 0) {
			System.out.println("That operand is invalid. ");
			operand1 = getOperand1();
		}
			return operand1;
		
			
	}
// Prompts user for second operand. If user inputs an invalid response method prompts user for a valid response.
	public int getOperand2() {
	
		System.out.println("Enter in a Roman Numeral for your second operand: ");
		String input = scan.nextLine();
		String roman = input.toUpperCase();
		int operand2 = convert_from_Roman(roman);
		if (operand2 < 0) {
			System.out.println("That operand is invalid. ");
			operand2 = getOperand2();
		}
		return operand2;
	}

// Performs arithmetic indicated by the operator and returns the answer
	public int doArithmetic(int operand1, int operand2) {
		switch (operator) {
		case '+' :
			answer = operand1 + operand2;
			break;
		case '-':
			answer = operand1 - operand2;
			break;
		case '*':
			answer = operand1 * operand2;
			break;
		case '/':
			answer = operand1/operand2;
			break;
		default:
			System.out.println("We shouldn't get here in doArithmetic!!!");
			answer = -1;
			break; 
		}
		return answer; 
	}

// Converts integer value into a Roman Numeral
	public String convert_to_Roman(int value) {
		String roman = "";
		while (value > 0) {
			while (value >= 1000) {
				roman += "M";
				value -= 1000;
			}
			while (value >= 500) {
				roman += "D";
				value -= 500;
			}
			while (value >= 100) {
				roman += "C";
				value -= 100;
			}
			while (value >= 50) {
				roman += "L";
				value -= 50;
			}
			while (value >= 10) {
				roman += "X";
				value -= 10;
			}
			while (value >= 5) {
				roman += "V";
				value -= 5;
			}
			while (value >= 1){
				roman += "I";
				value -= 1;
			}
		}
		
		return roman;
	}
	
// Returns false if the user wants to quit or it does one Roman Calculator calculation
	public boolean doCalculation() {
		operator = getOperator();
		if (operator == 'q') {
			return false;
		}
		int operand1 = getOperand1();
		int operand2 = getOperand2();
		int answer = doArithmetic(operand1, operand2);
		System.out.println(convert_to_Roman(answer));
		return true;
	}
	
}