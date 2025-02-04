import java.awt.Color;
import java.awt.Graphics2D;
public class Boll extends Sprite {
	private int tickcount = 0;
	private Color color;
	private int xV = 1;
	private int yV = -4;
public Boll(int x, int y, int diameter, Color color) {
	 super(x,y,diameter,diameter);
	 this.color = color;
}


@Override
public void update(Keyboard keyboard){
	tickcount++;
	if(getX() == 0 && getY()>0) {
		xV = 3;
	}else if(getX()>=780 && getY()>0) {
		xV = -3;
	}else if(getX()!=0 && getX()!= 780 && getY()<=0) {
		yV = 3;
	}else if(getY() >=580) {
		System.exit(0);
	}
	if(tickcount % 1 == 0) {
		setX(getX()+ xV);
		setY(getY()+ yV);
	}
	
}
@Override
public void draw(Graphics2D graphics) {
	 graphics.setColor(color);
	 graphics.fillOval(getX(),getY(),getWidth(),getHeight());
}
}
