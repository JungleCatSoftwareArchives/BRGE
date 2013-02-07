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

import com.junglecatsoftware.brge.graphics.GameWindow;
import com.junglecatsoftware.brge.graphics.ScreenObjects;

public class BRGE { //Main class
	private static int width=800;
	private static int height=600;
	private static GameWindow gw;
	private static ScreenObjects screenObjects;
	private static Game theGame;
	private static boolean drawShadows;
	
	public static void start(Game game){
		if(theGame==null){ //only start once
			theGame=game;
			screenObjects=game.getScreenObjects();
			gw=new GameWindow(screenObjects);
			(new Thread(gw)).start(); //Load GameWindow and start rendering
			
			theGame.startGame();//start the game!
		}
	}
	
	public static String getGameTitle(){
		return theGame.getGameTitle();
	}
	public static int getWidth(){
		return width;
	}
	public static int getHeight(){
		return height;
	}
	public static void toggleFPS(){
		gw.toggleFPS();
	}
	public static void toggleShadows(){
		drawShadows=!drawShadows;
	}
	public static boolean getDrawShadows(){
		return drawShadows;
	}
	public static void keyPressed(int key){
		theGame.keyPressed(key);
	}
	public static void keyReleased(int key){
		theGame.keyReleased(key);
	}
	public static void keyTyped(int key){
		theGame.keyTyped(key);
	}
	public static void exit(){
		//cleanup and exit
		System.exit(0);//exit
	}
}
