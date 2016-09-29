package gameStates;

import java.awt.Color;
import java.awt.Graphics;

import entities.Player;
import thePrinceGame.Handler;
import tile.Tile;
import worlds.World;

public class GameState extends State {

	//istantiate player object
	private Player player;
	private World world;
	private int stateID;
	private double spawnRate; //number less than one
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world.txt");
		handler.setWorld(world);
		player = world.getEntityManager().getPlayer();
		stateID = 0;
		spawnRate = 0.009; //0.009 is good

	}
	
	@Override
	public void tick() {
		if (Math.random() < spawnRate && (handler.getKeyManager().up||handler.getKeyManager().down||handler.getKeyManager().left||handler.getKeyManager().right)){
			handler.getData().setX_coord((int)((player.getX()+32)/Tile.TILEWIDTH));
			handler.getData().setY_coord((int)((player.getY()+40)/Tile.TILEHEIGHT));
			handler.getData().setStateID(stateID);
			BattleState battleState = new BattleState(handler);
			State.setState(battleState);
		}
		if (handler.getKeyManager().isSelectr()){
			handler.getData().setX_coord((int)((player.getX()+32)/Tile.TILEWIDTH));
			handler.getData().setY_coord((int)((player.getY()+40)/Tile.TILEHEIGHT));
			handler.getData().setStateID(stateID);
			handler.getKeyManager().setSelectr(false);
			MenuState menuState = new MenuState(handler);
			State.setState(menuState);
		}
		
		if (world.getEntityManager().getPlayer().getX() > (5.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getX() < (6.0*Tile.TILEWIDTH) &&
				world.getEntityManager().getPlayer().getY() > (4.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getY() < (6.0*Tile.TILEWIDTH))
		{
			//Change game state to Jotenheim
			handler.getData().setX_coord(10);
			handler.getData().setY_coord(2);
			JotenheimState jotenheimState = new JotenheimState(handler);
			State.setState(jotenheimState);
		}
		else if (world.getEntityManager().getPlayer().getX() > (41.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getX() < (42.0*Tile.TILEWIDTH) &&
				world.getEntityManager().getPlayer().getY() > (8.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getY() < (10.0*Tile.TILEWIDTH))
		{
			//Change game state to Atlantis
			handler.getData().setX_coord(10);
			handler.getData().setY_coord(2);
			AtlantisState atlantisState = new AtlantisState(handler);
			State.setState(atlantisState);
		}
		else if (world.getEntityManager().getPlayer().getX() > (4.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getX() < (5.0*Tile.TILEWIDTH) &&
				world.getEntityManager().getPlayer().getY() > (30.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getY() < (32.0*Tile.TILEWIDTH))
		{
			//Change game state to Serengeti
			handler.getData().setX_coord(10);
			handler.getData().setY_coord(2);
			SerengetiState serengetiState = new SerengetiState(handler);
			State.setState(serengetiState);
		}
		else if (world.getEntityManager().getPlayer().getX() > (41.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getX() < (42.0*Tile.TILEWIDTH) &&
				world.getEntityManager().getPlayer().getY() > (39.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getY() < (41.0*Tile.TILEWIDTH))
		{
			//Change game state to Gobi
			handler.getData().setX_coord(10);
			handler.getData().setY_coord(2);
			GobiState gobiState = new GobiState(handler);
			State.setState(gobiState);
		}
		else if (world.getEntityManager().getPlayer().getX() > (19.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getX() < (20.0*Tile.TILEWIDTH) &&
				world.getEntityManager().getPlayer().getY() > (55.0*Tile.TILEWIDTH) && world.getEntityManager().getPlayer().getY() < (57.0*Tile.TILEWIDTH))
		{
			//Change game state to Amazon
			handler.getData().setX_coord(10);
			handler.getData().setY_coord(2);
			AmazonState amazonState = new AmazonState(handler);
			State.setState(amazonState);	
		}
		world.tick();
		//player.tick();
	}
	


	@Override
	public void render(Graphics g) {
		world.render(g);
		//player.render(g);
	}
	
	@Override
	public int getStateID(){
		return stateID;
	}
	
	@Override
	public Player getPlayer(){
		return player;
	}

}
