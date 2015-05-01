package sk.client.renderer;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class Vertex {
	
	public Vector2f pos;
	public Vector4f color;
	
	public Vertex(float x, float y) {
		this(new Vector2f(x, y));
	}
	
	public Vertex(Vector2f pos) {
		this.pos = pos;
	}
	
	public Vertex(float x, float y, float r, float g, float b) {
		this(new Vector2f(x, y), new Vector3f(r, g, b));
	}
	
	public Vertex(float x, float y, Vector3f color) {
		this(new Vector2f(x, y), new Vector4f(color.getX(), color.getY(), color.getZ(), 1));
	}
	
	public Vertex(float x, float y, float r, float g, float b, float a) {
		this(new Vector2f(x, y), new Vector4f(r, g, b, a));
	}
	
	public Vertex(float x, float y, Vector4f color) {
		this(new Vector2f(x, y), color);
	}
	
	public Vertex(Vector2f pos, float r, float g, float b) {
		this(pos, new Vector3f(r, g, b));
	}
	
	public Vertex(Vector2f pos, Vector3f color) {
		this(pos, new Vector4f(color.getX(), color.getY(), color.getZ(), 1));
	}
	
	public Vertex(Vector2f pos, float r, float g, float b, float a) {
		this(pos, new Vector4f(r, g, b, a));
	}
	
	public Vertex(Vector2f pos, Vector4f color) {
		this.pos = pos;
		this.color = color;
	}
}