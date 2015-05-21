package sk.client.gfx.texture;

public class DynamicTexture extends Texture {
	
	private SpriteSheet spriteSheet;
	
	private int currentFrameX = 0;
	private int currentFrameY = 0;
	
	public DynamicTexture(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
	public void swap(int index) {
		if(index >= spriteSheet.getFramesX() * spriteSheet.getFramesY())
			throw new IllegalArgumentException("No texture at index \"" + index
					+ "\"");
		swap(index % spriteSheet.getFramesX(), Math.floorDiv(index, spriteSheet.getFramesX()));
	}
	
	public void swap(int x, int y) {
		if(x >= spriteSheet.getFramesX())
			throw new IllegalArgumentException("No texture at x: " + x + " y: "
					+ y);
		currentFrameX = x;
		currentFrameY = y;
	}
	
	public boolean increment(int i) {
		int length = currentFrameX + currentFrameY * spriteSheet.getFramesX();
		if(length + i >= spriteSheet.getLength())
			return false;
		
		swap(length + i);
		
		return true;
	}
	
	public boolean decrement(int i) {
		int length = currentFrameX + currentFrameY * spriteSheet.getFramesX();
		if(length - i < 0)
			return false;
		
		swap(length - i);
		
		return true;
	}
	
	public void bind() {
		spriteSheet.getTexture(currentFrameX, currentFrameY).bind();
	}
	
	public Texture getCurrentTexture() {
		return spriteSheet.getTexture(currentFrameX, currentFrameY);
	}
	
	public int getCurrentFrameX() {
		return currentFrameX;
	}
	
	public int getCurrentFrameY() {
		return currentFrameY;
	}
}