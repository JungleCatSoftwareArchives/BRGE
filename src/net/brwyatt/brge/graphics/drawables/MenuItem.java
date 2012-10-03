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

package net.brwyatt.brge.graphics.drawables;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class MenuItem implements Drawable{
	private int width=349;
	private int height=50;

	private int x=225;
	private int y=0;
	
	private boolean state=false;

	private Color selectcolor=Color.red;
	private Color unselectcolor=Color.lightGray;
	
	private String text="Replace me!!!";
	

	public MenuItem(String s){
		text=s;
	}
	public MenuItem(int y){
		this.y=y*60 + 160;
	}
	public MenuItem(int y, String s){
		this.y=y*60 + 160;
		text=s;
	}
	public MenuItem(int y, boolean selected){
		this.y=y*60 + 160;
		state=selected;
	}
	public MenuItem(int y, boolean selected, String s){
		this.y=y*60 + 160;
		state=selected;
		text=s;
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		Font f=g.getFont();
		
		if(state){
			g.setColor(selectcolor); //set selected color
			g.fillRect(x, y, width, height); //draw
			g.setColor(unselectcolor); //set unselected color
			g.fillRect(x+5, y+5, width-10, height-10); //draw
			g.setColor(Color.red);
		}else{
			g.setColor(unselectcolor); //set unselected color
			g.fillRect(x, y, width, height); //draw
			g.setColor(Color.black);
		}
		g.setFont(new Font("Sans", Font.BOLD, 20));
		int w=g.getFontMetrics().stringWidth(text);
		g.drawString(text, x+(width-w)/2, y+33);
		
		g.setColor(tmp); //reset color
		g.setFont(f); //reset font
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
	public void setSelected(boolean selected){
		state=selected;
	}
}