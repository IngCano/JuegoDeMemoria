package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import controller.Mouse;

public class Game {
	
	public ArrayList<ClickableBox> boxes;
	
	public Game() {
		boxes = new ArrayList<>();
		boxes.add(new ClickableBox(100, 50, 300, 240, Color.BLUE));
		boxes.add(new ClickableBox(400, 50, 300, 240, Color.RED));
		boxes.add(new ClickableBox(100, 290, 300, 240, Color.GREEN));
		boxes.add(new ClickableBox(400, 290, 300, 240, Color.YELLOW));
	}
	
	public void paintBoxes(Graphics g) {
		for(ClickableBox b : boxes) {
			if(b.clicked)
				g.setColor(b.defaultColor);
			else
				g.setColor(Color.BLACK);
			g.fillRect(b.xPos, b.yPos, b.xSize, b.ySize);
		}
	}
	
	public void checkForUserEvents(Mouse mouseController) {
		if(mouseController.mouseReleased) {
    		mouseController.mouseReleased = false;
    		for(ClickableBox b : boxes) {
    			if((mouseController.x > b.xPos && mouseController.x < (b.xPos+b.xSize)) &&
    					(mouseController.y > b.yPos && mouseController.y < (b.yPos+b.ySize))) {
    				b.clicked = !b.clicked;
    			}
    		}
    	}
	}
	
}
