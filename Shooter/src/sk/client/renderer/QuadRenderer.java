package sk.client.renderer;

import sk.client.debug.Debug;

public class QuadRenderer extends Renderer {

	public QuadRenderer(float x, float y, float width, float height) {
		this(x, y, width, height, 1, 1, 1);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float r, float g, float b) {
		this(x, y, width, height, r, g, b, 1);
	}
	
	public QuadRenderer(float x, float y, float width, float height, float r, float g, float b, float a) {
		super(new Vertex[] {
				new Vertex(-width/2, -height/2, r, g, b, a),
				new Vertex(width/2, -height/2, r, g, b, a),
				new Vertex(width/2, height/2, r, g, b, a),
				new Vertex(-width/2, height/2, r, g, b, a)
		});
		
		setTranslation(x, y);
	}
}