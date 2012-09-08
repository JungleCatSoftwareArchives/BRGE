package net.brwyatt.brge.graphics.drawables;

import java.awt.Color;
import java.awt.Graphics;

public class BlackBackground implements Drawable {
	private int width=800;
	private int height=600;

	private int x=0;
	private int y=0;

	private Color bgColor=Color.black;

	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(bgColor); //set color
		g.fillRect(x, y, width, height); //draw
		
		g.setColor(tmp); //reset color
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
