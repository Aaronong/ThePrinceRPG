package thePrinceGame;

import data.Loader;
import gameStates.AmazonState;
import gameStates.AtlantisState;
import gameStates.GameState;
import gameStates.GobiState;
import gameStates.JotenheimState;
import gameStates.SerengetiState;
import gameStates.State;
import gfx.GameCamera;
import input.KeyManager;
import items.ItemManager;
import skills.SkillManager;
import thePrinceMain.Game;
import worlds.World;

public class Handler {

	private Game game;
	private World world;
	private Loader data;
	private ItemManager	itemManager;
	private SkillManager skillManager;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public void toWorld() {
		if (this.data.getStateID() == 0){
			GameState gameState = new GameState(this);
			State.setState(gameState);
		}
		else if (this.data.getStateID() == 1){
			SerengetiState serengetiState = new SerengetiState(this);
			State.setState(serengetiState);
		}
		else if (this.data.getStateID() == 2){
			AmazonState amazonState = new AmazonState(this);
			State.setState(amazonState);
		}
		else if (this.data.getStateID() == 3){
			GobiState gobiState = new GobiState(this);
			State.setState(gobiState);
		}
		else if (this.data.getStateID() == 4){
			AtlantisState atlantisState = new AtlantisState(this);
			State.setState(atlantisState);
		}
		else if (this.data.getStateID() == 5){
			JotenheimState jotenheimState = new JotenheimState(this);
			State.setState(jotenheimState);
		}
	}
	
	//Getters and Setters
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Loader getData() {
		return data;
	}

	public void setData(Loader data) {
		this.data = data;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager (ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public SkillManager getSkillManager() {
		return skillManager;
	}

	public void setSkillManager (SkillManager skillManager) {
		this.skillManager = skillManager;
	}
}
