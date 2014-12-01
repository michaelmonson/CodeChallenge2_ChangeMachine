Code Challenge 2 ~ Change Machine
============================

This application simulates a "change machine" that will break down United States currency into the least number of standard bills and coins.

Write a change machine that, given a U.S. currency value, determines the FEWEST number of bills and coins to return for change, listing out the exact change.

 Assume $1, $5, $10, $20, $50, $100 bills and penny, nickel, dime, quarter coins for the denominations.

 Here are some examples:

 5.27 -> 1 $5 bill, 1 quarter, 2 pennies
 10 -> 1 $10 bill
 30 -> 1 $20 bill, 1 $10 bill


This application is written in Java, and can be ran from the command prompt or within the IDE console.  To run within the IDE directly, Eclipse and IntelliJ will recognize the main function withi the ChangeMachine class, and will give you the option to run the class as a Java application.

NOTE: I didn't leave myself much time to complete this code challenge, so it still has plenty of rough edges.  It IS functional, and does have some basic validation.  

Additional Functionality to improve:
   1. Allow the user to continue entering new dollar amounts, rather than terminating after each entry.
   2. Modularize the if/then loop (through each piece of currency) to be a function that takes input param's.
   3. Extend the enumeration of denominations further
   4. Improve the validation and interaction with the user.
   5. Build a front-end or client view to replace command line entry.
   
[END]
