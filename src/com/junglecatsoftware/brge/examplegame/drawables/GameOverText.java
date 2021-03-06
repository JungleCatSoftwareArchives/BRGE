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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import com.junglecatsoftware.brge.graphics.drawables.Drawable;



public class GameOverText implements Drawable{
	private int width=0;
	private int height=0;

	private int x=0;
	private int y=0;
	
	private String text="LEVEL PASSED";
	
	private Font font;
	
	public GameOverText(int x, int y){
		this.x=x;
		this.y=y;
		
		font=new Font("Monospaced", Font.BOLD, 100);
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		Font tmpFont=g.getFont();
		
		FontMetrics metrics = g.getFontMetrics(font);
		height = (metrics.getAscent()/2)+50;
		width = metrics.stringWidth(text)+50;
		
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
		
		g.setColor(Color.YELLOW);
		g.setFont(font);
		g.drawString(text, x+25, y+75);
		
		g.setColor(tmp); //reset color
		g.setFont(tmpFont); //reset font
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