package sk.client.util;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import sk.client.game.Game;

public final class Util {
	
	public static final float getRelativeMX() {
		return ((float)Mouse.getX()) / Display.getWidth() * Game.WIDTH;
	}
	
	public static final float getRelativeMY() {
		return ((float)(Mouse.getY() * -1) + Display.getHeight() - 1) / Display.getHeight() * Game.HEIGHT;
	}
	
	public static final boolean isInPow2(int number) {
		for(int i = 2; i <= number; i *= 2)
			if(i == number)
				return true;
		return false;
	}
	
	public static final boolean isPrintable(char c) {
		return !Character.isISOControl(c);
	}
}