import java.awt.Graphics2D;
import java.awt.Color;

public class RedBox extends ColoredBox {
	private int hitsRequired;
	public RedBox(int x, int y, int width, int height, int hitsRequired) {
		super(x,y,width,height,Color.RED, hitsRequired);
		this.hitsRequired = hitsRequired;
	}
}
