import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;


public class Bat extends Sprite {
	private Color color;
	private Boll boll;
	public Bat(int x, int y, int width, int height, Color color, Boll boll) {
		super(x, y, width, height);
		this.color = color;
		this.boll = boll;
	}
	
	public void update(Keyboard keyboard) {
		if(keyboard.isKeyDown(Key.Left) == true && getX()>Variables.leftWall) {
			setX(getX()-Variables.batSpeed); 
		}
		if(keyboard.isKeyDown(Key.Right) == true && getX()<Variables.rightWall) {
			setX(getX()+Variables.batSpeed);
		}
		
		Rectangle batRekt = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle bollRekt = new Rectangle(boll.getX(), boll.getY(), boll.getWidth(), boll.getHeight());
		
		if(bollRekt.intersects(batRekt)) {
			int batX = getX();
            int batY = getY();
            int batWidth = getWidth();
            int batHeight = getHeight();
            if (boll.getX() + boll.getWidth() - boll.getxV() <= batX) {
                boll.setxV(-boll.getxV()); 
            } else if (boll.getX() - boll.getxV() >= batX + batWidth) {
                boll.setxV(-boll.getxV()); 
            }else if (boll.getY() + boll.getHeight() - boll.getyV() <= batY) {
                boll.setyV(-boll.getyV());
            }else if (boll.getY() - boll.getyV() >= batY + batHeight) {
                boll.setyV(-boll.getyV()); 
            }

		}
	}
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.setFont(new Font("Arial", Font.BOLD, Variables.batFontStorlek));
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		graphics.setColor(color.WHITE);
		graphics.drawString("LBLJ", getX()+Variables.batText_X, getY()+Variables.batText_Y);
	}

	@Override
	public void update(Keyboard keyboard, SquareCollection square) {
		// TODO Auto-generated method stub
		
	}
}
