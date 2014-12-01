import java.math.BigDecimal;
import java.util.Scanner;


public class CashRegister {
	
	//Establish Denominations:
	public enum Denomination {
	    HUNDRED("100"), FIFTY("50"), TWENTY("20"), TEN("10"), FIVE("5"), ONE("1"),
	    QUARTER(".25"), DIME(".10"), NICKEL(".5"), PENNY(".01");
	    
	    private BigDecimal dollarValue;
	    
	    private Denomination(String amount) {
	    	dollarValue = new BigDecimal(amount);
	    }
	    
	    public BigDecimal getDollarValue() {
	    	return dollarValue;
	    }
	}
	

	// Create a single shared Scanner for keyboard input
    private static Scanner scanner = new Scanner( System.in );

    
	public static void main(String[] args) {	

		displayInstructionsMarquee();
		
		System.out.print( "\n\n  Please enter a valid monetary value:" );
		
        // Read the of text entered by the user:
        String userInput = scanner.nextLine();

        BigDecimal dollarAmount = null;
        
        
        try {        	
        	dollarAmount = new BigDecimal(userInput); 

        } catch (NumberFormatException nfe) {
        	System.out.println( "\n  Invalid entry!  Currency symbols should NOT be used." );
        }
        
        
        BigDecimal currentAmount = dollarAmount;
        String changeAmt = "";
        
        // Placement: Hundred, Fifty, Twenty, Ten, Five, One, Quarter, Dime, Nickle, Penny
        int[] moneyValues = {0,0,0,0,0,0,0,0,0,0};
        String[] moneyNames = {"$100 Bill", "$50 Bill", "$20 Bill", "$10 Bill", "$5 Bill", "$1 Bill", "Quarter", "Dime", "Nickel", "Penny"};
        
        
        try {
        	
        	//Start the mechanical whizbang chuggin' change machine:
        	while (currentAmount.compareTo(BigDecimal.ZERO) > 0) {
        		
        		if (currentAmount.compareTo(Denomination.HUNDRED.dollarValue) >= 0) {
        			moneyValues[0]++;
        			currentAmount = currentAmount.subtract(Denomination.HUNDRED.dollarValue);
        			
        		} else if (currentAmount.compareTo(Denomination.FIFTY.dollarValue) >= 0) {
        			moneyValues[1]++;
        			currentAmount = currentAmount.subtract(Denomination.FIFTY.dollarValue);
        		
        		} else if (currentAmount.compareTo(Denomination.TWENTY.dollarValue) >= 0) {
        			moneyValues[2]++;
        			currentAmount = currentAmount.subtract(Denomination.TWENTY.dollarValue);
        			
        		} else if (currentAmount.compareTo(Denomination.TEN.dollarValue) >= 0) {
        			moneyValues[3]++;
        			currentAmount = currentAmount.subtract(Denomination.TEN.dollarValue);
        			
        		} else if (currentAmount.compareTo(Denomination.FIVE.dollarValue) >= 0) {
            		moneyValues[4]++;
            		currentAmount = currentAmount.subtract(Denomination.FIVE.dollarValue);
            		
        		} else if (currentAmount.compareTo(Denomination.ONE.dollarValue) >= 0) {
            		moneyValues[5]++;
            		currentAmount = currentAmount.subtract(Denomination.ONE.dollarValue);
            		
        		} else if (currentAmount.compareTo(Denomination.QUARTER.dollarValue) >= 0) {
            		moneyValues[6]++;
            		currentAmount = currentAmount.subtract(Denomination.QUARTER.dollarValue);
            		
        		} else if (currentAmount.compareTo(Denomination.DIME.dollarValue) >= 0) {
            		moneyValues[7]++;
            		currentAmount = currentAmount.subtract(Denomination.DIME.dollarValue);
            		
        		} else if (currentAmount.compareTo(Denomination.NICKEL.dollarValue) >= 0) {
            		moneyValues[8]++;
            		currentAmount = currentAmount.subtract(Denomination.NICKEL.dollarValue);
            		
        		} else if (currentAmount.compareTo(Denomination.PENNY.dollarValue) >= 0) {
            		moneyValues[9]++;
            		currentAmount = currentAmount.subtract(Denomination.PENNY.dollarValue);
        		}

        	}

        	for (int i = 0; i < moneyValues.length; i++) {
            	
        		if (moneyValues[i] > 0) {
        			changeAmt = changeAmt.concat(moneyValues[i] + " " + moneyNames[i]);
        			changeAmt = changeAmt.concat(moneyValues[i] > 1 ? "s, " : ", ");
            	}        		
        	}
        	
        	//Truncate final comma and space (indexed):
        	changeAmt = changeAmt.length() > 2 ? changeAmt.substring(0, changeAmt.length() - 2) : "";

        	
	        // Display the input back to the user (a touch of validation).
        	if (dollarAmount.compareTo(BigDecimal.ZERO) < 0) {
        		System.out.println( "\n  Change: Negative amounts cannot be processed.  This is not a debt machine.");
    		} else if (changeAmt.length() == 0) {
	        	System.out.println( "\n  Change: Zero Dollar Amount");
	        } else {
	        	System.out.println( "\n  Change: " + changeAmt);	
	        }
        	
        	
        } catch (Exception e) {        	
        	e.printStackTrace();        	
        }        
	    
	    System.exit(0);
	    
	}
	
	
	/**
	 * @param   input
	 * @return  String with all whitespace zapped
	 */
	private static String mitigateWhiteSpace(String input) {
		return input.replaceAll("\\s+","");
	}
	
	
	private static void displayInstructionsMarquee() {
		String headerFill = "\n\t $                                             $";
		String headerBorder = "\n\t $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $";
		System.out.print( headerBorder + headerFill + "\n\t $   STG ~ Code Challenge #2 ~ Cash Register   $" + headerFill + headerBorder + "\n\n" );
		System.out.print( "Given a U.S. currency value, determine the FEWEST number of bills and coins to return for change, listing out the exact change.\n" );
		System.out.print( "Assume $1, $5, $10, $20, $50, $100 bills and penny, nickel, dime, quarter coins for the denominations. " );
	}

}
