package brwyatt.brge.graphics.drawables;

import java.awt.Color;
import java.awt.Graphics;

public class Player implements Drawable{
	private int width=75;
	private int height=50;

	private int x=0;
	private int y=0;
	
	public Player(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(new Color(0,255,0));
		g.fillRect(x+37, y, 2, height);
		
		g.setColor(new Color(0,240,0));
		g.fillRect(x+36, y+2, 1, height-2);
		g.fillRect(x+39, y+2, 1, height-2);
		
		g.setColor(new Color(0,225,0));
		g.fillRect(x+35, y+4, 1, height-4);
		g.fillRect(x+40, y+4, 1, height-4);
		
		g.setColor(new Color(0,210,0));
		g.fillRect(x+34, y+8, 1, height-8);
		g.fillRect(x+41, y+8, 1, height-8);
		
		g.setColor(new Color(0,195,0));
		g.fillRect(x+33, y+12, 1, height-12);
		g.fillRect(x+42, y+12, 1, height-12);
		
		g.setColor(new Color(0,150,0));
		g.fillRect(x+30, y+15, 3, height-20);
		g.fillRect(x+43, y+15, 3, height-20);
		
		g.fillRect(x+27, y+20, 3, height-25);
		g.fillRect(x+46, y+20, 3, height-25);
		
		g.fillRect(x+24, y+23, 3, height-27);
		g.fillRect(x+49, y+23, 3, height-27);

		g.fillRect(x+20, y+26, 4, height-29);
		g.fillRect(x+52, y+26, 4, height-29);
		
		g.fillRect(x+16, y+28, 4, height-31);
		g.fillRect(x+56, y+28, 4, height-31);
		
		g.fillRect(x+12, y+30, 4, height-33);
		g.fillRect(x+60, y+30, 4, height-33);
		
		g.fillRect(x+8, y+32, 4, height-35);
		g.fillRect(x+64, y+32, 4, height-35);
		
		g.setColor(new Color(0,185,0));
		g.fillRect(x+6, y+20, 2, height-20);
		g.fillRect(x+68, y+20, 2, height-20);
		
		g.setColor(new Color(0,220,0));
		g.fillRect(x+4, y+18, 2, height-18);
		g.fillRect(x+70, y+18, 2, height-18);
		
		g.setColor(new Color(0,185,0));
		g.fillRect(x+2, y+20, 2, height-20);
		g.fillRect(x+72, y+20, 2, height-20);
		
		//g.setColor(Color.RED);
		//g.drawRect(x, y, width, height);
		
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
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}