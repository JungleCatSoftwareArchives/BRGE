package brwyatt.brge.graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import brwyatt.brge.graphics.drawables.Drawable;

public class ScreenObjects{
	private ArrayList<Drawable> objects;
	
	public ScreenObjects(){
		objects=new ArrayList<Drawable>();
	}

	public void addToBottom(Drawable d){
		synchronized(objects){
			objects.add(0,d);
		}
	}
	public void addToTop(Drawable d){
		synchronized(objects){
			objects.add(d);
		}
	}
	public boolean remove(Drawable d){
		return objects.remove(d);
	}
	public void clear(){
		objects=new ArrayList<Drawable>();
	}
	public void draw(Graphics g){
		synchronized(objects){
			for(int i=0;i<objects.size();i++){
				objects.get(i).draw(g);
			}
		}
	}
}
