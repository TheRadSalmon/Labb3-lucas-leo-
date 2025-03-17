import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Program extends JFrame {
	private GameBoard board;
	private int score = 0;
	private HighScore highScores;
	private LatestRun latestRuns;
	private JPanel highPanel;
	private JPanel runPanel;
	private JLabel[] highLabel;
	private JLabel[] runLabel;

	public Program() {
		highScores = new HighScore();
		latestRuns = new LatestRun();
		board = new GameBoard(this);
		highPanel = new JPanel();
		runPanel = new JPanel();

		setLayout(new BorderLayout(30, 40));

		highPanel.setLayout(new BoxLayout(highPanel, BoxLayout.Y_AXIS));
		runPanel.setLayout(new BoxLayout(runPanel, BoxLayout.Y_AXIS));

		highPanel.add(new JLabel("Highscore"), BorderLayout.WEST);
		runPanel.add(new JLabel("Latest runs"), BorderLayout.EAST);

		add(board, BorderLayout.CENTER);
		add(highPanel, BorderLayout.WEST);
		add(runPanel, BorderLayout.EAST);

		highLabel = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			highLabel[i] = new JLabel("--");
			highPanel.add(highLabel[i]);
		}

		runLabel = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			runLabel[i] = new JLabel("--");
			runPanel.add(runLabel[i]);
		}

		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}

	public void updateScore(int newScore) {
		score = newScore;
		System.out.println("Updating score: " + newScore);
		highScores.addScore(score); 
		latestRuns.addScore(score); 
		updateHighScoreDisplay();
		updateLatestRunDisplay();
	}

	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

	private void updateHighScoreDisplay() {

		DefaultListModel<String> topScores = highScores.getModel();

		for (int i = 0; i < highLabel.length; i++) {
			if (i < topScores.size()) {
				highLabel[i].setText(topScores.getElementAt(i)); 
			} else {
				highLabel[i].setText("--");
			}
		}
	}

	private void updateLatestRunDisplay() {

		DefaultListModel<String> latestScores = latestRuns.getModel();

		for (int i = 0; i < runLabel.length; i++) {
			if (i < latestScores.size()) {
				runLabel[i].setText(latestScores.getElementAt(i)); 
			} else {
				runLabel[i].setText("--");
			}
		}
	}
}
