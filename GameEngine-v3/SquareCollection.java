import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;



public class SquareCollection{
	private ArrayList<ColoredBox> fyrkanter;
	private Boll boll;
	private int score = 0;
	
	public SquareCollection(int x, int y, int width, int height, Boll boll) {
		this.boll = boll; 
		fyrkanter = new ArrayList<>(10);
		for(int i = 0; i<10; i++) {
				int hitsRequired = (int)(Math.random() *3)+1;
				if(hitsRequired == 1) {
					fyrkanter.add(new GreenBox(x + i*75 ,y, width, height, hitsRequired));
				}else if(hitsRequired == 2) {
					fyrkanter.add(new YellowBox(x + i*75 ,y, width, height, hitsRequired));
				}else if(hitsRequired == 3) {
					fyrkanter.add(new RedBox(x + i*75 ,y, width, height, hitsRequired));
				}
		}
	}
	
	public int getScore() {
		return score;
	}
	public void update(Keyboard keyboard, SquareCollection Square) {

	    for (int i = fyrkanter.size() - 1; i >= 0; i--) {
	    	ColoredBox fyrkant = fyrkanter.get(i);
	    	
	        Rectangle bollrektangel = new Rectangle(boll.getX(), boll.getY(), boll.getWidth(), boll.getHeight());
	        Rectangle boxrektangel = new Rectangle(fyrkanter.get(i).getX(), fyrkanter.get(i).getY(), fyrkanter.get(i).getWidth(), fyrkanter.get(i).getHeight());

	        if (bollrektangel.intersects(boxrektangel)) {
	        	fyrkant.hit();
	        	
	        	int fyrkantX = fyrkanter.get(i).getX();
	            int fyrkantY = fyrkanter.get(i).getY();
	            int fyrkantWidth = fyrkanter.get(i).getWidth();
	            int fyrkantHeight = fyrkanter.get(i).getHeight();
	            
	            if(fyrkant.isDestroyed() == true) {
	            	fyrkanter.remove(i);
	            }
	            score++;
	            System.out.println("Score: " + score); // Kodsnutt för att titta om poängen funkar, kan tas bort sen.
	            
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
	        graphics.drawString("Poäng: " + score, 390, 545);
	}
}
