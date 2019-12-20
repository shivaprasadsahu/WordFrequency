package com.shivasahu;

import java.util.Scanner;

public class UserOptions {
	Scanner s = new Scanner(System.in);
	int userCodeResponse = -1;

	public int printOptions(int iterationCount) {
		if (iterationCount == 0) {
			System.out.println("Select from the following options: ");
			System.out.println("\t Enter 1 to get all words count. ");
			System.out.println("\t Enter 0 to exit. ");

			userCodeResponse = this.optionCheck(0);			
		} else {
			System.out.println("");
			System.out.println("Select from the following options: ");
			//System.out.println("\t Enter 1 to get all words count. ");
			System.out.println("\t Enter 2 to get details for a word. ");
			System.out.println("\t Enter 0 to exit. ");
			
			userCodeResponse = this.optionCheck(1);	
		}
		
		return userCodeResponse;

	}

	public int optionCheck(int iterationCount) {
		double userCodeResponse1 = -1;
		while (true) {
			try {
				userCodeResponse1 = Integer.parseInt(s.nextLine());
				
				if (iterationCount == 0 && (userCodeResponse1 == 1 || userCodeResponse1 == 0) ) {
					break;
				} else if (iterationCount != 0 && (userCodeResponse1 == 2  || userCodeResponse1 == 0)) {
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Provide a proper option or Enter 0 to exit: ");
			}
		}
		return (int)userCodeResponse1;
	}

}