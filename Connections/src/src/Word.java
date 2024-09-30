package src;

public class Word {
	
	String group;
	int difficulty;
	String word;
	
	public Word(String group, int difficulty, String word)
	{
		this.group = group;
		this.difficulty = difficulty;
		this.word = word;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
