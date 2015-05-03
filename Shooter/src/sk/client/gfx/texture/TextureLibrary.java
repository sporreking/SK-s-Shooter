package sk.client.gfx.texture;

import java.util.HashMap;

public class TextureLibrary {
	
	private static final HashMap<String, Texture> textures = new HashMap<>();
	
	public static final void register(String name, Texture texture) {
		textures.put(name, texture);
	}
	
	public static final Texture get(String name) {
		return textures.get(name);
	}
}