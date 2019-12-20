package com.shivasahu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ProcessFileData {
	static Map<String,Integer> tmap = new TreeMap<String,Integer>();
	
	public Map<String,Integer> processData(String filePath) {
		String sLine;
		String[] words;
		Map<String,Integer> wmap = new TreeMap<String,Integer>();
		
		
		try (FileReader fr = new FileReader(new File(filePath));
				BufferedReader br = new BufferedReader(fr);) {
			while ((sLine = br.readLine()) != null) {
				words = sLine.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
				
				for (String w : words) {
					if(wmap.containsKey(w)){
						wmap.put(w,wmap.get(w)+1);
					} else {
						wmap.put(w, 1);
					}
					
					if(tmap.containsKey(w)){
						tmap.put(w,tmap.get(w)+1);
					} else {
						tmap.put(w, 1);
					}
				}
			}

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
		}
		return wmap;
	}

}
