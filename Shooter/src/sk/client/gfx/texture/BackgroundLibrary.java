package sk.client.gfx.texture;

import java.util.HashMap;

public class BackgroundLibrary {

	private static final HashMap<String, Background> backgrounds = new HashMap<>();
	
	public static final void register(String name, Background background) {
		backgrounds.put(name, background);
	}
	
	public static final Background get(String name) {
		return backgrounds.get(name);
	}
}