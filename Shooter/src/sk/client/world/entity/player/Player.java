package sk.client.world.entity.player;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import sk.client.debug.Debug;
import sk.client.game.Game;
import sk.client.renderer.QuadRenderer;
import sk.client.renderer.Renderer;
import sk.client.weapon.Bullet;
import sk.client.world.World;
import sk.client.world.entity.Entity;
import sk.client.world.entity.EntityManager;

public class Player extends Entity {
	
	public static final float PLAYER_WIDTH = 100;
	public static final float PLAYER_HEIGHT = 100;
	
	private World world;
	private EntityManager em;
	
	public Player(World world, float spawnX, float spawnY) {
		super(new QuadRenderer(spawnX, spawnY, PLAYER_WIDTH, PLAYER_HEIGHT, 0, 1, 1));
		
		this.world = world;
		em = world.getEntityManager();
	}
	

	protected void init() {}
	
	public void onMouse(int button, boolean pressed) {
		if(pressed) {
			switch(button) {
			case 0: em.addToGroup("Bullets", new Bullet(world, getX(), getY(), 10, 1000, getRotation()));
			}
		}
	}
	public void onKeyboard(int key, boolean pressed) {}
	
	protected void onUpdate(double tick) {
		boolean w = Keyboard.isKeyDown(Keyboard.KEY_W);
		boolean a = Keyboard.isKeyDown(Keyboard.KEY_A);
		boolean s = Keyboard.isKeyDown(Keyboard.KEY_S);
		boolean d = Keyboard.isKeyDown(Keyboard.KEY_D);
		
		float speed = 500f;
		
		if(w)
			translate(0, -(float)(tick * speed));
		if(a)
			translate(-(float)(tick * speed), 0);
		if(s)
			translate(0, (float)(tick * speed));
		if(d)
			translate((float)(tick * speed), 0);
		
		float dx = Mouse.getX() - getX() / Game.WIDTH * Display.getWidth();
		float dy = (Display.getHeight() - Mouse.getY()) - getY() / Game.HEIGHT * Display.getHeight();
		
		float angle = (float)Math.toDegrees(Math.atan2(dy, dx));
		
		setRotation(angle);
	}
	
	protected void destroy() {}
	
	
}