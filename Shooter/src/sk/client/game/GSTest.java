package sk.client.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import sk.client.gamestate.GameState;
import sk.client.gfx.texture.DynamicTexture;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.renderer.QuadRenderer;

public class GSTest extends GameState {
	
	private QuadRenderer sheetTester;
	private DynamicTexture dTex;
	
	public GSTest() {
		super(-1, "Test");
	}
	
	public void init() {
		dTex = new DynamicTexture(TextureLibrary.getSpriteSheet("TestSheet2"));
		sheetTester = new QuadRenderer(300, 300, 100, 100, true, dTex);
		dTex.swap(1, 2);
	}
	
	public void checkMouse(int button, boolean pressed) {}
	
	public void checkKeyboard(int key, boolean pressed) {
		if(pressed) {
			switch(key) {
			case Keyboard.KEY_O:
				dTex.increment(1);
				break;
			case Keyboard.KEY_I:
				dTex.decrement(1);
				break;
			}
		}
	}
	
	public void update(float tick) {}
	
	public void draw() {
		GL11.glClearColor(0, 1, 1, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		sheetTester.draw();
	}
	
	public void exit() {}
}