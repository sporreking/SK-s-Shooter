package sk.client.renderer;

import org.lwjgl.opengl.GL11;

import sk.client.gfx.texture.SpriteSheet;
import sk.client.gfx.texture.TextureLibrary;

public final class TextRenderer {
	
	public static final int ASCII_DIMENSIONS = 16;
	public static final int ASCII_LENGTH = ASCII_DIMENSIONS * ASCII_DIMENSIONS;
	
	private static SpriteSheet font = TextureLibrary.getSpriteSheet("fnt_courier");
	
	private static float size = 48;
	private static float distance = .5f;
	
	public static final void draw(String text, float x, float y) {
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(x, y, 0);
			
			for(int i = 0; i < text.length(); i++) {
				int ascii = getAsciiOffset(text.charAt(i));
				font.getTexture(ascii).bind();
				
				GL11.glBegin(GL11.GL_QUADS);
				{
					GL11.glTexCoord2f(0, 0);
					GL11.glVertex2f(0, 0);
					
					GL11.glTexCoord2f(1, 0);
					GL11.glVertex2f(size, 0);
					
					GL11.glTexCoord2f(1, 1);
					GL11.glVertex2f(size, size);
					
					GL11.glTexCoord2f(0, 1);
					GL11.glVertex2f(0, size);
				}
				GL11.glEnd();
				GL11.glTranslatef(size * distance, 0, 0);
			}
		}
		GL11.glPopMatrix();
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
	}
	
	private static final int getAsciiOffset(char c) {
		return (int) c;
	}
	
	public static final void setSize(float size) {
		TextRenderer.size = size;
	}
	
	public static final float getSize() {
		return size;
	}
	
	public static final void setFont(SpriteSheet font) {
		if((font.getFramesX() & font.getFramesY()) != ASCII_DIMENSIONS)
			throw new IllegalArgumentException("Font sprite sheet grid must be 16x16");
		
		TextRenderer.font = font;
	}
	
	public static final SpriteSheet getFont() {
		return font;
	}
	
	public static final void setDistance(float distance) {
		TextRenderer.distance = distance;
	}
	
	public static final float getDistance() {
		return distance;
	}
}