import javax.swing.*;
import java.util.*;

public class HighScore {
	private DefaultListModel<String> dlm; 
	public HighScore() {
		dlm = new DefaultListModel<>();
	}

	public void addScore(int score) {
		String name = "";
		while(name.length() != 3) {
			name = JOptionPane.showInputDialog("Skriv in ditt namn( 3 bokstäver):");
		}
		dlm.addElement(name + ": " + score);
		sortListModel();
		if (dlm.size() > 10) {
			dlm.removeElementAt(10);
		}
	}

	private void sortListModel() {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < dlm.size(); i++) {
			list.add(dlm.getElementAt(i));
		}
		
		list.sort(new Comparator<String>() {
		 
		    public int compare(String element1, String element2) {
		        int score1 = Integer.parseInt(element1.split(": ")[1]);
		        int score2 = Integer.parseInt(element2.split(": ")[1]);
		        return Integer.compare(score2, score1); // Fallande ordning
		    }
		});

		dlm.clear();
		for (String entry : list) {
			dlm.addElement(entry);
		}
	}

	public DefaultListModel<String> getModel() {
		return dlm;
	}
}
