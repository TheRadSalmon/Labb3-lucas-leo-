import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;


public class SquareCollection extends ColoredBox{
	private ArrayList<ColoredBox> fyrkanter;
	private Boll boll;  

	public SquareCollection(int x, int y, int width, int height, Boll boll) {
		super(x,y,width,height,Color.RED);
		this.boll = boll; 
		fyrkanter = new ArrayList<>(10);
		for(int i = 0; i<10; i++) {
				fyrkanter.add(new RedBox(x + i*75 ,y, 30, 30));
		}
	}
	public void update(Keyboard keyboard, SquareCollection Square) {

	    for (int i = fyrkanter.size() - 1; i >= 0; i--) {
	        Rectangle bollrektangel = new Rectangle(boll.getX(), boll.getY(), boll.getWidth(), boll.getHeight());
	        Rectangle boxrektangel = new Rectangle(fyrkanter.get(i).getX(), fyrkanter.get(i).getY(), fyrkanter.get(i).getWidth(), fyrkanter.get(i).getHeight());

	        if (bollrektangel.intersects(boxrektangel)) {
	        	
	        	int fyrkantX = fyrkanter.get(i).getX();
	            int fyrkantY = fyrkanter.get(i).getY();
	            int fyrkantWidth = fyrkanter.get(i).getWidth();
	            int fyrkantHeight = fyrkanter.get(i).getHeight();
	            
	            fyrkanter.remove(i); 
	            
	            // vänster
	            if (boll.getX() + boll.getWidth() - boll.getxV() <= fyrkantX) {
	                boll.setxV(-boll.getxV()); 
	            }
	            // Kollision från höger
	            else if (boll.getX() - boll.getxV() >= fyrkantX + fyrkantWidth) {
	                boll.setxV(-boll.getxV()); 
	            }
	            // Kollision från ovan
	            else if (boll.getY() + boll.getHeight() - boll.getyV() <= fyrkantY) {
	                boll.setyV(-boll.getyV());
	            }
	            // Kollision från nedan
	            else if (boll.getY() - boll.getyV() >= fyrkantY + fyrkantHeight) {
	                boll.setyV(-boll.getyV()); 
	            }
	            
	        }
	    }
	}

	
	public void draw(Graphics2D graphics) {
	        for (ColoredBox box : fyrkanter) {
	            box.draw(graphics);
	        }
	}
	
	public ArrayList<ColoredBox> getFyrkanter(){
		return fyrkanter;
	}
	
	public void removeFyrkanter(ColoredBox box) {
		fyrkanter.remove(box);
	}
}
