package comprehensive;

public class Word implements Comparable {
	private String word;
	private int count;
	public Word(String word) {
		this.word = word;
		this.count = 1;
	}
	public Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
	public int increment() {
		return ++this.count;
	}
	public String word() {
		return this.word;
	}
	public int count() {
		return this.count;
	}
	public int setCount(int count) {
		int r = this.count;
		this.count = count;
		return r;
	}
	@Override
	public int compareTo(Object arg0) {
		return this.count - ((Word) arg0).count;
	}
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Word)) return false;
		return this.word.equals(((Word) other).word());
	}
}
