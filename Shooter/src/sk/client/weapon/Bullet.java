package sk.client.weapon;

import org.lwjgl.util.vector.Vector4f;

import sk.client.debug.Debug;
import sk.client.game.Game;
import sk.client.renderer.QuadRenderer;
import sk.client.world.World;
import sk.client.world.entity.Entity;
import sk.client.world.entity.EntityManager;

public class Bullet extends Entity {
	
	protected Vector4f color = new Vector4f(1f, 0f, 0f, 1f);
	
	protected float speed;
	
	protected float width, height;
	
	protected World world;
	
	protected EntityManager em;
	
	public Bullet(World world, float x, float y, float size, float speed, float angle) {
		this.world = world;
		em = world.getEntityManager();
		
		width = size;
		height = size * 1.5f;
		
		renderer = new QuadRenderer(x, y, width, height, color.x, color.y, color.z, color.w, true);
		
		setRotation(angle);
		
		this.speed = speed;
	}
	
	protected void init() {}
	
	protected void onUpdate(float tick) {
		
		if(getX() < 0 || getX() > Game.WIDTH || getY() < 0 || getY() > Game.HEIGHT)
			em.removeFromGroup("Bullets", this);
		
		float dx = (float)Math.sin(Math.toRadians(getRotation())) * speed;
		float dy = -(float)Math.cos(Math.toRadians(getRotation())) * speed;
		
		translate((float)(dx * tick), (float)(dy * tick));
	}
	
	protected void destroy() {
		
	}
}