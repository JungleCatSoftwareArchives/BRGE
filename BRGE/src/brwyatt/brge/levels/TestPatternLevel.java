package brwyatt.brge.levels;

import java.awt.Color;
import java.awt.event.KeyEvent;

import brwyatt.brge.Game;
import brwyatt.brge.graphics.ScreenObjects;
import brwyatt.brge.graphics.drawables.InstructionsText;
import brwyatt.brge.graphics.drawables.Tile50x50;

public class TestPatternLevel extends Level{
	
	private boolean runTestPattern=true;
	private Thread t;
	
	public TestPatternLevel(Game g, ScreenObjects so){
		super(g, so);
	}

	public void startLevel() {
		t=new Thread(){ public void run(){ startTestPattern(); }};
		t.start();
	}
	public void endLevel() {
		stopTestPattern();
		while(t.isAlive()){
			wait(1);
		}
		screenObjects.clear();
	}
	public void keyPressed(int key) {
		switch(key){
			case KeyEvent.VK_SPACE:
				if(runTestPattern){
					stopTestPattern();
				}else{
					startLevel();
				}
				break;
			case KeyEvent.VK_ESCAPE:
				game.loadLevel(0);
				break;
		}
		
	}
	public void keyReleased(int key) {
	}
	public void keyTyped(int key) {
	}
	
	

	
	public void stopTestPattern(){
		runTestPattern=false;
	}
	public void startTestPattern(){
		screenObjects.clear();
		
		Tile50x50 tile1=new Tile50x50(0,0);
		Tile50x50 tile2=new Tile50x50(25,25, Color.red);
		Tile50x50 tile3=new Tile50x50(50,50, Color.blue);
		Tile50x50 tile4=new Tile50x50(75,75, Color.green);
		
		screenObjects.addToTop(tile1);
		screenObjects.addToTop(tile2);
		screenObjects.addToBottom(tile3);
		screenObjects.addToTop(tile4);
		screenObjects.addToTop(new InstructionsText());
		
		runTestPattern=true;
		while(runTestPattern){
			while(tile4.getY()<550 && runTestPattern){
				tile1.setY(tile1.getY()+1);
				tile2.setY(tile2.getY()+1);
				tile3.setY(tile3.getY()+1);
				tile4.setY(tile4.getY()+1);
				wait(1);
			}
			while(tile4.getX()<750 && runTestPattern){
				tile1.setX(tile1.getX()+1);
				tile2.setX(tile2.getX()+1);
				tile3.setX(tile3.getX()+1);
				tile4.setX(tile4.getX()+1);
				wait(1);
			}
			while(tile1.getY()>0 && runTestPattern){
				tile1.setY(tile1.getY()-1);
				tile2.setY(tile2.getY()-1);
				tile3.setY(tile3.getY()-1);
				tile4.setY(tile4.getY()-1);
				wait(1);
			}
			while(tile1.getX()>0 && runTestPattern){
				tile1.setX(tile1.getX()-1);
				tile2.setX(tile2.getX()-1);
				tile3.setX(tile3.getX()-1);
				tile4.setX(tile4.getX()-1);
				wait(1);
			}
		}
		
		screenObjects.clear();
		screenObjects.addToTop(new InstructionsText());
	}
	@SuppressWarnings("static-access")
	public static void wait(int millis){
		try {
			Thread.currentThread().sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
