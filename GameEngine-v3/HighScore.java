import java.util.*;

import javax.swing.*;

public class HighScore {

	private DefaultListModel<String> dlm;
	private JList<String> highScores;
	private ArrayList<Integer> scores; 
	
	public HighScore() {
		dlm = new DefaultListModel<>();
		highScores = new JList<>(dlm);
		scores = new ArrayList<>();
	}
	
	public void addTenScores(int score) {
		if(scores.size()<10) {
			scores.add(score);
			scores.sort(Collections.reverseOrder());
		}else {
			int min = Collections.min(scores);
			if(score>min) {
				scores.remove(Integer.valueOf(min));
				scores.add(score);
			}
		}
		scores.sort(Collections.reverseOrder());
		
	}
	
	
	public void saveScores() {
		
	}
	
	public void loadScores() {
		
	}
	public ArrayList<Integer> getScores() {
	    return new ArrayList<>(scores); // Returnera en kopia av listan
	}

}
