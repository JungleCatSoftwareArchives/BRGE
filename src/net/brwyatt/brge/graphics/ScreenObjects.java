/* 
 * Copyright 2012 Bryan Wyatt
 * 
 * This file is part of BRGE.
 *  
 * BRGE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * BRGE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with BRGE.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.brwyatt.brge.graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import net.brwyatt.brge.graphics.drawables.Drawable;


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
	public void addAtIndex(int i, Drawable d){
		synchronized(objects){
			objects.add(i,d);
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
	public int count(){
		return objects.size();
	}
}
