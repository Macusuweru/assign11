package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextGenerator {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		String seed = args[1];
		int k = Integer.parseInt(args[2]);
		int setting = 0;
		if (args.length >= 4) {
			if (args[3].equals("one")) setting = 1;
			else if (args[3].equals("all")) setting = 2;
		}
		
		if (setting == 0) {
			for (String s: None.kLargest(None.readFile(file, seed), k))
				System.out.println(s);
		}
		
		
		
	}
}
