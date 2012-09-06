package brwyatt.brge.graphics.drawables;

import java.awt.Graphics;

public interface Drawable {
	public abstract void draw(Graphics g); //function to draw itself to the given Graphics object
	public abstract void setWidth(int w); //change the object's width
	public abstract void setHeight(int h); //change the object's height
	public abstract int getWidth(); //returns the object's width
	public abstract int getHeight(); //return the object's height
	public abstract void setX(int x); //change the x-position of the object
	public abstract void setY(int y); //change the y-position of the object
	public abstract int getX(); //returns the x-position of the object
	public abstract int getY(); //returns the y-the x-position of the object
}
