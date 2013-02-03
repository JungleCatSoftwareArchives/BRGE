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

package com.junglecatsoftware.brge.examplegame.drawables;

import java.awt.Color;
import java.awt.Graphics;

import com.junglecatsoftware.brge.graphics.drawables.Drawable;



public class Enemy1 implements Drawable{
	private int width=10;
	private int height=10;

	private int x=0;
	private int y=0;
	
	public Enemy1(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
		//g.setColor(Color.RED);
		//g.drawRect(x, y, width, height);
		
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