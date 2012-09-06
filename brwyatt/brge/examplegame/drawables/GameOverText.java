package brwyatt.brge.examplegame.drawables;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import brwyatt.brge.graphics.drawables.Drawable;

public class GameOverText implements Drawable{
	private int width=0;
	private int height=0;

	private int x=0;
	private int y=0;
	
	private String text="LEVEL PASSED";
	
	private Font font;
	
	public GameOverText(int x, int y){
		this.x=x;
		this.y=y;
		
		font=new Font("Monospaced", Font.BOLD, 100);
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		Font tmpFont=g.getFont();
		
		FontMetrics metrics = g.getFontMetrics(font);
		height = (metrics.getAscent()/2)+50;
		width = metrics.stringWidth(text)+50;
		
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
		
		g.setColor(Color.YELLOW);
		g.setFont(font);
		g.drawString(text, x+25, y+75);
		
		g.setColor(tmp); //reset color
		g.setFont(tmpFont); //reset font
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