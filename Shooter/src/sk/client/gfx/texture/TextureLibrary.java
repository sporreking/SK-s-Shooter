package sk.client.gfx.texture;

import java.util.HashMap;

public class TextureLibrary {
	
	private static final HashMap<String, Texture> textures = new HashMap<>();	
	private static final HashMap<String, SpriteSheet> spriteSheets = new HashMap<>();
	
	public static final void registerTexture(String name, Texture texture) {
		textures.put(name, texture);
	}
	
	public static final Texture getTexture(String name) {
		return textures.get(name);
	}
	
	public static final void registerSpriteSheet(String name, SpriteSheet spriteSheet) {
		spriteSheets.put(name, spriteSheet);
	}
	
	public static final SpriteSheet getSpriteSheet(String name) {
		return spriteSheets.get(name);
	}
	
	public static final void destroy() {
		for(Texture t : textures.values()) {
			t.destroy();
			System.out.println("Destroyed texture with id: \"" + t.getID() + "\"");
		}
		for(SpriteSheet ss : spriteSheets.values())
			ss.destroy();
	}
}