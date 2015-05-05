package sk.client.gfx.texture;

import sk.client.debug.Debug;
import sk.client.util.Util;

public class SpriteSheet {
	
	private Texture[] textures;
	
	private int framesX;
	private int framesY;
	private int width;
	private int height;
	private int frameWidth;
	private int frameHeight;
	
	public SpriteSheet(String path, int framesX, int framesY) {
		this.framesX = framesX;
		this.framesY = framesY;
		
		int[][] pixels = TextureLoader.loadPixelData(path);
		
		width = pixels[0].length;
		height = pixels.length;
		frameWidth = width / framesX;
		frameHeight = height / framesY;
		
		if (!Util.isInPow2(frameWidth) && Util.isInPow2(frameHeight))
			throw new IllegalStateException("The frame width \"" + frameWidth
					+ "\" and frame height \"" + frameHeight
					+ "\" are not in the power of two");
		if (!Util.isInPow2(frameWidth))
			throw new IllegalStateException("The frame width \"" + frameWidth
					+ "\" is not in the power of two");
		if (!Util.isInPow2(frameHeight))
			throw new IllegalStateException("The frame height \"" + frameHeight
					+ "\" is not in the power of two");
		
		textures = new Texture[framesX * framesY];
		
		for (int i = 0; i < framesY; i++) {
			for (int j = 0; j < framesX; j++) {
				int[] data = new int[frameWidth * frameHeight];
				
				for (int k = 0; k < frameHeight; k++) {
					for (int l = 0; l < frameWidth; l++) {
						data[(l % frameWidth) + k * frameWidth] = pixels[i
								* frameHeight + k][j * frameWidth + l];
					}
				}
				
				textures[(j % framesX) + i * framesX] = new Texture(frameWidth,
						frameHeight, data);
			}
		}
		
	}
	
	public Texture getTexture(int index) {
		if (index >= textures.length)
			throw new IllegalArgumentException("No texture at index \"" + index
					+ "\"");
		
		return textures[index];
	}
	
	public Texture getTexture(int x, int y) {
		if ((x % framesX) + y * framesX >= textures.length)
			throw new IllegalArgumentException("No texture at x: " + x + " y: "
					+ y);
		
		return textures[(x % framesX) + y * framesX];
	}
	
	public int getFramesX() {
		return framesX;
	}
	
	public int getFramesY() {
		return framesY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getFrameWidth() {
		return frameWidth;
	}
	
	public int getFrameHeight() {
		return frameHeight;
	}
	
	public void destroy() {
		for (Texture t : textures)
			t.destroy();
	}
}