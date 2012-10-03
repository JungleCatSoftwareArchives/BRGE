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

package net.brwyatt.brge.examplegame;

import java.util.ArrayList;

import net.brwyatt.brge.Game;
import net.brwyatt.brge.examplegame.levels.ExampleLevel;
import net.brwyatt.brge.examplegame.levels.ExampleMenu;
import net.brwyatt.brge.graphics.ScreenObjects;
import net.brwyatt.brge.levels.Level;


public class ExampleGame extends Game {
	private final String title="BRGE Example Game";
	private Level currentLevel=null;
	private ArrayList<Level> levels;
	
	public ExampleGame(ScreenObjects so){
		screenObjects=so;
		levels=new ArrayList<Level>();

		levels.add(new ExampleMenu(this, screenObjects));
		levels.add(new ExampleLevel(this, screenObjects));
	}
	
	public void startGame() {
		loadLevel(0);
	}
	public void nextLevel() {
	}
	public void lastLevel() {
	}
	public void loadLevel(int l) {
		if(currentLevel!=null){
			currentLevel.endLevel();
		}
		currentLevel=levels.get(l);
		currentLevel.startLevel();
	}
	public void saveGame() {
	}
	public void loadGame() {
	}
	public void pauseGame() {
	}
	public void unpauseGame() {
	}
	public void showInGameMenu() {
	}
	public void keyPressed(int key) {
		currentLevel.keyPressed(key);
	}
	public void keyReleased(int key) {
		currentLevel.keyReleased(key);
	}
	public void keyTyped(int key) {
		currentLevel.keyTyped(key);
	}
	public String getGameTitle() {
		return title;
	}
}
