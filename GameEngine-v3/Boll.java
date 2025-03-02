import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Boll extends Sprite {
	private int tickcount = 0;
	private Color color;
	public int xV = 0;
	public int yV = 0;
	private int totalScore  = 0; 

	public int bollStartX = 390;
	public int bollStartY = 250;
	private int temp = 0;
	
	Lives lives = new Lives(3);
	
	public Boll(int x, int y, int diameter, Color color) {
	 super(x,y,diameter,diameter);
	 this.color = color;
}
	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore; 
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
	
	public void resetPos() {
		setX(bollStartX);
		setY(bollStartY);
	}

@Override
public void update(Keyboard keyboard){
	tickcount++;
	if(keyboard.isKeyDown(Key.Enter) && lives.getLives() > 0) {
		int rand = (int)(Math.random()*7)+4;
		xV = rand;
		yV = -rand;
	}
	if(getX() <= 0 && getY()>0) {
		xV = Math.abs(xV);
	}else if(getX()>=780 && getY()>0) {
		xV = -Math.abs(xV);
	}else if(getX()!=0 && getX()!= 780 && getY()<=0) {
		yV = Math.abs(yV);
	}else if(getY() >=580 && lives.getLives()>0) {
		temp = lives.getLives();
		lives.setLives(lives.getLives()-1);
		if(temp > lives.getLives() && lives.getLives()>0) {
			resetPos();
			xV = 0;
			yV = 0;
		}
		resetPos();
		if(lives.getLives() <= 0) {
			xV = 0;
			yV = 0;
			
		}
		System.out.println("Liv: " + lives.getLives());
		
	}
	
	if(tickcount % 1 == 0) {
		setX(getX()+ xV);
		setY(getY()+ yV);
	}
}




@Override
public void draw(Graphics2D graphics) {
		 graphics.setColor(color);
		 graphics.setFont(new Font("Arial", Font.BOLD, 11));
		 graphics.fillOval(getX(),getY(),getWidth(),getHeight());
		 graphics.drawString("Antal liv: " + lives.getLives(), 390, 530);
		 if(lives.getLives()<=0) {
			 graphics.setFont(new Font("Arial", Font.BOLD, 100));

		 }
		 
}

@Override
public void update(Keyboard keyboard, SquareCollection square) {
	// TODO Auto-generated method stub
	
}
}
