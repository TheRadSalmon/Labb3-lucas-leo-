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


@Override //DENNA Override kanske ska tas bort men behåller för att inte man ska fucka koden
public void update(Keyboard keyboard, SquareCollection square){
	tickcount++;
	if(getX() == 0 && getY()>0) {
		xV = 3;
	}else if(getX()>=780 && getY()>0) {
		xV = -3;
	}else if(getX()!=0 && getX()!= 780 && getY()<=0) {
		yV = 3;
	}else if(getY() >=580) {
		System.exit(0);;
	}
	
	for(ColoredBox box: square.getFyrkanter()) { // Här behövs det fixas med att ta bort loopen för om inte tas allting bort
		if(bollIntSquare(box)) {
			square.removeFyrkanter(box); //Problemet är troligen for each loopen som gör så att alla boxar av typen ColoredBox raderas.
			if(yV==3) {
				yV = -3;
			}else if(yV == -3) {
				yV = 3;
			}
			break;
		}
	}
		
	if(tickcount % 1 == 0) {
		setX(getX()+ xV);
		setY(getY()+ yV);
	}
	
}
	boolean bollIntSquare(ColoredBox box) {
	int bollmittX = (getX() + getWidth())/ 2;
	int bollmittY = (getY() + getHeight())/ 2;
	
	int fyrkantX = (box.getX() + box.getWidth())/ 2;
	int fyrkantY = (box.getY() + box.getHeight())/ 2;
	
	
	int fyrkanthoger = box.getX() + (box.getWidth()/2);
	int fyrkantvenster = box.getX();
	int fyrkantned = box.getY() + (box.getHeight()/2);
	int fyrkantupp = box.getY();
	
	int closeX = bollmittX;
	int closeY = bollmittY;
	
	
	if (bollmittX < fyrkantvenster) {
        closeX = fyrkantvenster;
    } else if (bollmittX > fyrkanthoger) {
        closeX = fyrkanthoger;
    }
    if (bollmittY < fyrkantupp) {
        closeY = fyrkantupp;
    } else if (bollmittY > fyrkantned) {
        closeY = fyrkantned;
    }
	
    int avstandX = bollmittX - closeX;
    int avstandY = bollmittY - closeY;
    
    if((avstandX * avstandX + avstandY * avstandY )<= (getWidth()/2)*(getWidth()/2)) {
    	return true;
    }else { // Kanske titta på varför den inte returnerar true även om villkoret stämmer
    	return true;
    }
}


@Override
public void draw(Graphics2D graphics) {
	 graphics.setColor(color);
	 graphics.fillOval(getX(),getY(),getWidth(),getHeight());
}
}
