import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private Boll boll;
	private Bat bat;
	private SquareCollection fyrkanter;
	
	public Game(GameBoard board) {
	boll = new Boll(390,250,20,Color.ORANGE);
	bat = new Bat(200, 550, 75, 10, Color.RED);
	fyrkanter = new SquareCollection(50, 0, 20, 20);
	}

	public void update(Keyboard keyboard) {
	boll.update(keyboard, fyrkanter);
	bat.update(keyboard, fyrkanter);
	}

	public void draw(Graphics2D graphics) {
	boll.draw(graphics);
	bat.draw(graphics);
	fyrkanter.draw(graphics);
	}
}
