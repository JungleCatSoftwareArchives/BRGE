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

package com.junglecatsoftware.brge.levelgrid;

public class LevelGridPoint {
	private double x;
	private double y;

	public LevelGridPoint(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	public LevelGridPoint(double x, double y){
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return (int)Math.round(x);
	}
	public double getRealX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public int getY() {
		return (int)Math.round(y);
	}
	public double getRealY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public LevelGridPoint copy(){
		return new LevelGridPoint(this.x,this.y);
	}
	public String toString(){
		return "("+this.getX()+","+this.getY()+")";
	}
}
