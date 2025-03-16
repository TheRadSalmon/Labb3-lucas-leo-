import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;



public class SquareCollection{
	private ArrayList<ColoredBox> fyrkanter;
	private Boll boll;
	private ScoreClass score = new ScoreClass();
	
	public SquareCollection(int x, int y, int width, int height, Boll boll) {
		this.boll = boll; 
		fyrkanter = new ArrayList<>(Variables.antalRutor);
		for(int i = Variables.startIndex; i<Variables.antalRutor; i++) {
				int hitsRequired = (int)(Math.random() *Variables.maxStuds)+Variables.minStuds;
				if(hitsRequired == Variables.greenHit) {
					fyrkanter.add(new GreenBox(x + i*Variables.mellanRum ,y, width, height, hitsRequired));
				}else if(hitsRequired == Variables.yellowHit) {
					fyrkanter.add(new YellowBox(x + i*Variables.mellanRum ,y, width, height, hitsRequired));
				}else if(hitsRequired == Variables.redHit) {
					fyrkanter.add(new RedBox(x + i*Variables.mellanRum ,y, width, height, hitsRequired));
				}
		}
	}
	public Color getColor(int hitsRequired) {
		if(hitsRequired == Variables.greenHit) {
			return Color.GREEN;
		}else if(hitsRequired == Variables.yellowHit) {
			return Color.YELLOW;
		}else if(hitsRequired == Variables.redHit) {
		return Color.RED;
		}else {
			return Color.GRAY;
		}
}
	public int getScore() {
		return score.getTempScore();
	}

	public void update(Keyboard keyboard, SquareCollection Square) {

	    for (int i = fyrkanter.size() - Variables.sistaIndex; i >= Variables.startIndex; i--) { 
	    	ColoredBox fyrkant = fyrkanter.get(i);
	    	
	        Rectangle bollrektangel = new Rectangle(boll.getX(), boll.getY(), boll.getWidth(), boll.getHeight());
	        Rectangle boxrektangel = new Rectangle(fyrkanter.get(i).getX(), fyrkanter.get(i).getY(), fyrkanter.get(i).getWidth(), fyrkanter.get(i).getHeight());

	        if (bollrektangel.intersects(boxrektangel)) {
	        	fyrkant.hit();
	        	
	        	int fyrkantX = fyrkanter.get(i).getX();
	            int fyrkantY = fyrkanter.get(i).getY();
	            int fyrkantWidth = fyrkanter.get(i).getWidth();
	            int fyrkantHeight = fyrkanter.get(i).getHeight();
	            
	            if(fyrkant.getColor() == Color.GREEN) {
	            	score.addPoints(Variables.greenPoint);
	            }
	            if(fyrkant.getColor() == Color.YELLOW) {
	            	score.addPoints(Variables.yellowPoint);
	            }
	            if(fyrkant.getColor() == Color.RED) {
	            	score.addPoints(Variables.redPoint);
	            }
	            
	            if(fyrkant.isDestroyed()) {
	            	fyrkanter.remove(i);
	            }
	            
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
	
	public boolean isEmpty() {
		return fyrkanter.isEmpty();
	}
	
	public void clearSquares() {
		fyrkanter.clear();
	}
	
	public void draw(Graphics2D graphics) {
	        for (ColoredBox box : fyrkanter) {
	            box.draw(graphics);
	        }
	}
}
