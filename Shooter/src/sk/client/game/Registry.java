package sk.client.game;

import org.lwjgl.opengl.GL11;

import sk.client.game.menu.GSMenuMain;
import sk.client.gamestate.GameStateLibrary;
import sk.client.gfx.texture.BackgroundLibrary;
import sk.client.gfx.texture.DynamicTexture;
import sk.client.gfx.texture.SpriteSheet;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.gfx.texture.TextureLoader;

public class Registry {
	
	public static final void registerGameStates() {
		GameStateLibrary.register(new GSGame());
		GameStateLibrary.register(new GSTest());
		
		//Menus
		GameStateLibrary.register(new GSMenuMain());
	}
	
	public static final void registerTextures() {
		TextureLibrary.registerTexture("Ship",
				TextureLoader.loadTexture("res/texture/ship.png"));
		
		TextureLibrary.registerTexture(
				"Aim",
				TextureLoader.loadTexture("res/texture/aim.png").setTexParams(
						GL11.GL_LINEAR, GL11.GL_TEXTURE_MIN_FILTER,
						GL11.GL_TEXTURE_MAG_FILTER));
		
		TextureLibrary.registerTexture(
				"bg_Space",
				TextureLoader.loadTexture("res/texture/background/space.png")
						.setTexParams(GL11.GL_REPEAT, GL11.GL_TEXTURE_WRAP_S,
								GL11.GL_TEXTURE_WRAP_T));
		TextureLibrary.registerTexture("Button", new DynamicTexture(
				new SpriteSheet("res/texture/gui/button.png", 2, 1)));
	}
	
	public static final void registerSpriteSheets() {
		TextureLibrary.registerSpriteSheet("TestSheet", new SpriteSheet(
				"res/texture/spritesheet/test.png", 8, 8));
		TextureLibrary.registerSpriteSheet("fnt_mc", new SpriteSheet(
				"res/texture/font/font.png", 16, 16));
		TextureLibrary.registerSpriteSheet("fnt_courier", new SpriteSheet(
				"res/texture/font/courier.png", 16, 16));
	}
	
	public static final void registerBackgrounds() {
		BackgroundLibrary.register("Space", new BGSpace());
	}
	
	public static final void destroy() {
		TextureLibrary.destroy();
		GameStateLibrary.destroy();
	}
}