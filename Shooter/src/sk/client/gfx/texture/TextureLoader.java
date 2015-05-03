package sk.client.gfx.texture;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class TextureLoader {
	
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