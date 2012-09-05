package brwyatt.brge.graphics.drawables;

import java.awt.Color;
import java.awt.Graphics;


public class Tile50x50 implements Drawable{
	private int width=50;
	private int height=50;

	private int x=0;
	private int y=0;
	
	private Color color=Color.black;

	public Tile50x50(){
	}
	public Tile50x50(Color c){
		color=c;
	}
	public Tile50x50(int x, int y){
		this.x=x;
		this.y=y;
	}
	public Tile50x50(int x, int y, Color c){
		this.x=x;
		this.y=y;
		color=c;
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(color); //set color
		g.fillRect(x, y, width, height); //draw
		
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