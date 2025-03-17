import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; // Man kanske kan ta bort dessa kodrader med import?
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

public class Program extends JFrame {
	private GameBoard board;
	private int score = 0;
	private JLabel highScoreLabel;
	private HighScore highScores;
	private LatestRun latestRun;
	private String namn = "Leo";
	private JPanel highPanel;
	private JPanel runPanel;
	private JLabel[] highLabel;
	private JLabel[] runLabel;	
	
	public Program() {
		highScores = new HighScore();
		latestRun = new LatestRun();
		board = new GameBoard(this);
		highPanel = new JPanel();
		runPanel = new JPanel();
		
		setLayout(new BorderLayout(30, 40));
		
		highPanel.setLayout(new BoxLayout(highPanel, BoxLayout.Y_AXIS));
		runPanel.setLayout(new BoxLayout(runPanel, BoxLayout.Y_AXIS));
		
		highPanel.add(new JLabel("Highscore"), BorderLayout.WEST);
		runPanel.add(new JLabel("Latest runs"), BorderLayout.EAST);
		
		add(board, BorderLayout.CENTER);
		add(highPanel,BorderLayout.WEST);
		add(runPanel,BorderLayout.EAST);
		
		highLabel = new JLabel[10];
		for(int i = 0; i<10; i++) {
			highLabel[i] = new JLabel("--");
			highPanel.add(highLabel[i]);
		}
		
		runLabel = new JLabel[3];
		for(int i = 0; i<3; i++) {
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
		highScores.addTenScores(score);
		latestRun.addScore(score);
		updateHighScoreDisplay();
		updateLatestRunDisplay();
		//System.out.println("Scorelogik var:" + score);
	}

	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	} 
	//Jag tänkte på det, eventuellt nice att ha en action listener om liv == 0 pga då kan man skapa en knapp som "Start game" istället, för lite estetiska anledningar.
	private void updateHighScoreDisplay() {
	    ArrayList<Integer> topScores = highScores.getScores();
	    for (int i = 0; i < highLabel.length; i++) {
	        if (i < topScores.size()) {
	            highLabel[i].setText(String.valueOf(topScores.get(i)));
	        } else {
	            highLabel[i].setText("--");
	        }
	    }
	}
	
	private void updateLatestRunDisplay() {
	    LinkedList<Integer> latestScores = latestRun.getLatestRuns(); 
	    for (int i = 0; i < runLabel.length; i++) {
	        if (i < latestScores.size()) {
	            runLabel[i].setText(String.valueOf(latestScores.get(i))); 
	        } else {
	            runLabel[i].setText("--"); 
	        }
	    }
	}
}	
