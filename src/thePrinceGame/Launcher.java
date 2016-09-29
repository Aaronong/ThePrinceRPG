package thePrinceGame;

import thePrinceMain.Game;

public class Launcher {
	//Due Date - 5th December 2015 Midnight
	public static void main(String[] args){
		Game game = new Game("The Prince RPG", 800,600);
		game.start();
	}
}
