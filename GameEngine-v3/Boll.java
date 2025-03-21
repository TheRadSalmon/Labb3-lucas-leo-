import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Boll extends Sprite {
	private Boll boll;
	private int tickcount = Variables.tickcount; 
	private Color color;
	public int xV = Variables.bollStart_xV;
	public int yV = Variables.bollStart_yV;
	//Skapa scoreobjekt för hantering av poäng
	private int temp = Variables.bollTemp;
	
	Lives lives = new Lives(Variables.bollLiv);
	
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
	
	public void resetPos() {
		setX(Variables.bollStartX);
		setY(Variables.bollStartY);
	}
	
	public int returnLives() {
		return lives.getLives();
	}
	
	public void resetLiv() {
		lives.setLives(Variables.bollLiv);
	}
	

@Override
public void update(Keyboard keyboard){
	tickcount++;
	
	if(keyboard.isKeyDown(Key.Enter) && lives.getLives() > Variables.death && getX() == Variables.bollStartX && getY() == Variables.bollStartY) {
		int rand = (int)(Math.random()*Variables.bollmax_xV)+Variables.bollmin_xV;
		xV = rand;
		yV = -rand;
	}
	if(getX() <= Variables.bollLeftWall && getY()>Variables.bollTopWall) {
		xV = Math.abs(xV);
	}else if(getX()>=Variables.bollRightWall && getY()>Variables.bollTopWall) {
		xV = -Math.abs(xV);
	}else if(getX()!=Variables.bollLeftWall && getX()!= Variables.bollRightWall && getY()<=Variables.bollTopWall) {
		yV = Math.abs(yV);
	}else if(getY() >=Variables.bollBottomWall && lives.getLives()>Variables.death) {
		temp = lives.getLives();
		lives.setLives(lives.getLives()-Variables.minusLiv);
		if(temp > lives.getLives() && lives.getLives()>Variables.death) {
			resetPos();
			xV = Variables.bollStart_xV;
			yV = Variables.bollStart_yV;
		}
		
		resetPos();
		if(lives.getLives() <= Variables.death) {
			xV = Variables.bollStart_xV;
			yV = Variables.bollStart_yV;	
			
		}
	}
	
	if(tickcount % Variables.tickcountTick == Variables.tickcountCompare) {
		setX(getX()+ xV);
		setY(getY()+ yV);
	}
}




@Override
public void draw(Graphics2D graphics) {
		 graphics.setColor(color);
		 graphics.setFont(new Font("Arial", Font.BOLD, Variables.bollLivFontStorlek));
		 graphics.fillOval(getX(),getY(),getWidth(),getHeight());
		 graphics.drawString("Antal liv: " + lives.getLives(), Variables.livText_X, Variables.livText_Y);
		 if(lives.getLives()<=Variables.death) {
			 graphics.setFont(new Font("Arial", Font.BOLD, Variables.gameOverFontStorlek));
			 graphics.drawString("GAME OVER",Variables.gameover_X, Variables.gameover_Y);

		 }
}

@Override
public void update(Keyboard keyboard, SquareCollection square) {
	// TODO Auto-generated method stub
	
}
}
