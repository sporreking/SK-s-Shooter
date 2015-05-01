package sk.client;

import sk.client.game.Game;

public class Main {
	
	public static final void main(String[] args) {
		new Game();
		System.exit(Game.getErrorCode());
	}
	
}