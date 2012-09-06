package brwyatt.brge.testgame.levels;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import brwyatt.brge.BRGE;
import brwyatt.brge.Game;
import brwyatt.brge.graphics.ScreenObjects;
import brwyatt.brge.graphics.drawables.MenuItem;
import brwyatt.brge.levels.Level;
import brwyatt.brge.testgame.drawables.MainMenuBackground;

public class TestMenu extends Level{
	
	private ArrayList<MenuItem> items;
	private int selectedItem=0;
	private boolean menuSelected=false; //Ensure that menu items can't be triggered if the spacebar was pressed prior to the menu loading
	
	public TestMenu(Game g, ScreenObjects so){
		super(g, so);
	}

	public void startLevel() {
		screenObjects.clear();
		screenObjects.addToTop(new MainMenuBackground());

		items=new ArrayList<MenuItem>();
		items.add(new MenuItem(0, true, "Test Game"));
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
