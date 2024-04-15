package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class None extends PriorityQueue<Word> {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Word> readFile(File file, String seed) throws FileNotFoundException {
		Scanner s = new Scanner(file);
		Hashtable<String, Integer> table = new Hashtable<>();
		boolean foundSeed = false;
		while (s.hasNext()) {
			String str = s.next();
			str = str.split("[^a-zA-Z]")[0].toLowerCase();
			
			if (foundSeed) {
				foundSeed = false;
				if (str.length() != 0)
					if (table.containsKey(str)) table.put(str, table.get(str) + 1);					
					else table.put(str, 1);
			}
			if (str.equals(seed)) foundSeed = true;
		}
		s.close();
		ArrayList<Word> list = new ArrayList<>();
		for (Entry<String,Integer> word: table.entrySet())
			list.add(new Word(word.getKey(), word.getValue()));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> kLargest(ArrayList<Word> list, int k) {
		ArrayList<String> answer = new ArrayList<>();
		if (list.size() < 4000000 || k > Math.sqrt(list.size())) {
			list.sort(Comparator.naturalOrder());
			if (list.size() > k)
				for (int i = 0; i < k; i++) answer.add(list.get(i).word());
			else
				for (int i = 0; i < list.size(); i++) answer.add(list.get(i).word());
			return answer;
		} else {
			PriorityQueue<Word> pq = new PriorityQueue<>(list);
			for (int i = 0; i < k; i++) answer.add(pq.poll().word());
			return answer;
		}
	}
}
