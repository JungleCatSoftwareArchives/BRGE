package brwyatt.brge.levels;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import brwyatt.brge.Game;
import brwyatt.brge.graphics.ScreenObjects;
import brwyatt.brge.graphics.drawables.BlackBackground;
import brwyatt.brge.graphics.drawables.Drawable;
import brwyatt.brge.graphics.drawables.Enemy1;
import brwyatt.brge.graphics.drawables.MenuItem;
import brwyatt.brge.graphics.drawables.PauseMenuOverlayBackground;
import brwyatt.brge.graphics.drawables.Player;
import brwyatt.brge.graphics.drawables.SpaceTile1;
import brwyatt.brge.graphics.drawables.YellowLaser;
import brwyatt.brge.graphics.drawables.GameOverText;

public class SimpleTestGame extends Level{
	
	private boolean run=true;
	private boolean pause=false;
	private Thread t;
	
	private ArrayList<SpaceTile1> bgtiles;
	private Player player;
	private ArrayList<Drawable> playerWeapons;
	private ArrayList<Drawable> enemies;
	
	private boolean moveleft=false;
	private boolean moveright=false;
	private boolean shooting=false;
	private boolean fireOne=false;
	private boolean exitselected=false;
	
	private int enemyShift=0;
	private boolean enemyShiftingRight=true;
	
	private boolean gameOver=false;
	private GameOverText gameOverText;
	
	public SimpleTestGame(Game g, ScreenObjects so){
		super(g, so);
	}

	public void startLevel() {
		screenObjects.clear();
		
		screenObjects.addToBottom(new BlackBackground());
		
		bgtiles=new ArrayList<SpaceTile1>();
		
		for(int x=0;x<800;x+=50){
			for(int y=-50;y<600;y+=50){
				SpaceTile1 tmp=new SpaceTile1(x,y);
				bgtiles.add(tmp);
				screenObjects.addToTop(tmp);
			}
		}
		
		player=new Player(362,650);
		screenObjects.addToTop(player);

		playerWeapons=new ArrayList<Drawable>();
		
		enemies=new ArrayList<Drawable>();
		
		enemyShift=0;
		enemyShiftingRight=true;
		for(int x=25;x<700;x+=50){
			for(int y=50;y<250;y+=50){
				Enemy1 tmp=new Enemy1(x,y);
				enemies.add(tmp);
				screenObjects.addToTop(tmp);
			}
		}

		t=new Thread(){ public void run(){ runGame(); }};
		t.start();
	}
	public void endLevel() {
		run=false;
		pause=false;
		while(t.isAlive()){
			wait(1);
		}
		screenObjects.clear();
	}
	public void keyPressed(int key) {
		switch(key){
			case KeyEvent.VK_LEFT:
				moveleft=true;
				break;
			case KeyEvent.VK_RIGHT:
				moveright=true;
				break;
			case KeyEvent.VK_SPACE:
				fireOne=true;
				shooting=true;
				if(pause){
					exitselected=true;
				}
				break;
			case KeyEvent.VK_ENTER:
				if(pause){
					exitselected=true;
				}
				break;
		}
	}
	public void keyReleased(int key) {
		switch(key){
			case KeyEvent.VK_LEFT:
				moveleft=false;
				break;
			case KeyEvent.VK_RIGHT:
				moveright=false;
				break;
			case KeyEvent.VK_SPACE:
				shooting=false;
				if(pause && exitselected){
					game.loadLevel(0);
				}
				break;
			case KeyEvent.VK_ESCAPE:
				if(pause){
					exitselected=false;
					pause=false;
				}else{
					pause=true;
				}
				break;
			case KeyEvent.VK_ENTER:
				if(pause && exitselected){
					game.loadLevel(0);
				}
				break;
		}
	}
	public void keyTyped(int key) {
		switch(key){
		}
	}
	
