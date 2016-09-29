package thePrinceMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import data.Loader;
import gameStates.BattleState;
import gameStates.MainState;
import gameStates.State;
import gfx.Assets;
import gfx.GameCamera;
import gfx.SpriteSheet;
import input.KeyManager;
import items.ItemManager;
import skills.SkillManager;
import thePrinceDisplay.Display;
import thePrinceGame.Handler;
import tile.Tile;

public class Game implements Runnable{

	private Display display;
	private int width,height;


	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	private State serengetiState;
	private State amazonState;
	private State gobiState;
	private State atlantisState;
	private State jotenheimState;
	private State mainState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	//SpriteSheets
	private BufferedImage GSsprites;
	private SpriteSheet sheet;
	
	//SavedFile
	private Loader loadFile;
	
	//Game Resources: Item Manager & Skill Manager
	private ItemManager itemManager;
	private SkillManager skillManager;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		itemManager = new ItemManager();
		skillManager = new SkillManager();
		
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		
		//Load Saved Data
		loadFile = new Loader("res/saveFiles/saveState1.txt");
		handler.setData(loadFile);
		
		//Initialize states
		//handler.toWorld();
		MainState mainState = new MainState(handler);
		State.setState(mainState);
		
		//Load Items & Skills
		handler.setItemManager(itemManager);
		handler.setSkillManager(skillManager);
		
		
	}
	
	private void tick(){
		keyManager.tick();

		if (State.getState() != null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		
		g.clearRect(0, 0, width, height);
		
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g);
	
		// All future Drawings will be drawn in the Different States
		//To draw filled rectangle g.fillRect(0, 0, width, height);
		// Change drawing colour to red, g.setColor(Color.red);
		// To draw the whole damn spritesheet g.drawImage(GSsprites, 20, 20, null);
		// This draws isaac at position 40 40
		//g.drawImage(sheet.crop(32, 0, 32, 32),40,40, null);
		// Drawing with Assets
		//g.drawImage(Assets.Isaac, 50, 50, null);
		//g.drawImage(Assets.grass, x, 50, null);
		//g.drawImage(Assets.water, 250, 50, null);
		
		//End Drawing!
		
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
		init();
		
		//frames per second
		int fps = 60;
		// 1 bil = 1 second
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running ){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// Getters and Setters
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
