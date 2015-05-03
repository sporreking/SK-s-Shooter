package sk.client.game;

import sk.client.debug.Debug;
import sk.client.gfx.texture.Background;
import sk.client.gfx.texture.TextureLibrary;
import sk.client.renderer.QuadRenderer;

public class BGSpace extends Background {
	
	public BGSpace() {
		super();
		speed = 1f;
		vertical = true;
		
		bg = new QuadRenderer(0, 0, 3 * Game.WIDTH, 3 * Game.HEIGHT, 3, 3,
				false, TextureLibrary.get("bg_Space"));
	}
	
	public void update(float tick) {
		
		float pr = world.getPlayer().getRotation();
		
		float dx = (float) -(Math.sin(Math.toRadians(pr)) * speed);
		float dy = (float) (Math.cos(Math.toRadians(pr)) * speed);
		
		if (bg.getX() > Game.WIDTH)
			bg.translate(-Game.WIDTH, 0);
		if (bg.getX() < -Game.WIDTH)
			bg.translate(Game.WIDTH, 0);
		
		if (bg.getY() > Game.HEIGHT)
			bg.translate(0, -Game.HEIGHT);
		if (bg.getY() < -Game.HEIGHT)
			bg.translate(0, Game.HEIGHT);
		
		bg.translate(dx * tick * world.getPlayer().getSpeed() * 5, dy * tick);
	}
	
	public void draw() {
		bg.translate(-Game.WIDTH, -Game.HEIGHT).draw();
		bg.translate(Game.WIDTH, Game.HEIGHT);
	}
	
}