	private void runGame(){
		run=true;
		int counter=1; //tick-tock counter
		while(run){
			
			if(pause){//if game has been paused
				//create and display menu
				PauseMenuOverlayBackground bg=new PauseMenuOverlayBackground();
				MenuItem item1=new MenuItem(4, true, "Exit to Main Menu");
				screenObjects.addToTop(bg);
				screenObjects.addToTop(item1);
				
				while(pause){
					wait(10);
				}
				
				//remove menu from screen
				screenObjects.remove(bg);
				screenObjects.remove(item1);
			}
			
			//starfield movement
			if(counter%10==0){//only increment every 10ms
				for(int i=0;i<bgtiles.size();i++){
					if(bgtiles.get(i).getY()<599){
						bgtiles.get(i).setY(bgtiles.get(i).getY()+1);
					}else{
						bgtiles.get(i).setY(-50);
						bgtiles.get(i).generate();
					}
				}
			}
			
			//player movement
			if(player.getY()>540){//if the player is below the screen, slowly move it up
				if(counter%50==0){//only move every 50ms
					player.setY(player.getY()-1);
				}
				fireOne=false;//kill any fire commands accidentally sent before ship is on screen
			}else if(enemies.size()==0){//all enemies are dead, move the player up
				if(!gameOver){
					gameOver=true;

					gameOverText=new GameOverText(0,0);
					screenObjects.addToTop(gameOverText);
				}
				gameOverText.setX(400-(gameOverText.getWidth()/2));
				gameOverText.setY(300-(gameOverText.getHeight()/2));
				
				if(player.getX()<362){
					if(counter%20==0){//only move every 20ms
						player.setX(player.getX()+1);
					}
				}else if(player.getX()>362){
					if(counter%20==0){//only move every 20ms
						player.setX(player.getX()-1);
					}
				}else{
					if(counter%5==0){//only move every 5ms
						player.setY(player.getY()-1);
					}
				}
			}else{//player is in position, so allow movement and shooting
				if(counter%5==0){//speed is 200px/second for left/right movement
					if(moveright && !moveleft && player.getX()<(799-player.getWidth())){
						player.setX(player.getX()+1);
					}else if(moveleft && !moveright && player.getX()>0){
						player.setX(player.getX()-1);
					}
				}
				
				if(counter%100==0){//only allow a shot every 100ms
					if(shooting || fireOne){
						fireOne=false;
						//left laser
						YellowLaser l=new YellowLaser(player.getX()+4,player.getY()+20);
						playerWeapons.add(l);
						screenObjects.addToTop(l);
						//right laser
						YellowLaser r=new YellowLaser(player.getX()+70,player.getY()+20);
						playerWeapons.add(r);
						screenObjects.addToTop(r);
					}
				}
			}
			
			//enemy movements
			if(counter%20==0){//speed is 50px/second
				if(enemyShiftingRight){
					enemyShift++;
					for(int i=0; i<enemies.size(); i++){
						enemies.get(i).setX(enemies.get(i).getX()+1);
					}
					if(enemyShift==100){
						enemyShiftingRight=false;
					}
				}else{
					enemyShift--;
					for(int i=0; i<enemies.size(); i++){
						enemies.get(i).setX(enemies.get(i).getX()-1);
					}
					if(enemyShift==0){
						enemyShiftingRight=true;
					}
				}
			}
			
			//weapon movements
			if(counter%2==0){ //weapon speed is 500px/second
				for(int i=0;i<playerWeapons.size();i++){
					playerWeapons.get(i).setY(playerWeapons.get(i).getY()-1);//move first
					if(playerWeapons.get(i).getY()<-20){//if it has gone off screen
						screenObjects.remove(playerWeapons.remove(i));//remove from weapon list and screen
						i--;//decrement the index to keep up with shifting index
					}
				}
				//check collisions
				for(int i=0; i<playerWeapons.size();i++){//loop through weapons on the field
					if(playerWeapons.get(i).getY()<=250){//only check if weapon is close to targets
						boolean hit=false;
						for(int j=0; j<enemies.size();j++){//loop through enemies
							if((enemies.get(j).getX()<=playerWeapons.get(i).getX() && enemies.get(j).getX()+50>=playerWeapons.get(i).getX()) || (enemies.get(j).getX()>=playerWeapons.get(i).getX() && enemies.get(j).getX()-50<=playerWeapons.get(i).getX())){ //if the enemy is within 50px to the left, or 50px to the right
								for(int x=playerWeapons.get(i).getX();x<(playerWeapons.get(i).getX()+playerWeapons.get(i).getWidth());x++){ //loop through weapon's x-coordinates
									for(int y=playerWeapons.get(i).getY();y<(playerWeapons.get(i).getY()+playerWeapons.get(i).getHeight());y++){ //loop through weapon's y-coordinates
										if(x>=enemies.get(j).getX() && x<=(enemies.get(j).getX()+enemies.get(j).getWidth())){//this coordinate is within the enemy's x-bounds
											if(y>=enemies.get(j).getY() && y<=(enemies.get(j).getY()+enemies.get(j).getHeight())){//this coordinate is within the enemy's y-bounds
												//Hit!
												screenObjects.remove(playerWeapons.remove(i)); //remove
												screenObjects.remove(enemies.remove(j)); //remove
												i--; //decrement counter to account for removal
												j--; //decrement counter to account for removal
												hit=true;
											}
										}
										if(hit){
											break;
										}
									}
									if(hit){
										break;
									}
								}
							}
							if(hit){
								break;
							}
						}
					}
				}
				
				//if no enemies, end
				if(player.getY()<-75){
					(new Thread(){ public void run(){ game.loadLevel(0); }}).start();
				}
				
			}
			
			
			wait(1);//pause
			//tick-tock counter incrementing
			if(counter<1000){
				counter++;
			}else{
				counter=1;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public static void wait(int millis){
		try {
			Thread.currentThread().sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
