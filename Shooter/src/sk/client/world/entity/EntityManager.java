package sk.client.world.entity;

import java.util.ArrayList;
import java.util.HashMap;

import sk.client.game.Game;

public class EntityManager {
	
	private HashMap<String, Entity> entities;
	private ArrayList<Entity> entityTrash;
	private HashMap<String, Group> groups;
	
	public EntityManager() {
		entities = new HashMap<>();
		groups = new HashMap<>();
		
		entityTrash = new ArrayList<>();
	}
	
	public void checkMouse(int button, boolean pressed) {
		for(Group g : groups.values()) {
			g.checkMouse(button, pressed);
		}
		
		for(Entity e : entities.values()) {
			e.onMouse(button, pressed);
		}
	}
	
	public void checkKeyboard(int key, boolean pressed) {
		for(Group g : groups.values()) {
			g.checkKeyboard(key, pressed);
		}
		
		for(Entity e : entities.values()) {
			e.onKeyboard(key, pressed);
		}
	}
	
	public void update(double tick) {
		for(Group g : groups.values()) {
			g.update(tick);
		}
		
		for(Entity e : entities.values()) {
			e.update(tick);
		}
		
		for(Entity e : entityTrash) {
			entities.remove(e);
		}
		
		clearTrash();
	}
	
	private void clearTrash() {
		for(Entity e : entityTrash) {
			entities.remove(e);
		}
		
		entityTrash.clear();
	}
	
	public void draw() {
		for(Group g : groups.values()) {
			g.draw();
		}
		
		for(Entity e : entities.values()) {
			e.draw();
		}
	}
	
	public EntityManager addEntity(String name, Entity entity) {
		entities.put(name, entity);
		return this;
	}
	
	public Entity getEntity(String name) {
		if(entities.get(name) == null)
			throw new IllegalArgumentException("Unrecognized entity name \""
					+ name + "\"");
		
		return entities.get(name);
	}
	
	public EntityManager addGroup(String... names) {
		for(String name : names) {
			groups.put(name, new Group(name));
		}
		
		return this;
	}
	
	public ArrayList<Entity> getEntitiesFromGroup(String name) {
		if(groups.get(name) == null)
			throw new IllegalArgumentException("Unrecognized group name \""
					+ name + "\"");
		
		return groups.get(name).entities;
	}
	
	public EntityManager addToGroup(String group, Entity... entities) {
		for(Entity e : entities) {
			if(groups.get(group) == null)
				throw new IllegalArgumentException("Unrecognized group name \""
						+ group + "\"");
			groups.get(group).entities.add(e);
		}
		return this;
	}
	
	public EntityManager removeEntity(String name) {
		return removeEntity(entities.get(name));
	}
	
	public EntityManager removeEntity(Entity e) {
		entityTrash.add(e);
		return this;
	}
	
	public EntityManager removeFromGroup(String group, Entity... entities) {
		for(Entity e : entities) {
			groups.get(group).entityTrash.add(e);
		}
		return this;
	}
	
	public EntityManager setGroupVisible(boolean visible, String... groups) {
		for(String g : groups) {
			if(this.groups.get(g) == null)
				throw new IllegalArgumentException("Unrecognized group name \""
						+ g + "\"");
			
			this.groups.get(g).visible = visible;
		}
		return this;
	}
	
	public EntityManager setGroupUpdating(boolean updating, String... groups) {
		for(String g : groups) {
			if(this.groups.get(g) == null)
				throw new IllegalArgumentException("Unrecognized group name \""
						+ g + "\"");
			
			this.groups.get(g).updating = updating;
		}
		return this;
	}
	
	public EntityManager setGroupActive(boolean active, String... groups) {
		for(String g : groups) {
			if(this.groups.get(g) == null)
				throw new IllegalArgumentException("Unrecognized group name \""
						+ g + "\"");
			
			this.groups.get(g).active = active;
		}
		return this;
	}
	
	public void destroy() {
		for(Entity e : entities.values())
			e.destroy();
		for(Group g : groups.values())
			g.destroy();
		entities.clear();
		groups.clear();
	}
	
	private class Group {
		final String NAME;
		
		ArrayList<Entity> entities;
		ArrayList<Entity> entityTrash;
		boolean active = true;
		boolean visible = true;
		boolean updating = true;
		
		Group(String name) {
			this.NAME = name;
			entities = new ArrayList<>();
			entityTrash = new ArrayList<>();
		}
		
		void checkMouse(int button, boolean pressed) {
			if(active && updating) {
				for(Entity e : entities)
					e.onMouse(button, pressed);
			}
		}
		
		void checkKeyboard(int key, boolean pressed) {
			if(active && updating) {
				for(Entity e : entities)
					e.onKeyboard(key, pressed);
			}
		}
		
		void update(double tick) {
			if(active && updating) {
				for(Entity e : entities)
					e.update(tick);
			}
			
			clearTrash();
		}
		
		private void clearTrash() {
			for(Entity e : entityTrash) {
				entities.remove(e);
			}
			
			entityTrash.clear();
		}
		
		void draw() {
			if(active && visible) {
				for(Entity e : entities)
					e.draw();
			}
		}
		
		void destroy() {
			for(Entity e : entities)
				e.destroy();
		}
	}
}