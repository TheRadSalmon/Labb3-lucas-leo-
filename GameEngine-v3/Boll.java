import java.awt.Color;
import java.awt.Graphics2D;
public class Boll extends Sprite {
private Color color;
public Boll(int x, int y, int diameter, Color color) {
	 super(x,y,diameter,diameter);
	 this.color = color;
}
@Override
public void update(Keyboard keyboard){
	
}
@Override
public void draw(Graphics2D graphics) {
	 graphics.setColor(color);
	 graphics.fillOval(getX(),getY(),getWidth(),getHeight());
}
}
