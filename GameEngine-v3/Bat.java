import java.awt.Graphics2D;
import java.awt.Color;


public class Bat extends Sprite{
	private Color color;
	public Bat(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
	}
	public void update(Keyboard keyboard) {
		if(keyboard.isKeyDown(Key.Left) == true && getX()>0) {
			setX(getX()-7);
		}
		if(keyboard.isKeyDown(Key.Right) == true && getX()<725) {
			setX(getX()+7);
		}
		
	}
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		graphics.setColor(color.WHITE);
		graphics.drawString("LBLJ", getX()+23, getY()+9);
	}
}
