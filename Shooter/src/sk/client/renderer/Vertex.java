package sk.client.renderer;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Vertex {
	
	public Vector2f pos;
	public Vector2f texCoord;
	public Vector4f color;
	
	public Vertex(float x, float y) {
		this(x, y, 1, 1, 1);
	}
	
	public Vertex(float x, float y, float s, float t) {
		this(x, y, s, t, 1, 1, 1);
	}
	
	public Vertex(float x, float y, float r, float g, float b) {
		this(x, y, 0, 0, r, g, b);
	}
	
	public Vertex(float x, float y, float r, float g, float b, float a) {
		this(x, y, 0, 0, r, g, b, a);
	}
	
	public Vertex(float x, float y, float s, float t, float r, float g, float b) {
		this(x, y, s, t, r, g, b, 1);
	}
	
	public Vertex(float x, float y, float s, float t, float r, float g, float b, float a) {
		pos = new Vector2f(x, y);
		texCoord = new Vector2f(s, t);
		color = new Vector4f(r, g, b, a);
	}
	
	public Vector2f getPos() {
		return pos;
	}
	
	public Vector2f getTexCoord() {
		return texCoord;
	}
	
	public Vector4f getColor() {
		return color;
	}
	
	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
	public float getS() {
		return texCoord.x;
	}
	
	public float getT() {
		return texCoord.y;
	}
	
	public float getR() {
		return color.x;
	}
	
	public float getG() {
		return color.y;
	}
	
	public float getB() {
		return color.z;
	}
	
	public float getA() {
		return color.w;
	}
}