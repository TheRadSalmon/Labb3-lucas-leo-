import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private Boll boll;
	
	public Game(GameBoard board) {
	boll = new Boll(300,400,20,Color.ORANGE);
	}

	public void update(Keyboard keyboard) {
	boll.update(keyboard);
	}

	public void draw(Graphics2D graphics) {
	boll.draw(graphics);
	}
}
