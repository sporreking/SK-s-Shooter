package sk.client.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import sk.client.Time;
import sk.client.debug.Debug;
import sk.client.gamestate.GameStateLibrary;
import sk.client.gamestate.GameStateManager;

public class Game {
	
	public static final String TITLE = "SK's Shooter-Mania";
	public static final boolean VSYNC = false;
	public static final int FPS_CAP = 1000;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private static boolean running = true;
	private static int error = 0;
	
	public Game() {
		
		try {
			initDisplay();
			initGL();
			registerGameStates();
			
			GameStateManager.enterState("Game");
			
			while(!Display.isCloseRequested() && running) {
				Time.update();
				
				Display.setTitle(TITLE + " - FPS: " + Time.getFPS());
				
				GameStateManager.update();
				
				Display.update();
				Display.sync(FPS_CAP);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void initDisplay() throws LWJGLException {
		Display.setTitle(TITLE);
		Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
		Display.setVSyncEnabled(VSYNC);
		
		Display.create();
	}
	
	private void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH, HEIGHT, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
	}
	
	private void registerGameStates() {
		GameStateLibrary.register(new GSGame());
	}
	
	public static final void stop(int error) {
		running = false;
		Game.error = error;
	}
	
	public static final int getErrorCode() {
		return error;
	}
	
	public static final void kill(int error, String msg) {
		System.err.println(msg);
		System.exit(error);
	}
}