package nl.noscope.emeraldextraction;

public class Score {

	private int score;
	private int levelNumber;
	
	public Score(int score, int levelNumber) {
		this.score = score;
		this.levelNumber = levelNumber;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
	
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
}
