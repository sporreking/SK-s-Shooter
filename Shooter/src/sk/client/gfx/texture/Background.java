package sk.client.gfx.texture;

import sk.client.game.Game;
import sk.client.renderer.QuadRenderer;
import sk.client.world.World;

public class Background {
	
	protected QuadRenderer bg;
	
	protected float speed;
	
	protected boolean vertical;
	
	protected World world;
	
	public Background() {
		
	}
	
	public Background(Texture bgTexture, float speed, boolean vertical) {
		this.speed = speed;
		this.vertical = vertical;
		
		bg = new QuadRenderer(0, 0, Game.WIDTH, Game.HEIGHT, false, bgTexture);
	}
	
	public Background setWorld(World world) {
		this.world = world;
		return this;
	}
	
	public void update(float tick) {
		if(vertical) {
			bg.translate(0, speed * tick);
			if(bg.getY() > Game.HEIGHT)
				bg.translate(0, -Game.HEIGHT);
			if(bg.getY() < -Game.HEIGHT)
				bg.translate(0, Game.HEIGHT);
		} else {
			bg.translate(speed * tick, 0);
			if(bg.getX() > Game.WIDTH)
				bg.translate(-Game.WIDTH, 0);
			if(bg.getX() < -Game.WIDTH)
				bg.translate(Game.WIDTH, 0);
		}
	}
	
	public void draw() {
		bg.draw();
		
		if(vertical)
			bg.translate(0, speed > 0 ? -Game.HEIGHT : Game.HEIGHT);
		else
			bg.translate(speed > 0 ? -Game.WIDTH : Game.WIDTH, 0);
		
		bg.draw();
		
		if(vertical)
			bg.translate(0, speed > 0 ? Game.HEIGHT : -Game.HEIGHT);
		else
			bg.translate(speed > 0 ? Game.WIDTH : -Game.WIDTH, 0);
	}
	
	public Background addSpeed(float speed) {
		this.speed += speed;
		return this;
	}
	
	public Background setSpeed(float speed) {
		this.speed = speed;
		return this;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public boolean isVertical() {
		return vertical;
	}
	
	public Background setVertical(boolean vertical) {
		this.vertical = vertical;
		return this;
	}
	
}