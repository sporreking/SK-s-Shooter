package sk.client.util;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import sk.client.game.Game;

public final class Util {
	
	public static final float getRelativeMX() {
		return ((float)Mouse.getX()) / Display.getWidth() * Game.WIDTH;
	}
	
	public static final float getRelativeMY() {
		return ((float)(Mouse.getY() * -1) + Display.getHeight()) / Display.getHeight() * Game.HEIGHT;
	}
	
}