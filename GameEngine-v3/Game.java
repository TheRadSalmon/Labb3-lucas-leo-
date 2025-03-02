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
	public int bollStartX = 390;
	public int bollStartY = 250;
	
	public Game(GameBoard board) {
	boll = new Boll(bollStartX,bollStartY,20,Color.ORANGE); //Ändra alla magic numbers till variabler
	bat = new Bat(200, 550, 75, 10, Color.RED, boll);
	fyrkanter = new SquareCollection(50, 0, 55, 20, boll); 
	fyrkanter2 = new SquareCollection(50, 100, 55, 20, boll);
	}

	public void update(Keyboard keyboard) {
	boll.update(keyboard);
	fyrkanter.update(keyboard, fyrkanter);
	fyrkanter2.update(keyboard, fyrkanter2);
	bat.update(keyboard);
	
	}

	public void draw(Graphics2D graphics) {
	boll.draw(graphics);
	bat.draw(graphics);
	fyrkanter.draw(graphics);
	fyrkanter2.draw(graphics);
	}
}
