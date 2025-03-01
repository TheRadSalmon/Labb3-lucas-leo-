import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;



public class SquareCollection extends ColoredBox{
	private ArrayList<ColoredBox> fyrkanter;
	private Boll boll;
	//private Score score;
	//private Program program;

	public SquareCollection(int x, int y, int width, int height, Boll boll) {
		super(x,y,width,height,Color.RED);
		this.boll = boll; 
		//this.program = program;
		fyrkanter = new ArrayList<>(10);
		//score = new Score(0);
		for(int i = 0; i<10; i++) {
				fyrkanter.add(new RedBox(x + i*75 ,y, width, height)); //Jag ändrade dessa variabler till width och height istället för magic numbers så att man även kan ändra ifrån game.
		}
	}
	
	/*public Score getScore() {
		return score;
	}*/
	
	public void update(Keyboard keyboard, SquareCollection Square) {

	    for (int i = fyrkanter.size() - 1; i >= 0; i--) {
	        Rectangle bollrektangel = new Rectangle(boll.getX(), boll.getY(), boll.getWidth(), boll.getHeight());
	        Rectangle boxrektangel = new Rectangle(fyrkanter.get(i).getX(), fyrkanter.get(i).getY(), fyrkanter.get(i).getWidth(), fyrkanter.get(i).getHeight());

	        if (bollrektangel.intersects(boxrektangel)) {
	        	
	        	int fyrkantX = fyrkanter.get(i).getX();
	            int fyrkantY = fyrkanter.get(i).getY();
	            int fyrkantWidth = fyrkanter.get(i).getWidth();
	            int fyrkantHeight = fyrkanter.get(i).getHeight();
	            
	            //score.setScore(score.getScore()+1);
	            //System.out.println("Score: " + score.getScore()); // Kodsnutt för att titta om poängen funkar, kan tas bort sen.
	            fyrkanter.remove(i);
	            //program.updateScore(score.getScore());
	            
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
}
