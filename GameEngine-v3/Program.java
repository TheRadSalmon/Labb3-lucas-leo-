import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	public Program() {
		board = new GameBoard();
		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		add(new JLabel("Highscore"), BorderLayout.WEST);
		add(new JLabel("Latest runs"), BorderLayout.EAST);
		add(new JLabel("Score: "), BorderLayout.NORTH); // Här vill jag försöka centrera och justera borderlayouten på mitt nuvarande score. 
		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}

	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
