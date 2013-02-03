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

package com.junglecatsoftware.brge.graphics.drawables;

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
