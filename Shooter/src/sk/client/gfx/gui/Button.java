package sk.client.gfx.gui;

import sk.client.gfx.texture.Texture;
import sk.client.renderer.QuadRenderer;
import sk.client.util.Util;

public class Button extends GUIElement {
	
	public Button(float x, float y, float width, float height, Texture texture) {
		renderer = new QuadRenderer(x, y, width, height, false, texture);
	}
	
	public void onClick(float x, float y) {}
	
	public void onMouseOver(float tick) {}
	
	public void onMouseIn() {}
	
	public void onMouseOut() {}
	
	public void update(float tick) {
		if(active && updating) {
			if(isMouseOver) {
				onMouseOver(tick);
				if(!contains(Util.getRelativeMX(), Util.getRelativeMY())) {
					onMouseOut();
					isMouseOver = false;
				}
			} else {
				if(contains(Util.getRelativeMX(), Util.getRelativeMY())) {
					onMouseIn();
					isMouseOver = true;
				}
			}
				
			
			onUpdate(tick);
		}
	}
	
	protected void onUpdate(float tick) {}
}