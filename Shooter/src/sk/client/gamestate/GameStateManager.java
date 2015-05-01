package sk.client.gamestate;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import sk.client.game.Game;

public final class GameStateManager {
	
	private static GameState currentState;
	
	public static final void enterState(String gameState) {
		if(currentState != null)
			currentState.exit();
		
		currentState = GameStateLibrary.get(gameState);
		
		currentState.init();
	}
	
	public static final void update() {
		checkMouse();
		checkKeyboard();
		currentState.update();
		currentState.draw();
	}
	
	private static final void checkMouse() {
		while(Mouse.next()) {
			currentState.checkMouse(Mouse.getEventButton(), Mouse.getEventButtonState());
		}
	}
	
	private static final void checkKeyboard() {
		while(Keyboard.next()) {
			int key = Keyboard.getEventKey();
			boolean pressed = Keyboard.getEventKeyState();
			if(pressed && key == Keyboard.KEY_F11) {
				try {
					boolean fullscreen = Display.isFullscreen();
					if(fullscreen) {
						Display.setFullscreen(false);
						Display.setDisplayMode(new DisplayMode(Game.WIDTH, Game.HEIGHT));
						GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
					} else {
						Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode());
						GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
					}
				} catch (LWJGLException e) {
					e.printStackTrace();
				}
			}
			currentState.checkKeyboard(key, pressed);
		}
	}
	
	public static final GameState getCurrentState() {
		return currentState;
	}
}