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

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import com.junglecatsoftware.brge.graphics.drawables.Drawable;
import com.junglecatsoftware.brge.graphics.drawables.LevelGridDrawable;


public class LevelGridSquare implements Comparable<LevelGridSquare>{
	private LevelGridPoint topLeft;
	private LevelGridPoint topRight;
	private LevelGridPoint bottomLeft;
	private LevelGridPoint bottomRight;

	private LevelGridSquare above;
	private LevelGridSquare below;
	private LevelGridSquare left;
	private LevelGridSquare right;

	private ArrayList<LevelGridDrawable> ground;
	private ArrayList<LevelGridDrawable> middle;
	private ArrayList<LevelGridDrawable> sky;
	
	public LevelGridSquare(LevelGridPoint topLeft,LevelGridPoint topRight,LevelGridPoint bottomLeft,LevelGridPoint bottomRight){
		this.setTopLeft(topLeft);
		this.setTopRight(topRight);
		this.setBottomLeft(bottomLeft);
		this.setBottomRight(bottomRight);
		ground=new ArrayList<LevelGridDrawable>();
		middle=new ArrayList<LevelGridDrawable>();
		sky=new ArrayList<LevelGridDrawable>();
	}

	public LevelGridPoint getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(LevelGridPoint topLeft) {
		this.topLeft = topLeft;
	}

	public LevelGridPoint getTopRight() {
		return topRight;
	}

	public void setTopRight(LevelGridPoint topRight) {
		this.topRight = topRight;
	}

	public LevelGridPoint getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(LevelGridPoint bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public LevelGridPoint getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(LevelGridPoint bottomRight) {
		this.bottomRight = bottomRight;
	}
	public Polygon getPolygon(){
		Polygon p=new Polygon();
		p.addPoint(topLeft.getX(), topLeft.getY());
		p.addPoint(topRight.getX(), topRight.getY());
		p.addPoint(bottomRight.getX(), bottomRight.getY());
		p.addPoint(bottomLeft.getX(), bottomLeft.getY());
		return p;
	}

	public LevelGridSquare getAbove() {
		return above;
	}

	public void setAbove(LevelGridSquare above) {
		this.above = above;
	}

	public LevelGridSquare getBelow() {
		return below;
	}

	public void setBelow(LevelGridSquare below) {
		this.below = below;
	}

	public LevelGridSquare getLeft() {
		return left;
	}

	public void setLeft(LevelGridSquare left) {
		this.left = left;
	}

	public LevelGridSquare getRight() {
		return right;
	}

	public void setRight(LevelGridSquare right) {
		this.right = right;
	}
	public ArrayList<LevelGridDrawable> getGroundObjects(){
		return ground;
	}
	public ArrayList<LevelGridDrawable> getMiddleObjects(){
		return middle;
	}
	public ArrayList<LevelGridDrawable> getSkyObjects(){
		return sky;
	}
	public ArrayList<ArrayList<LevelGridDrawable>> getAllObjects(){
		ArrayList<ArrayList<LevelGridDrawable>> allObjects=new ArrayList<ArrayList<LevelGridDrawable>>();
		allObjects.add(getGroundObjects());
		allObjects.add(getMiddleObjects());
		allObjects.add(getSkyObjects());
		return allObjects;
	}
	public void clearGroundObjects(){
		ground.clear();
	}
	public void clearMiddleObjects(){
		middle.clear();
	}
	public void clearSkyObjects(){
		sky.clear();
	}
	public void clearAllObjects(){
		clearGroundObjects();
		clearMiddleObjects();
		clearSkyObjects();
	}
	public LevelGridSquare copy(){
		return new LevelGridSquare(this.topLeft.copy(),this.topRight.copy(),this.bottomLeft.copy(),this.bottomRight.copy());
	}
	public int compareTo(LevelGridSquare other) {
		int diff=0;
		diff+=this.topLeft.getX()-other.topLeft.getX();
		diff+=this.topLeft.getY()-other.topLeft.getY();
		diff+=this.topRight.getX()-other.topRight.getX();
		diff+=this.topRight.getY()-other.topRight.getY();
		diff+=this.bottomLeft.getX()-other.bottomLeft.getX();
		diff+=this.bottomLeft.getY()-other.bottomLeft.getY();
		diff+=this.bottomRight.getX()-other.bottomRight.getX();
		diff+=this.bottomRight.getY()-other.bottomRight.getY();
		return diff;
	}
	public String toString(){
		return "("+this.topLeft+","+this.topRight+","+this.bottomLeft+","+this.bottomRight+")";
	}
	
	public void drawGround(Graphics g) {
		for(Drawable d : ground){
			d.draw(g);
		}
	}
	public void drawMiddle(Graphics g) {
		for(Drawable d : middle){
			d.draw(g);
		}
	}
	public void drawSky(Graphics g) {
		for(Drawable d : sky){
			d.draw(g);
		}
	}
}
