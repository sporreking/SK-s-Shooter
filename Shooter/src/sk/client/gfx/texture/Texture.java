package sk.client.gfx.texture;

public class Texture {
	
	protected int id;
	protected int width;
	protected int height;
	
	protected String path;
	
	public Texture() {}
	
	public Texture(String path) {
		
	}
	
	public void loadTexture(String path) {
		this.path = path;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}