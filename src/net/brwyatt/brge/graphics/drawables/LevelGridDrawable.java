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

import net.brwyatt.brge.graphics.drawables.Drawable;
import net.brwyatt.brge.levelgrid.LevelGridSquare;

public interface LevelGridDrawable extends Drawable {
	public abstract void setGridSquare(LevelGridSquare levelGridSquare); //set the LevelGridSquare position of the object
	public abstract LevelGridSquare getGridSquare(); //returns the LevelGridSquare of the object
}
