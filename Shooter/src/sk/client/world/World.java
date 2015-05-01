package sk.client.world;

import sk.client.game.Game;
import sk.client.world.entity.EntityManager;
import sk.client.world.entity.player.Player;

public class World {
	
	protected Player player;
	protected EntityManager em;
	
	public World() {
		em = new EntityManager();
		
		player = new Player(this, Game.WIDTH - Player.PLAYER_WIDTH / 2, Game.HEIGHT - Player.PLAYER_HEIGHT / 2);
		em.addEntity("Player", player);
		
		em.addGroup("Bullets");
	}
	
	public void checkMouse(int button, boolean pressed) {
		em.checkMouse(button, pressed);
	}
	
	public void checkKeyboard(int key, boolean pressed) {
		em.checkKeyboard(key, pressed);
	}
	
	public void update(double tick) {
		em.update(tick);
	}
	
	public void draw() {
		em.draw();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void destroy() {
		em.destroy();
	}
}