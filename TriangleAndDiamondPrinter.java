/*******************************************************************
Assignment #3

Book.java By: Luis Saravia Patron ID # 6800505

This program prints different patterns based on the user choice of a pattern number.
The program will check for valid pattern numbers, and will request the user to either 
enters a correct pattern number or enter 5 to quit the entire program.
Once the pattern number is correctly supplied, the program requests the user to enter the
a value that will be the size of the pattern.
The program will check for values within the given range and will ask the user to re-enter
another value. 
This will repeat indefinitely until a good value is entered.
Upon the entry of a good input value the program will draw a pattern and will ask again
for a pattern number or 5 to exit the program. 
********************************************************************/


import java.util.Scanner;

public class TriangleAndDiamondPrinter {

	public static void main(String[] args) {
					
		//Welcome message
		System.out.println("Assignment 3 - Triangle and Diamond Printer -  written by Luis Saravia Patron.\n");
			
		//Create variables to store user's entered values
		int patternNumber, patternSize;
		//Create a counter in order to control if the loop is executed for a second  
		boolean firstLoop = true;
			
		//Start the main loop that will repeat as long as the user wants
		do{
			//Ask user to choose a pattern (for the first time or for the following loops)
			if (firstLoop == true)
				System.out.println("Please select the pattern you want to display:\n");
			else					
			System.out.println("\nWhat pattern do you want to display next?\n");
								
			//Show patterns		
			System.out.printf("1) %-5d\t2) %5d\t3) %5d\t4) %3d\n", 54321, 1, 12345, 1);
			System.out.printf("   %-5d\t   %5d\t   %5d\t   %4d\n", 5432, 12, 2345, 123);
			System.out.printf("   %-5d\t   %5d\t   %5d\t   %5d\n", 543, 123, 345, 12321);
			System.out.printf("   %-5d\t   %5d\t   %5d\t   %4d\n", 54, 1234, 45, 123);
			System.out.printf("   %-5d\t   %5d\t   %5d\t   %3d\n", 5, 12345, 5, 1);
			System.out.println();
			
			//Create a Scanner object to read from keyboard
			Scanner kb = new Scanner(System.in);
			
			//Ask the user to enter the chosen value and read it using a Scanner object
			System.out.println("Please enter the number of the selected pattern or enter 5 to quit program:");
			patternNumber = kb.nextInt();
		
			//Make sure it is a legal value or ask again
			if (patternNumber < 1 || 5 < patternNumber)
				do{
					System.out.println("You have entered an invalid number. Please try from 1 to 4 or press 5 to exit.");
					patternNumber = kb.nextInt();
				}
				while (patternNumber < 1 || 5 < patternNumber);

			//Exit program when user enters 5
			if (patternNumber == 5){
				break;
			}
		
			//Ask user to enter a value larger than 0 and smaller than 10 (pattern size)
			//and read it using a Scanner object
			do{
				System.out.println("Please enter a value from 1 to 9:");
				patternSize = kb.nextInt();
				if (patternSize == 1){
					System.out.println("Good! but 1 is not enough to form a pattern. Please try a bigger value.");
				}
						
			}
			while (patternSize < 2 || 9 < patternSize);
		
			//Declare variables that will be useful to draw
			int i, j;
			//Draw the selected pattern
			switch (patternNumber){
			case 1: 
				for (i = 0; i < patternSize ; i++){
					for (j = patternSize ; j-i > 0 ; j--)
						System.out.print(j);
					System.out.println();
				}
				break;
			case 2:
				for (i = 1; i <= patternSize; i++){
					for (j = patternSize - 1 ; j-i >= 0 ; j--)
						System.out.print(" ");
					for (j = 1; i >= j ; j++)
						System.out.print(j);	
					System.out.println();
				}
				break;
			case 3:
				for (i = 1; i<= patternSize ; i++){
					for (j = 1; j < i ; j++)
						System.out.print(" ");
					for (j = i; j<= patternSize ; j++)
						System.out.print(j);
					System.out.println();
				}
				break;
			case 4: // Different behavior for odd or even numbers
				// if it is an even number
				if (patternSize % 2 == 0){
					
					//Draw upper part of the diamond
					for (i = 1; i <= patternSize/2; i++){
						
						//Print spaces first
						for (j = patternSize / 2; j-i > 0; j--)
							System.out.print(" ");
						
							//Print numbers 
						for (j = 1; j <= i * 2 - 1; j++)
							System.out.print(j);
						System.out.println();
					}
					//Draw lower part of the diamond
					for (i = 1; i <= patternSize / 2; i++){
					//Print spaces first
						for (j = 1; j < i ; j++)
							System.out.print(" ");
						//Print numbers
					 	for (j = 1; j <= patternSize-(i*2-1); j++)
							System.out.print(j);
						System.out.println();
					}
				}
				// Odd number
				else{
					//Draw upper part of the diamond
					for (i = 1; i <= patternSize / 2; i++){
						
						//Print spaces first
						for (j = patternSize / 2; j-i >= 0; j--)
							System.out.print(" ");
						
						//Print numbers 
						for (j = 1; j <= i * 2 - 1; j++)
							System.out.print(j);
						System.out.println();
					}
					//Print middle line of the diamond and go to the lower part
					//Increasing value from the beginning
					for (j = 1; j <= patternSize / 2 + 1 ; j++)
						System.out.print(j);
					//Then decrease value from the middle of the line
					for (j = patternSize / 2; j > 0 ; j--)
						System.out.print(j);
					
					//Continue to the lower part of the diamond (next line)
					System.out.println();
					
					//Draw lower part of the diamond
				  	for (i = 1; i <= patternSize / 2; i++){
						//Print spaces first
				  		for (j = 1; j <= i ; j++)
							System.out.print(" ");
						//Print numbers
				  		for (j = 1; j <= patternSize-(i*2); j++)
							System.out.print(j);
						System.out.println();
					}
				}
					System.out.println();
				
				break;
			}
			//After a pattern is displayed modify counter value in order to change the
			//initial question for the next loops.
			firstLoop = false;

		}
		// Condition that will always be true. The only way to get out of the loop
		//is by pressing 5 (break;)
		while (firstLoop == false); 
		
		System.out.println();			
		
		//End of program message.
		if (firstLoop == false)
			System.out.println("Hope you have enjoyed the triangles!\nEnd of program.");
		else
			System.out.println("Let's draw a triangle next time!\n\nEnd of program.");
	}
}
