package sk.client.world.entity;

import sk.client.gfx.texture.Texture;
import sk.client.renderer.QuadRenderer;

public abstract class EntityQuad extends Entity {
	
	public EntityQuad() {}
	
	public EntityQuad(QuadRenderer eq) {
		renderer = eq;
	}
	
	public EntityQuad(float x, float y, float width, float height) {
		this(x, y, width, height, null);
	}
	
	public EntityQuad(float x, float y, float width, float height, Texture texture) {
		super(new QuadRenderer(x, y, width, height, false, texture));
	}
	
	protected void init() {
		
	}
	
	protected void onUpdate(float tick) {
		
	}
	
	public float getWidth() {
		return ((QuadRenderer)renderer).getWidth();
	}
	
	public float getHeight() {
		return ((QuadRenderer)renderer).getHeight();
	}
	
	public boolean contains(float x, float y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}
	
	protected void destroy() {
		
	}
}