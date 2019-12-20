package com.shivasahu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProcessFile {
	private String uFilePath = "";
	private Map<String, Map<String, Integer>> fmap = new HashMap<String, Map<String, Integer>>();
	private List<String> invalidFiles = new ArrayList<String>();

	public ProcessFile(String userFilePath) {
		this.uFilePath = userFilePath;
	}

	//get the data from the files
	public void getData() {
		String line;

		try (FileReader fr = new FileReader(new File(uFilePath));
				BufferedReader br = new BufferedReader(fr);) {
			while ((line = br.readLine()) != null) {
				if (CheckFilePath.verifyFilePath(line)) {
					fmap.put(line, new ProcessFileData().processData(line));

				} else {
					invalidFiles.add(line);
				}
			}

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
		}

		// Print invalid file path those could not be processed
		System.out.println("");
		System.out.println("Following files could not be found or processed: ");
		for (String s : invalidFiles) {
			System.out.println("\t" + s);
		}
	}
	
	//print the word counts form all the files
	public void printTotalsData() {
		Map<String, Integer> ptd = ProcessFileData.tmap;
		Set<String> ptdKeys = ptd.keySet();
				
		System.out.println("");
		System.out.println(" Words and Counts");
		for (String sKey : ptdKeys) {
			System.out.println("\t " + sKey + ": " + ptd.get(sKey));
		}
	}

	//print the detail for a word from all the files
	public void printWordData(String word){
		String srchWord = word;
		Integer totalCount=0;
		Set<String> ptdKeys = this.fmap.keySet();
		Map<String, Integer> pwdmap;		
		
		for (String sKey : ptdKeys) {
			pwdmap = this.fmap.get(sKey);
			for (String s : pwdmap.keySet()) {
				if(s.equalsIgnoreCase(srchWord)){
					totalCount += pwdmap.get(s);
					System.out.println("\t " + sKey + "file has: " + pwdmap.get(s) + " count.");
				}
			}
		}
		System.out.println("\t Total count form all the files: " + totalCount);
		System.out.println("");
	}
}
