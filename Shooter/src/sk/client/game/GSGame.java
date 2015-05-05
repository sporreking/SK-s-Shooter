package sk.client.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import sk.audio.AudioManager;
import sk.client.Time;
import sk.client.debug.Debug;
import sk.client.gamestate.GameState;
import sk.client.gamestate.GameStateManager;
import sk.client.gfx.texture.Background;
import sk.client.gfx.texture.BackgroundLibrary;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.renderer.QuadRenderer;
import sk.client.util.Util;
import sk.client.world.World;
import sk.client.world.entity.Entity;
import sk.client.world.entity.EntityManager;
import sk.stb.STB;

public class GSGame extends GameState {
	
	private QuadRenderer mouseRenderer;
	
	private World world;
	
	public GSGame() {
		super(0, "Game");
	}
	
	public void init() {
		world = new World().setBackground(BackgroundLibrary.get("Space"));
		BackgroundLibrary.get("Space").setWorld(world);
		
		Mouse.setGrabbed(true);
		
		mouseRenderer = new QuadRenderer(Mouse.getX(), Mouse.getY(), 64, 64, true, TextureLibrary.getTexture("Aim"));
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
			case Keyboard.KEY_0:
				AudioManager.stopLoop(0);
				GameStateManager.enterState("Test");
				break;
			}
		}
	}
	
	private float speed = 1;
	
	public void update(float tick) {
		world.update(tick * speed);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_I)) {
			speed -= tick / 10000;
			AudioManager.setLoopPitch(speed, 0);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_O)) {
			speed += tick / 10000;
			AudioManager.setLoopPitch(speed, 0);
		}
		
		mouseRenderer.setTranslation(Util.getRelativeMX(), Util.getRelativeMY());
	}
	
	public void draw() {
		GL11.glClearColor(0, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		world.draw();
		
		mouseRenderer.draw();
	}
	
	public void exit() {
		Mouse.setGrabbed(false);
		world.destroy();
	}
}