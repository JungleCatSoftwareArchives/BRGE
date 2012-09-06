package net.brwyatt.brge.examplegame.drawables;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import net.brwyatt.brge.graphics.drawables.Drawable;


public class PauseMenuOverlayBackground implements Drawable {
	private int width=400;
	private int height=400;

	private int x=200;
	private int y=100;
	
	private Color bgColor=new Color(0,0,100);
	private Color fgColor=Color.yellow;

	public void draw(Graphics g) {
		Color tmp=g.getColor();
		Font f=g.getFont();
		
		g.setColor(bgColor);
		g.fillRect(x, y, width, height);
		
		g.setColor(fgColor);
		g.drawRect(x, y, width, height);
		g.drawRect(x+1, y+1, width-2, height-2);
		g.drawRect(x+2, y+2, width-4, height-4);
		g.drawRect(x+3, y+3, width-6, height-6);
		g.drawRect(x+4, y+4, width-8, height-8);
		
		g.setFont(new Font("Sans", Font.BOLD, 28));
		int w=g.getFontMetrics().stringWidth("GAME PAUSED");
		g.drawString("GAME PAUSED", x+(width-w)/2, y+60);
		
		
		g.setColor(tmp); //reset color
		g.setFont(f); //reset font
	}
	public void setWidth(int w) {
	}
	public void setHeight(int h) {
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setX(int x) {
	}
	public void setY(int y) {
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
