package brwyatt.brge;

import brwyatt.brge.graphics.GameWindow;
import brwyatt.brge.graphics.ScreenObjects;

public class BRGE { //Main class
	private static int width=800;
	private static int height=600;
	private static GameWindow gw;
	private static ScreenObjects screenObjects;
	private static Game game;
	
	public static void main(String args[]){
		screenObjects=new ScreenObjects();
		game=new TestGame(screenObjects); //change this to whichever game you want!
		gw=new GameWindow(screenObjects);
		(new Thread(gw)).start(); //Load GameWindow and start rendering
		
		game.startGame();//start the game!
	}
	
	
	
	public static String getGameTitle(){
		return game.getGameTitle();
	}
	public static int getWidth(){
		return width;
	}
	public static int getHeight(){
		return height;
	}
	public static void keyPressed(int key){
		game.keyPressed(key);
	}
	public static void keyReleased(int key){
		game.keyReleased(key);
	}
	public static void keyTyped(int key){
		game.keyTyped(key);
	}
	public static void exit(){
		//cleanup and exit
		System.exit(0);//exit
	}
}
