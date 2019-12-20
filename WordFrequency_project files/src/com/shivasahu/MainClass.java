package com.shivasahu;

import java.util.Scanner;

public class MainClass {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int userCodeResponse = -1;
		String filePath = "";

		// show user options and process
		UserOptions up = new UserOptions();
		userCodeResponse = up.printOptions(0);

		while (userCodeResponse != 0) {
			// get the file to process and validate the file path
			System.out.println("Provide the file path to process: ");
			while (true) {
				filePath = s.nextLine();
				if (CheckFilePath.verifyFilePath(filePath)) {
					break;
				} else {
					System.out
							.println("Provide a valid file path to process: ");
				}
			}

			ProcessFile pf = new ProcessFile(filePath);
			pf.getData();
			pf.printTotalsData();

			userCodeResponse = up.printOptions(1);

			while (userCodeResponse != 0) {
				if (userCodeResponse == 2) {
					System.out
							.println("Enter a word to search in all the files: ");
					pf.printWordData(s.nextLine());
				}
				userCodeResponse = up.printOptions(1);
			}
		}
		System.out.println("************** Application Ended ****************");
	}
}
