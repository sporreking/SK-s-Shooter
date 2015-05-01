package sk.client.renderer;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import sk.client.debug.Debug;

public class Renderer {
	
	private Vertex[] vertices;
	
	private Vector2f scale = new Vector2f(1, 1);
	private Vector2f translation = new Vector2f();
	private float rotation = 0;
	
	private int mode = GL11.GL_QUADS;
	
	public Renderer() {}
	
	public Renderer(Vertex[] vertices) {
		this.vertices = vertices;
	}
	
	public void draw() {
		GL11.glPushMatrix();
		{
			GL11.glScalef(scale.x, scale.y, 1);
			GL11.glTranslatef(translation.x, translation.y, 0);
			GL11.glRotatef(rotation, 0, 0, 1);
			GL11.glBegin(mode);
			{
				for(int i = 0; i < vertices.length; i++) {
					Vertex v = vertices[i];
					GL11.glColor4f(v.color.x, v.color.y, v.color.z, v.color.w);
					GL11.glVertex2f(vertices[i].pos.x, vertices[i].pos.y);
				}
			}
			GL11.glEnd();
		}
		GL11.glPopMatrix();
	}
	
	public Vector2f getTranslation() {
		return translation;
	}
	
	public Vector2f getScale() {
		return scale;
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public float getX() {
		return translation.x;
	}
	
	public float getY() {
		return translation.y;
	}
	
	public float getScaleX() {
		return scale.x;
	}
	
	public float getScaleY() {
		return scale.y;
	}
	
	public Renderer translate(float x, float y) {
		translation.x += x;
		translation.y += y;
		return this;
	}
	
	public Renderer scale(float x, float y) {
		scale.x += x;
		scale.y += y;
		return this;
	}
	
	public Renderer rotate(float r) {
		rotation += r;
		r %= 360;
		return this;
	}
	
	public Renderer setTranslation(float x, float y) {
		translation.x = x;
		translation.y = y;
		return this;
	}
	
	public Renderer setX(float x) {
		translation.x = x;
		return this;
	}
	
	public Renderer setY(float y) {
		translation.y = y;
		return this;
	}
	
	public Renderer setScale(float x, float y) {
		scale.x = x;
		scale.y = y;
		return this;
	}
	
	public Renderer setScaleX(float x) {
		scale.x = x;
		return this;
	}
	
	public Renderer setScaleY(float y) {
		scale.y = y;
		return this;
	}
	
	public Renderer setRotation(float r) {
		rotation = r;
		return this;
	}
	
	public Renderer setMode(int mode) {
		this.mode = mode;
		return this;
	}
	
}