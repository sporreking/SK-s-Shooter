package sk.client.gfx.texture;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class Texture {
	
	protected int id;
	protected int width;
	protected int height;
	
	public Texture() {}
	
	public Texture(int width, int height, int[] pixels) {
		createTexture(width, height, pixels);
	}
	
	protected Texture createTexture(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		
		id = GL11.glGenTextures();
		
		bind();
		
		IntBuffer buffer = ByteBuffer.allocateDirect(pixels.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
		
		buffer.put(pixels);
		
		buffer.flip();
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0,
				GL12.GL_BGRA, GL11.GL_UNSIGNED_BYTE, buffer);
		
		setTexParams(GL11.GL_NEAREST, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_TEXTURE_MAG_FILTER);
		setTexParams(GL11.GL_CLAMP, GL11.GL_TEXTURE_WRAP_S, GL11.GL_TEXTURE_WRAP_T);
		
		return this;
	}
	
	public Texture setTexParams(int value, int... targets) {
		bind();
		for(int t : targets)
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, t, value);
		
		return this;
	}
	
	public void bind() {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getID() {
		return id;
	}
	
	public void destroy() {
		GL11.glDeleteTextures(id);
	}
}