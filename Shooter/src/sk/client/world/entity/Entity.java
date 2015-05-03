package sk.client.world.entity;

import org.lwjgl.util.vector.Vector2f;

import sk.client.gamestate.GameState;
import sk.client.renderer.Renderer;

public abstract class Entity {
	
	protected boolean active = true;
	protected boolean visible = true;
	protected boolean updating = true;
	
	protected Renderer renderer;
	
	public Entity() {}
	
	public Entity(Renderer renderer) {
		this.renderer = renderer;
		init();
	}
	
	public void update(float tick) {
		if(active && updating)
			onUpdate(tick);
	}
	
	public void draw() {
		if(active && visible)
			renderer.draw();
	}
	
	//Mandatory
	protected abstract void init();
	protected abstract void onUpdate(float tick);
	protected abstract void destroy();
	
	//Optional
	public void onMouse(int button, boolean pressed) {}
	public void onKeyboard(int key, boolean pressed) {}
	
	public Entity setActive(boolean active) {
		this.active = active;
		return this;
	}
	
	public Entity setVisible(boolean visible) {
		this.visible = visible;
		return this;
	}
	
	public Entity setUpdating(boolean update) {
		this.updating = update;
		return this;
	}
	
	public Entity setPosition(float x, float y) {
		renderer.setTranslation(x, y);
		return this;
	}
	
	public Entity setX(float x) {
		renderer.setX(x);
		return this;
	}
	
	public Entity setY(float y) {
		renderer.setY(y);
		return this;
	}
	
	public Entity translate(float x, float y) {
		renderer.translate(x, y);
		return this;
	}
	
	public Entity setScale(float x, float y) {
		renderer.setScale(x, y);
		return this;
	}
	
	public Entity setScaleX(float x) {
		renderer.setScaleX(x);
		return this;
	}
	
	public Entity setScaleY(float y) {
		renderer.setScaleY(y);
		return this;
	}
	
	public Entity scale(float x, float y) {
		renderer.scale(x, y);
		return this;
	}
	
	public Entity setRotation(float r) {
		renderer.setRotation(r);
		return this;
	}
	
	public Entity rotate(float r) {
		renderer.rotate(r);
		return this;
	}
	
	public Vector2f getPosition() {
		return renderer.getTranslation();
	}
	
	public float getX() {
		return renderer.getX();
	}
	
	public float getY() {
		return renderer.getY();
	}
	
	public Vector2f getScale() {
		return renderer.getScale();
	}
	
	public float getScaleX() {
		return renderer.getScaleX();
	}
	
	public float getScaleY() {
		return renderer.getScaleY();
	}
	
	public float getRotation() {
		return renderer.getRotation();
	}
}