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

package com.junglecatsoftware.brge;

import com.junglecatsoftware.brge.graphics.ScreenObjects;

public abstract class Game {
	protected ScreenObjects screenObjects;
	
	public Game(){
	}
	public Game(ScreenObjects so){
		screenObjects=so;
	}
	public abstract void startGame();
	public abstract void nextLevel();
	public abstract void lastLevel();
	public abstract void loadLevel(int l);
	public abstract void saveGame();
	public abstract void loadGame();
	public abstract void pauseGame();
	public abstract void unpauseGame();
	public abstract void showInGameMenu();
	public abstract void keyPressed(int key);
	public abstract void keyReleased(int key);
	public abstract void keyTyped(int key);
	public abstract String getGameTitle();
	public ScreenObjects getScreenObjects(){
		return screenObjects;
	}
}
