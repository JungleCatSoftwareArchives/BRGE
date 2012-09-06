package brwyatt.brge.examplegame;

import brwyatt.brge.BRGE;
import brwyatt.brge.examplegame.ExampleGame;
import brwyatt.brge.graphics.ScreenObjects;

public class Main {

	public static void main(String args[]){
		BRGE.start(new ExampleGame(new ScreenObjects()));
	}

}
