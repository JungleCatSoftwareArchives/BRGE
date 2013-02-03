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
import java.util.ArrayList;
import java.util.Random;

import com.junglecatsoftware.brge.graphics.drawables.Drawable;




public class SpaceTile implements Drawable{
	private int width=50;
	private int height=50;

	private int x=0;
	private int y=0;
	
	private Color color=Color.black;
	private ArrayList<Integer> starsLength;
	private ArrayList<Integer> starsX;
	private ArrayList<Integer> starsY;
	private ArrayList<Color> starsColor;
	
	public SpaceTile(){
		
	}
	
	public SpaceTile(int x, int y){
		this.x=x;
		this.y=y;
		
		generate();
	}
	public void generate(){
		starsLength=new ArrayList<Integer>();
		starsX=new ArrayList<Integer>();
		starsY=new ArrayList<Integer>();
		starsColor=new ArrayList<Color>();
		
		Random rand=new Random();
		int stars=rand.nextInt(9)+3;
		for(int i=0;i<stars;i++){
			int len=rand.nextInt(4);
			starsLength.add(len);
			starsX.add(rand.nextInt(50));
			starsY.add(rand.nextInt(50-len));
			starsColor.add(new Color(rand.nextInt(55)+200,200,rand.nextInt(55)+200));
		}
	}
	public void draw(Graphics g) {
		Color tmp=g.getColor();
		
		g.setColor(color); //set color
		g.fillRect(x, y, width, height); //draw
		try{ //this catches a race condition when the graphics renderer attempts to draw the tile when it is offscreen and being reconfigured, exception just needs to be caught (and ignored) to prevent skipping drawing other screenObjects
			for(int i=0;i<starsX.size();i++){
				g.setColor(starsColor.get(i));
				g.drawLine(x+starsX.get(i), y+starsY.get(i), x+starsX.get(i), y+starsY.get(i)+starsLength.get(i));
			}
		}catch(IndexOutOfBoundsException e){
			System.err.println("Warning: SpaceTile1 at ("+x+","+y+") was skipped!");
			//ignore
		}
		
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