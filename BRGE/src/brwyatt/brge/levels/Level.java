package brwyatt.brge.levels;

import brwyatt.brge.Game;
import brwyatt.brge.graphics.ScreenObjects;

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
