package sk.client.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import sk.client.Time;
import sk.client.debug.Debug;
import sk.client.gamestate.GameState;
import sk.client.renderer.QuadRenderer;
import sk.client.world.World;
import sk.client.world.entity.Entity;
import sk.client.world.entity.EntityManager;
import sk.stb.STB;

public class GSGame extends GameState {
	
	private World world;
	
	public GSGame() {
		super(0, "Game");
	}
	
	public void init() {
		world = new World();
	}
	
	public void checkMouse(int button, boolean pressed) {
		world.checkMouse(button, pressed);
	}
	
	public void checkKeyboard(int key, boolean pressed) {
		world.checkKeyboard(key, pressed);
		if(pressed) {
			switch(key) {
			case Keyboard.KEY_ESCAPE:
				Game.stop(0);
				break;
			}
		}
	}
	
	public void update() {world.update(Time.getDelta());}
	
	public void draw() {
		GL11.glClearColor(0, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		world.draw();
	}
	
	public void exit() {
		world.destroy();
	}
}