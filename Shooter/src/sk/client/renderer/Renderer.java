package sk.client.renderer;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import sk.client.debug.Debug;
import sk.client.gfx.texture.Texture;

public class Renderer {
	
	private Vertex[] vertices;
	
	private Vector2f scale = new Vector2f(1, 1);
	private Vector2f translation = new Vector2f();
	private float rotation = 0;
	
	private Texture texture;
	
	private int mode = GL11.GL_QUADS;
	
	public Renderer() {}
	
	public Renderer(Vertex[] vertices) {
		this(vertices, null);
	}
	
	public Renderer(Vertex[] vertices, Texture texture) {
		this.vertices = vertices;
		this.texture = texture;
	}
	
	public void draw() {
		
		if(hasTexture()) {
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			texture.bind();
		}
		
		GL11.glPushMatrix();
		{
			GL11.glScalef(scale.x, scale.y, 1);
			GL11.glTranslatef(translation.x, translation.y, 0);
			GL11.glRotatef(rotation, 0, 0, 1);
			GL11.glBegin(mode);
			{
				for(int i = 0; i < vertices.length; i++) {
					Vertex v = vertices[i];
					GL11.glColor4f(v.getR(), v.getG(), v.getB(), v.getA());
					if(hasTexture())
						GL11.glTexCoord2f(v.getS(), v.getT());
					GL11.glVertex2f(v.getX(), v.getY());
				}
			}
			GL11.glEnd();
		}
		GL11.glPopMatrix();
		
		if(hasTexture())
			GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	
	private void adjustRotation() {
		rotation %= 360;
		if(rotation < 0)
			rotation += 360;
	}
	
	public Renderer setVertices(Vertex[] vertices) {
		this.vertices = vertices;
		return this;
	}
	
	public Renderer setTexture(Texture texture) {
		this.texture = texture;
		return this;
	}
	
	public Texture getTexture() {
		return texture;
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
		adjustRotation();
		
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
		adjustRotation();
		return this;
	}
	
	public Renderer setMode(int mode) {
		this.mode = mode;
		return this;
	}
	
	public boolean hasTexture() {
		return texture != null;
	}
	
}