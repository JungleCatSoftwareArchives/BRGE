package brwyatt.brge.examplegame.drawables;

import java.awt.Color;
import java.awt.Graphics;

import brwyatt.brge.graphics.drawables.Drawable;

public class ExampleMenuBackground implements Drawable {
	private int width=800;
	private int height=600;

	private int x=0;
	private int y=0;

	private Color bgColor=Color.black;
	private Color fgColor=Color.yellow;

	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(bgColor); //set color
		g.fillRect(x, y, width, height); //draw
		
		g.setColor(fgColor); //set color for lines
		
		g.drawLine(200, 100, 200, 499); //left vertical
		g.drawLine(599, 100, 599, 499); //right vertical

		g.drawLine(0, 100, 799, 100); //top horizontal
		g.drawLine(0, 499, 799, 499); //bottom horizontal
		
		g.drawLine(200, 150, 250, 100); //top left angled
		g.drawLine(200, 449, 250, 499); //bottom left angled
		g.drawLine(549, 100, 599, 150); //top right angled
		g.drawLine(549, 499, 599, 449); //bottom right angled
		
		//left side pattern
		g.fillRect(0, 100, 50, 50);
		g.fillRect(100, 100, 50, 50);
		g.fillRect(50, 150, 50, 50);
		g.fillRect(150, 150, 50, 50);
		g.fillRect(0, 200, 50, 50);
		g.fillRect(100, 200, 50, 50);
		g.fillRect(50, 250, 50, 50);
		g.fillRect(150, 250, 50, 50);
		g.fillRect(0, 300, 50, 50);
		g.fillRect(100, 300, 50, 50);
		g.fillRect(50, 350, 50, 50);
		g.fillRect(150, 350, 50, 50);
		g.fillRect(0, 400, 50, 50);
		g.fillRect(100, 400, 50, 50);
		g.fillRect(50, 450, 50, 50);
		g.fillRect(150, 450, 50, 50);
		
		//right side pattern
		g.fillRect(600, 100, 50, 50);
		g.fillRect(700, 100, 50, 50);
		g.fillRect(650, 150, 50, 50);
		g.fillRect(750, 150, 50, 50);
		g.fillRect(600, 200, 50, 50);
		g.fillRect(700, 200, 50, 50);
		g.fillRect(650, 250, 50, 50);
		g.fillRect(750, 250, 50, 50);
		g.fillRect(600, 300, 50, 50);
		g.fillRect(700, 300, 50, 50);
		g.fillRect(650, 350, 50, 50);
		g.fillRect(750, 350, 50, 50);
		g.fillRect(600, 400, 50, 50);
		g.fillRect(700, 400, 50, 50);
		g.fillRect(650, 450, 50, 50);
		g.fillRect(750, 450, 50, 50);
		
		
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
