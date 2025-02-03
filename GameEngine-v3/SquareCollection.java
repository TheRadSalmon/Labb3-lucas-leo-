import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class SquareCollection extends ColoredBox{
	private ArrayList<ColoredBox> fyrkanter;
	private int tickcount = 0;
	

	public SquareCollection(int x, int y, int width, int height) {
		super(x,y,width,height,Color.RED);
		fyrkanter = new ArrayList<>(10);
		for(int i = 0; i<10; i++) {
				fyrkanter.add(new RedBox(x + i*75 ,y, 30, 30));
		}
	}
	public void update(Keyboard keyboard){
		tickcount++;
		if(tickcount % 1 == 0) {
			for(ColoredBox box: fyrkanter) {
				box.setY(box.getY()+1);
				if(box.getY() > 570) {
					System.exit(0);
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
