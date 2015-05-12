package sk.client.gfx.gui;

import java.util.ArrayList;

public class GUI {
	
	private ArrayList<GUIElement> guiElements;
	
	public GUI() {
		guiElements = new ArrayList<>();
	}
	
	public GUI addElements(GUIElement... elements) {
		for(GUIElement element : elements)
			guiElements.add(element);
		
		return this;
	}
	
	public GUI click(float x, float y) {
		
		for(GUIElement e : guiElements) {
			if(e.contains(x, y)) {
				e.click(x, y);
			}
		}
		
		return this;
	}
	
	public GUI draw() {
		
		for(GUIElement e : guiElements)
			e.draw();
		
		return this;
	}
	
	public GUI update(float tick) {
		
		for(GUIElement e : guiElements)
			e.update(tick);
		
		return this;
	}
	
}