package net.brwyatt.brge.graphics.drawables;

import net.brwyatt.brge.graphics.drawables.Drawable;
import net.brwyatt.brge.levelgrid.LevelGridSquare;

public interface LevelGridDrawable extends Drawable {
	public abstract void setGridSquare(LevelGridSquare levelGridSquare); //set the LevelGridSquare position of the object
	public abstract LevelGridSquare getGridSquare(); //returns the LevelGridSquare of the object
}
