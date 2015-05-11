package sk.client.renderer;

import sk.client.debug.Debug;
import sk.client.gfx.texture.Texture;

public class QuadRenderer extends Renderer {
	
	protected float width, height;
	
	public QuadRenderer(float x, float y, float width, float height, boolean centralize) {
		this(x, y, width, height, 1, 1, 1, centralize, null);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float r, float g, float b, boolean centralize) {
		this(x, y, width, height, r, g, b, 1, centralize, null);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float r, float g, float b, float a, boolean centralize) {
		this(x, y, width, height, r, g, b, a, centralize, null);
	}
	
	public QuadRenderer(float x, float y, float width, float height, boolean centralize, Texture texture) {
		this(x, y, width, height, 1, 1, 1, centralize, texture);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float r, float g, float b, boolean centralize, Texture texture) {
		this(x, y, width, height, r, g, b, 1, centralize, texture);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float s, float t, boolean centralize) {
		this(x, y, width, height, s, t, 1, 1, 1, centralize, null);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float s, float t, float r, float g, float b, boolean centralize) {
		this(x, y, width, height, s, t, r, g, b, 1, centralize, null);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float s, float t, float r, float g, float b, float a, boolean centralize) {
		this(x, y, width, height, s, t, r, g, b, a, centralize, null);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float s, float t, boolean centralize, Texture texture) {
		this(x, y, width, height, s, t, 1, 1, 1, centralize, texture);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float s, float t, float r, float g, float b, boolean centralize, Texture texture) {
		this(x, y, width, height, s, t, r, g, b, 1, centralize, texture);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float r, float g, float b, float a, boolean centralize, Texture texture) {
		this(x, y, width, height, 1, 1, r, g, b, a, centralize, texture);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float s, float t, float r, float g, float b, float a, boolean centralize, Texture texture) {
		
		this.width = width;
		this.height = height;
		
		if(centralize) {
			setVertices(new Vertex[] {
					new Vertex(-width/2, -height/2, 0, 0, r, g, b, a),
					new Vertex(width/2, -height/2, s, 0, r, g, b, a),
					new Vertex(width/2, height/2, s, t, r, g, b, a),
					new Vertex(-width/2, height/2, 0, t, r, g, b, a)
			});
		} else {
			setVertices(new Vertex[] {
					new Vertex(0, 0, 0, 0, r, g, b, a),
					new Vertex(width, 0, s, 0, r, g, b, a),
					new Vertex(width, height, s, t, r, g, b, a),
					new Vertex(0, height, 0, t, r, g, b, a)
			});
		}
		
		setTexture(texture);
		
		setTranslation(x, y);
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
}