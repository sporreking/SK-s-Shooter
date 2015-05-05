package sk.client.world;

import sk.audio.AudioManager;
import sk.client.game.Game;
import sk.client.gfx.texture.Background;
import sk.client.world.entity.EntityManager;
import sk.client.world.entity.player.Player;

public class World {
	
	protected Player player;
	protected EntityManager em;
	protected Background background;
	
	public World() {
		em = new EntityManager();
		
		player = new Player(this, Game.WIDTH - Player.PLAYER_WIDTH / 2, Game.HEIGHT - Player.PLAYER_HEIGHT / 2);
		em.addEntity("Player", player);
		
		em.addGroup("Bullets");
		
		AudioManager.playLoop(0, 1, 10, 10, "Main");
		
//		AudioManager.playLoop(0, 1, 0, "Main");
//		AudioManager.fadeLoopPitch(10, 100, 0);
	}
	
	public World setBackground(Background background) {
		
		this.background = background;
		
		return this;
	}
	
	public void checkMouse(int button, boolean pressed) {
		em.checkMouse(button, pressed);
	}
	
	public void checkKeyboard(int key, boolean pressed) {
		em.checkKeyboard(key, pressed);
	}
	
	public void update(float tick) {
//		background.addSpeed(-.0001f);
		background.update(tick);
		em.update(tick);
	}
	
	public void draw() {
		background.draw();
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