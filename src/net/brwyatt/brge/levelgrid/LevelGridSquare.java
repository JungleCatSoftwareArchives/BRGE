package net.brwyatt.brge.levelgrid;

import java.awt.Polygon;
import java.util.ArrayList;

import net.brwyatt.brge.graphics.drawables.Drawable;

public class LevelGridSquare implements Comparable<LevelGridSquare>{
	private LevelGridPoint topLeft;
	private LevelGridPoint topRight;
	private LevelGridPoint bottomLeft;
	private LevelGridPoint bottomRight;

	private LevelGridSquare above;
	private LevelGridSquare below;
	private LevelGridSquare left;
	private LevelGridSquare right;
	
	private ArrayList<Drawable> objects;
	
	public LevelGridSquare(LevelGridPoint topLeft,LevelGridPoint topRight,LevelGridPoint bottomLeft,LevelGridPoint bottomRight){
		this.setTopLeft(topLeft);
		this.setTopRight(topRight);
		this.setBottomLeft(bottomLeft);
		this.setBottomRight(bottomRight);
		objects=new ArrayList<Drawable>();
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
	
	public ArrayList<Drawable> getObjects(){
		return objects;
	}

	@Override
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
}
