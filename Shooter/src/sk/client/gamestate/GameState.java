package sk.client.gamestate;

public abstract class GameState {
	
	public final int ID;
	public final String NAME;
	
	public GameState(int id, String name) {
		ID = id;
		NAME = name;
	}
	
	public abstract void init();
	public abstract void checkMouse(int button, boolean pressed);
	public abstract void checkKeyboard(int key, boolean pressed);
	public abstract void update();
	public abstract void draw();
	public abstract void exit();
	
}