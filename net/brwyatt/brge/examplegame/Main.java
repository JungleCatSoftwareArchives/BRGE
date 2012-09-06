package net.brwyatt.brge.examplegame;

import net.brwyatt.brge.BRGE;
import net.brwyatt.brge.examplegame.ExampleGame;
import net.brwyatt.brge.graphics.ScreenObjects;

public class Main {

	public static void main(String args[]){
		BRGE.start(new ExampleGame(new ScreenObjects()));
	}

}
