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
 
 package net.brwyatt.brge.examplegame.levels;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import net.brwyatt.brge.BRGE;
import net.brwyatt.brge.Game;
import net.brwyatt.brge.examplegame.drawables.ExampleMenuBackground;
import net.brwyatt.brge.graphics.ScreenObjects;
import net.brwyatt.brge.graphics.drawables.MenuItem;
import net.brwyatt.brge.levels.Level;


public class ExampleMenu extends Level{
	
	private ArrayList<MenuItem> items;
	private int selectedItem=0;
	private boolean menuSelected=false; //Ensure that menu items can't be triggered if the spacebar was pressed prior to the menu loading
	
	public ExampleMenu(Game g, ScreenObjects so){
		super(g, so);
	}

	public void startLevel() {
		screenObjects.clear();
		screenObjects.addToTop(new ExampleMenuBackground());

		items=new ArrayList<MenuItem>();
		items.add(new MenuItem(0, true, "Example Game"));
		items.add(new MenuItem(4, "Exit"));
		screenObjects.addToTop(items.get(0));
		screenObjects.addToTop(items.get(1));
		
		selectedItem=0;
	}
	public void endLevel() {
		screenObjects.clear();
	}
	
	private void menuUp(){
		items.get(selectedItem).setSelected(false);
		selectedItem--;
		if(selectedItem<0){
			selectedItem=items.size()-1;
		}
		items.get(selectedItem).setSelected(true);
	}
	private void menuDown(){
		items.get(selectedItem).setSelected(false);
		selectedItem++;
		if(selectedItem>=items.size()){
			selectedItem=0;
		}
		items.get(selectedItem).setSelected(true);
	}
	private void menuActivated(){
		switch(selectedItem){
			case 0:
				game.loadLevel(1);
				break;
			case 1:
				BRGE.exit();
				break;
		}
	}
	
	public void keyPressed(int key) {
		switch(key){
			case KeyEvent.VK_UP:
				menuUp();
				break;
			case KeyEvent.VK_DOWN:
				menuDown();
				break;
			case KeyEvent.VK_SPACE:
			case KeyEvent.VK_ENTER:
				menuSelected=true;
				break;
		}
		
	}
	public void keyReleased(int key) {
		switch(key){
			case KeyEvent.VK_SPACE:
			case KeyEvent.VK_ENTER:
				if(menuSelected){
					menuSelected=false;
					menuActivated();
				}
				break;
		}
	}
	public void keyTyped(int key) {
	}
}
