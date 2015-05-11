package sk.client.gfx.gui;

import sk.client.gfx.texture.Texture;
import sk.client.renderer.QuadRenderer;

public class Button extends GUIElement {
	
	public Button(Texture texture, float x, float y, float width, float height) {
		renderer = new QuadRenderer(x, y, width, height, false, texture);
		
		
		
	}
	
	public void onClick(float x, float y) {
		
	}
	
	public void onMouseOver() {
		
	}
	
	public void onMouseIn() {
		
	}
	
	public void onMouseOut() {
		
	}
	
}