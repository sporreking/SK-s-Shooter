package sk.client.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import sk.client.Time;
import sk.client.gamestate.GameState;
import sk.client.gfx.gui.Button;
import sk.client.gfx.gui.GUI;
import sk.client.gfx.texture.DynamicTexture;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.renderer.QuadRenderer;
import sk.client.renderer.TextRenderer;
import sk.client.util.Util;
import sk.stb.STB;

public class GSTest extends GameState {
	
	private QuadRenderer sheetTester;
	private DynamicTexture dTex;
	
	private String testString = "Hej";
	
	private GUI gui;
	
	public GSTest() {
		super(-1, "Test");
	}
	
	public void init() {
		dTex = new DynamicTexture(TextureLibrary.getSpriteSheet("TestSheet"));
		sheetTester = new QuadRenderer(300, 300, 100, 100, true, dTex);
//		dTex.swap(1, 2);
		TextRenderer.setFont(TextureLibrary.getSpriteSheet("fnt_courier"));
		
		gui = new GUI();
		
		gui.addElements(new Button(400, 400, 300, 75, dTex) {
			public void onClick(float x, float y) {
				System.out.println("Click!");
			}
			
			public void onMouseIn() {
				dTex.swap(4, 4);
			}
			
			public void onMouseOut() {
				dTex.swap(5, 4);
			}
		});
		
		STB.start("backspace counter", 150f);
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
	
	public void checkKeyboard(int key, boolean pressed) {
		if(pressed) {
			
			if(Util.isPrintable(Keyboard.getEventCharacter())) {
				testString += Keyboard.getEventCharacter();
			}
			
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
	
	public void update(float tick) {
		
		STB.update(tick, "backspace counter");
		
		if(Keyboard.isKeyDown(Keyboard.KEY_BACK) && STB.done("backspace counter")) {
			if(testString.length() > 0)
				testString = testString.substring(0, testString.length() - 1);
			STB.reset("backspace counter");
		}
		
		gui.update(tick);
		
	}
	
	public void draw() {
		GL11.glClearColor(0, 1, 1, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
//		sheetTester.draw();
		TextRenderer.draw(testString, 0, 0);
		gui.draw();
	}
	
	public void exit() {}
}