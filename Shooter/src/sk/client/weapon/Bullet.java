package sk.client.weapon;

import org.lwjgl.util.vector.Vector4f;

import sk.client.debug.Debug;
import sk.client.game.Game;
import sk.client.renderer.QuadRenderer;
import sk.client.world.World;
import sk.client.world.entity.Entity;
import sk.client.world.entity.EntityManager;

public class Bullet extends Entity {
	
	protected Vector4f color = new Vector4f(.5f, .5f, .5f, 1f);
	
	protected float speed;
	
	protected float width, height;
	
	protected World world;
	
	protected EntityManager em;
	
	public Bullet(World world, float x, float y, float size, float speed, float angle) {
		this.world = world;
		em = world.getEntityManager();
		
		renderer = new QuadRenderer(x, y, size, size, color.x, color.y, color.z, color.w);
		
		setRotation(angle);
		
		width = size;
		height = size;
		
		this.speed = speed;
	}
	
	protected void init() {}
	
	protected void onUpdate(double tick) {
		
		if(getX() < 0 || getX() > Game.WIDTH || getY() < 0 || getY() > Game.HEIGHT)
			em.removeFromGroup("Bullets", this);
		
		float dx = (float)Math.cos(Math.toRadians(getRotation())) * speed;
		float dy = (float)Math.sin(Math.toRadians(getRotation())) * speed;
		
		translate((float)(dx * tick), (float)(dy * tick));
	}
	
	protected void destroy() {
		
	}
}