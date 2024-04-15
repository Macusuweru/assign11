package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class All {
	public static Hashtable<Word, Hashtable<String, Integer>> readFile(File file, String seed) throws FileNotFoundException {
		Scanner s = new Scanner(file);
		Hashtable<Word, Hashtable<String, Integer>> table = new Hashtable<>();
		Hashtable<String, Word> words = new Hashtable<>();
		
		String str = "";
		String prev;
		while (s.hasNext()) {
			prev = str; 
			str = s.next();
			str = str.split("[^a-zA-Z]")[0].toLowerCase();
			
			if (prev.length() == 0 || str.length() == 0) continue;
			
			if (words.contains(prev)) words.get(prev).increment();
			else words.put(prev, new Word(prev));
			Word word = words.get(prev);
			
			if (table.contains(word)) {
				
				if (table.get(word).contains(str)) {
					table.get(word).put(str, table.get(word).get(str)+ 1);
					
				} else {
					table.get(word).put(str, 1);
				}
			} else {
				Hashtable<String, Integer> input = new Hashtable<>();
				input.put(str, 1);
				table.put(word, input);
			}
		}
		s.close();
		return table;
	}
}
