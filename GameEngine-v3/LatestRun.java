import javax.swing.*;

public class LatestRun {
	private DefaultListModel<String> dlm;

	public LatestRun() {
		dlm = new DefaultListModel<>();
	}
	public void addScore(int score) {
		dlm.add(0,"Poäng: " + score);
		if (dlm.size() > 3) {
			dlm.removeElementAt(3);
		}
	}
	public DefaultListModel<String> getModel() {
		return dlm;
	}
}
