package sk.client.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import sk.audio.Audio;
import sk.audio.AudioLibrary;
import sk.audio.AudioManager;
import sk.audio.SoundLoader;
import sk.client.Time;
import sk.client.debug.Debug;
import sk.client.gamestate.GameStateLibrary;
import sk.client.gamestate.GameStateManager;
import sk.client.gfx.texture.BackgroundLibrary;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.gfx.texture.TextureLoader;

public class Game implements SoundLoader {
	
	public static final String TITLE = "SK's Shooter-Mania";
	public static final boolean VSYNC = true;
	public static final boolean RESIZEABLE = true;
	public static final int FPS_CAP = 60;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private static boolean running = true;
	private static int error = 0;
	
	private volatile boolean audInit = false;
	
	public Game() {
		
		try {
			initDisplay();
			initGL();
			AudioManager.start(this);
			while(!audInit);
			Registry.registerGameStates();
			Registry.registerTextures();
			Registry.registerSpriteSheets();
			Registry.registerBackgrounds();
			
			GameStateManager.enterState("Main Menu");
			
			while (!Display.isCloseRequested() && running) {
				Time.update();
				
				if (Display.wasResized())
					GL11.glViewport(0, 0, Display.getWidth(),
							Display.getHeight());
				
				Display.setTitle(TITLE + " - FPS: " + Time.getFPS());
				
				GameStateManager.update();
				
				Display.update();
				Display.sync(FPS_CAP);
			}
			
			Registry.destroy();
			
			AudioManager.destroy();
			AudioManager.getThread().join();
			Display.destroy();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void initDisplay() throws LWJGLException {
		Display.setTitle(TITLE);
		Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
		Display.setVSyncEnabled(VSYNC);
		Display.setResizable(RESIZEABLE);
		
		Display.create();
	}
	
	private void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH, HEIGHT, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public void registerAudio() {
		AudioLibrary.registerAudio("Repeatedly", new Audio(
				"res/audio/repeatedly.wav"));
		AudioLibrary.registerAudio("Main",
				new Audio("res/audio/music/Outer Space.wav"));
		
		audInit = true;
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