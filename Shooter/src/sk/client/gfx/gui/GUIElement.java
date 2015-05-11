package sk.client.gfx.gui;

import sk.client.renderer.QuadRenderer;

public abstract class GUIElement {
	
	protected QuadRenderer renderer;
	
	public final void click(float x, float y) {
		onClick(x, y);
	}
	
	public abstract void onClick(float x, float y);
	
	public final void mouseOver() {
		onMouseOver();
	}
	
	public abstract void onMouseOver();
	
	public final void mouseIn() {
		onMouseIn();
	}
	
	public abstract void onMouseIn();
	
	public final void mouseOut() {
		onMouseOut();
	}
	
	public abstract void onMouseOut();
	
	public float getWidth() {
		return renderer.getWidth();
	}
	
	public float getHeight() {
		return renderer.getHeight();
	}
	
}