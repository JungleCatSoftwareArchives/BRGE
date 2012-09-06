package brwyatt.brge.graphics.drawables;

import java.awt.Color;
import java.awt.Graphics;


public class InstructionsText implements Drawable{
	private int width=50;
	private int height=50;

	private int x=300;
	private int y=300;
	
	private Color color=Color.black;

	public InstructionsText(){
	}
	public InstructionsText(Color c){
		color=c;
	}
	public InstructionsText(int x, int y){
		this.x=x;
		this.y=y;
	}
	public InstructionsText(int x, int y, Color c){
		this.x=x;
		this.y=y;
		color=c;
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(color); //set color
		g.drawString("Press SPACE to start/stop test pattern", x, y); //draw
		g.drawString("Press ESC to return to menu.", x, y+15); //draw
		
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