package sk.client.gfx.texture;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class TextureLoader {
	
	public static final int[][] loadPixelData(String path) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			
			int width = img.getWidth();
			int height = img.getHeight();
			
			int[] data = new int[width * height];
			
			img.getRGB(0, 0, width, height, data, 0, width);
			
			int[][] pixels = new int[height][width];
			
			for(int i = 0; i < pixels.length; i++) {
				for(int j = 0; j < pixels[i].length; j++) {
					pixels[i][j] = data[(j % width) + i * width];
				}
			}
			
			return pixels;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static final Texture loadTexture(String path) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			
			int width = img.getWidth();
			int height = img.getHeight();
			
			int[] pixels = new int[width * height];
			
			img.getRGB(0, 0, width, height, pixels, 0, width);
			
			return new Texture(width, height, pixels);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Texture(2, 2, new int[]{0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF});
	}
	
}