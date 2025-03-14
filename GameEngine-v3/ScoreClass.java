
public class ScoreClass {
	private int score = 0;
	public ScoreClass() {
		this.score = 0;
	}
	
	public int getTempScore() {
		return score;
	}
	
	 public void addPoints(int points) {
		 score+=points;
	 }
}
