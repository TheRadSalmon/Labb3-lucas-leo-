import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; // Man kanske kan ta bort dessa kodrader med import?
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	private int score = 0;
	private JLabel scoreLabel;
	public Program() {
		board = new GameBoard(this);
		setLayout(new BorderLayout(30, 40));
		scoreLabel = new JLabel("Highscore" + score);
		add(board, BorderLayout.CENTER);
		add(scoreLabel,BorderLayout.WEST);
		
		add(new JLabel("Latest runs: "), BorderLayout.EAST);
		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	public void updateScore(int newScore) {
		score = newScore;
		scoreLabel.setText("Highscore" + score);
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

}
