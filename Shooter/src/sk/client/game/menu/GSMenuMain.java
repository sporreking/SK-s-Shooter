package sk.client.game.menu;

import org.lwjgl.opengl.GL11;

import sk.client.game.Game;
import sk.client.gamestate.GameState;
import sk.client.gamestate.GameStateManager;
import sk.client.gfx.gui.Button;
import sk.client.gfx.gui.GUI;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.util.Util;

public class GSMenuMain extends GameState {
	
	private GUI gui;
	
	public GSMenuMain() {
		super(1000, "Main Menu");
	}
	
	public void init() {
		
		gui = new GUI();
		
		//Play Button
		gui.addElements(new Button(Game.WIDTH / 2 - 200, 200, 400, 100, TextureLibrary.getTexture("Button")) {
			
			public void onClick(float x, float y) {
				GameStateManager.enterState("Game");
			}
			
		}.setLabel("Play"));
		
		//Exit Button
		gui.addElements(new Button(Game.WIDTH / 2 - 200, 500, 400, 100, TextureLibrary.getTexture("Button")) {
			
			public void onClick(float x, float y) {
				Game.stop(0);
			}
			
		}.setLabel("Exit"));
		
	}
	
	public void checkMouse(int button, boolean pressed) {
		if(pressed) {
			switch(button) {
			case 0:
				gui.click(Util.getRelativeMX(), Util.getRelativeMY());
				break;
			}
		}
	}
	
	public void checkKeyboard(int key, boolean pressed) {}
	
	public void update(float tick) {
		gui.update(tick);
	}
	
	public void draw() {
		GL11.glClearColor(0, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		gui.draw();
	}
	
	public void exit() {}
}
