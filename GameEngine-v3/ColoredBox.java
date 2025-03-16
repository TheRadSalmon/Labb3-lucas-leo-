import java.awt.Color;
import java.awt.Graphics2D;
public class ColoredBox extends Sprite {
	private int hitsRequired;
	
	private Color color;
	public ColoredBox(int x, int y, int width, int height, Color color, int hitsRequired) {
		super(x,y,width,height);
		this.color = color;
		this.hitsRequired = hitsRequired;
	}
	
	@Override
	public void update(Keyboard keyboard) {
	
	}
	
	public int getHits() {
		return hitsRequired;
	}
	
	public void hit() {
		if(hitsRequired>Variables.boxDestroyed) {
			hitsRequired--;	
		}
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean isDestroyed() {
		return hitsRequired<=Variables.boxDestroyed;
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void update(Keyboard keyboard, SquareCollection square) {
		// TODO Auto-generated method stub
		
	}
}
