import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*; //Kan eventuellt tas bort utan bekymmer
import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private Boll boll;
	private Bat bat;
	private SquareCollection fyrkanter;
	private SquareCollection fyrkanter2;

	private int totalScore = Variables.gameTotalScore;
	private int tempScore = Variables.gameTempScore;
	
	public Game(GameBoard board) {
	boll = new Boll(Variables.bollStartX,Variables.bollStartY,Variables.bollRadius,Color.ORANGE); 
	bat = new Bat(Variables.bat_X, Variables.bat_Y, Variables.bat_Width, Variables.bat_Height, Color.RED, boll);
	fyrkanter = new SquareCollection(Variables.fyrkant_X, Variables.fyrkant_Y1, Variables.fyrkant_Widht, Variables.fyrkant_Height, boll); 
	fyrkanter2 = new SquareCollection(Variables.fyrkant_X, Variables.fyrkant_Y2, Variables.fyrkant_Widht, Variables.fyrkant_Height, boll);
	}

	public void update(Keyboard keyboard, Program program) {
	boll.update(keyboard);
	fyrkanter.update(keyboard, fyrkanter);
	fyrkanter2.update(keyboard, fyrkanter2);
	bat.update(keyboard);
	
	totalScore = fyrkanter.getScore() + fyrkanter2.getScore() + tempScore; 
	
	if(boll.returnLives() <= Variables.death) {
		fyrkanter.clearSquares();
		fyrkanter2.clearSquares();
	}
		if(keyboard.isKeyDown(Key.Space) && boll.returnLives()<=Variables.death) {
			fyrkanter = new SquareCollection(Variables.fyrkant_X, Variables.fyrkant_Y1, Variables.fyrkant_Widht, Variables.fyrkant_Height, boll); 
			fyrkanter2 = new SquareCollection(Variables.fyrkant_X, Variables.fyrkant_Y2, Variables.fyrkant_Widht, Variables.fyrkant_Height, boll);
			boll.resetLiv();
			tempScore = 0;
		}
	if(fyrkanter.isEmpty() && fyrkanter2.isEmpty() && boll.returnLives()>Variables.death) {
		boll.resetPos();
		if(keyboard.isKeyDown(Key.Up) && boll.returnLives()>Variables.death) {
			tempScore = totalScore;
			fyrkanter = new SquareCollection(Variables.fyrkant_X, Variables.fyrkant_Y1, Variables.fyrkant_Widht, Variables.fyrkant_Height, boll); 
			fyrkanter2 = new SquareCollection(Variables.fyrkant_X, Variables.fyrkant_Y2, Variables.fyrkant_Widht, Variables.fyrkant_Height, boll);
		}
	}
}

	public void draw(Graphics2D graphics) {
	boll.draw(graphics);
	bat.draw(graphics);
	if(fyrkanter.isEmpty() && fyrkanter2.isEmpty() && boll.returnLives()>Variables.death) {
		graphics.drawString("Klicka pil upp för att fortsätta", Variables.levaText_X, Variables.levaText_Y);
	}
	fyrkanter.draw(graphics);
	fyrkanter2.draw(graphics);
	graphics.setColor(Color.WHITE);
	graphics.drawString("Total Poäng: " + totalScore, Variables.scoreText_X, Variables.scoreText_Y);
	}
	
	public int returnTotalScore() {
		return totalScore;
	}

}
