import java.awt.Graphics2D;
import java.awt.Color;


public class Bat extends Sprite {
	private Color color;
	private Boll boll;
	public Bat(int x, int y, int width, int height, Color color, Boll boll) {
		super(x, y, width, height);
		this.color = color;
		this.boll = boll;
	}
	
	public void update(Keyboard keyboard, SquareCollection square) {
		if(keyboard.isKeyDown(Key.Left) == true && getX()>0) {
			setX(getX()-7);
		}
		if(keyboard.isKeyDown(Key.Right) == true && getX()<725) {
			setX(getX()+7);
		}
		
		if(boll.getX() <= getX() + getWidth() && boll.getX() >= getX() && (boll.getY()) + boll.getHeight() >= getY()) { // getHeight() eventuellt. Här är problemet
		    if(boll.getyV() > 0) {
		    	boll.setyV(-boll.getyV());
		    	System.out.println("Ovan Studs");
		    }
		}else if(boll.getX() + boll.getWidth() >= getX() && boll.getX() < getX() && boll.getY() + boll.getHeight() >= getY() && boll.getY() <= getY() + getHeight()) {
		    if(boll.getxV() > 0) {
		    	System.out.println("Vänster Studs");
		    	boll.setxV(-Math.abs(boll.getxV()));
		    }
		}else if(boll.getX() <= getX() + getWidth() && boll.getX() + boll.getWidth() > getX() + getWidth() && boll.getY() + boll.getHeight() >= getY() && boll.getY() <= getY() + getHeight()) {
		    if(boll.getxV() < 0) {
		    	System.out.println("Höger Studs");
		        boll.setxV(Math.abs(boll.getxV()));
		    }
		}

	}
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		graphics.setColor(color.WHITE);
		graphics.drawString("LBLJ", getX()+23, getY()+9);
	}
}
