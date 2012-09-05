package brwyatt.brge.graphics.drawables;

import java.awt.Color;
import java.awt.Graphics;


public class YellowLaser implements Drawable{
	private int width=2;
	private int height=1;
	private int maxheight=20;

	private int x=0;
	private int y=0;
	
	private Color color=Color.yellow;

	public YellowLaser(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		g.setColor(tmp); //reset color
	}
	public void setWidth(int w) {
		//do nothing
	}
	public void setHeight(int h) {
		//do nothing
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		if(height<maxheight){
			int diff=this.y-y;
			height+=diff;
			if(height+diff>maxheight){
				height=maxheight;
			}
		}
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}