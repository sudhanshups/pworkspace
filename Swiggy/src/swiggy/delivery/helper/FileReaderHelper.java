package swiggy.delivery.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderHelper {
	
	public static String readFile(String filePath) {
		Scanner sc=null;
		StringBuilder sb = new StringBuilder();
		try {
			sc = new Scanner(new File(filePath));
			while(sc.hasNextLine()) {
				sb.append(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect File Path");
			return null;
		}finally {
			if(null != sc) {
				sc.close();
			}
		}
		
		return sb.toString().trim();
	}
}
