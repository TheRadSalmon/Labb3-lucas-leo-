import java.awt.Color;
import java.util.Iterator;
import java.awt.Graphics2D;
public class Boll extends Sprite {
	private int tickcount = 0;
	private Color color;
	public int xV = 3;
	public int yV = -4;
public Boll(int x, int y, int diameter, Color color) {
	 super(x,y,diameter,diameter);
	 this.color = color;
}

	public int getxV(){
		return xV;
	}
	public int getyV() {
		return yV;
	}
	public void setxV(int xV) {
		this.xV = xV;
	}
	public void setyV(int yV) {
		this.yV = yV;
	}

@Override
public void update(Keyboard keyboard, SquareCollection square){
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
