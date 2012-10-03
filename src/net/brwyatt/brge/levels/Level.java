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
 
 package net.brwyatt.brge.levels;

import net.brwyatt.brge.Game;
import net.brwyatt.brge.graphics.ScreenObjects;

public abstract class Level{
	protected ScreenObjects screenObjects;
	protected Game game;
	
	public Level(){
	}
	public Level(Game g, ScreenObjects so){
		screenObjects=so;
		game=g;
	}
	public abstract void startLevel();
	public abstract void endLevel();
	public abstract void keyPressed(int key);
	public abstract void keyReleased(int key);
	public abstract void keyTyped(int key);
}
