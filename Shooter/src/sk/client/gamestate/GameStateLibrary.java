package sk.client.gamestate;

import java.util.HashMap;

public final class GameStateLibrary {
	
	private static final HashMap<String, GameState> states = new HashMap<>();
	
	public static final void register(GameState gs) {
		states.put(gs.NAME, gs);
	}
	
	public static final GameState get(String name) {
		return states.get(name);
	}
	
	public static final void destroy() {
		
	}
}