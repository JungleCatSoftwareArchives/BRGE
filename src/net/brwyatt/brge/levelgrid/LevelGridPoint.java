package net.brwyatt.brge.levelgrid;

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
}
