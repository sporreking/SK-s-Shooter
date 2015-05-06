package sk.client.renderer;

import org.lwjgl.opengl.GL11;

import sk.client.gfx.texture.SpriteSheet;

public final class TextRenderer {
	
	public static final int ASCII_DIMENSIONS = 16;
	public static final int ASCII_LENGTH = ASCII_DIMENSIONS * ASCII_DIMENSIONS;
	
	private static SpriteSheet font;
	
	private static float size = 48;
	
	public static final void setFont(SpriteSheet font) {
		if((font.getFramesX() & font.getFramesY()) != ASCII_DIMENSIONS)
			throw new IllegalArgumentException("Font sprite sheet grid must be 16x16");
		
		TextRenderer.font = font;
	}
	
	public static final void setSize(float size) {
		TextRenderer.size = size;
	}
	
	public static final void draw(String text, float x, float y) {
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(x, y, 0);
			
			for(int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				getAsciiOffset(c);
			}
			
			
		}
		GL11.glPopMatrix();
	}
	
	private static final void getAsciiOffset(char c) {
		System.out.println((int)c);
	}
}