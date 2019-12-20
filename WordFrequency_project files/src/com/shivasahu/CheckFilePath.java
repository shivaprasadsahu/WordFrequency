package com.shivasahu;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckFilePath {

	public static boolean verifyFilePath(String fPath) {

		if (Files.exists(Paths.get(fPath))) {
			 if(fPath.substring(fPath.indexOf(".")+1).equalsIgnoreCase("txt")){
				 return true;
			 }
		}
		return false;
	}
}