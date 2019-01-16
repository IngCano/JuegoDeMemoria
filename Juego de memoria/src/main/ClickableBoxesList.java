package main;

import java.awt.Color;
import java.util.ArrayList;

public class ClickableBoxesList {
	
	public ArrayList<ClickableBox> boxes;
	
	public ClickableBoxesList() {
		boxes = new ArrayList<>();
		boxes.add(new ClickableBox(100, 50, 300, 240, Color.BLUE));
		boxes.add(new ClickableBox(400, 50, 300, 240, Color.RED));
		boxes.add(new ClickableBox(100, 290, 300, 240, Color.GREEN));
		boxes.add(new ClickableBox(400, 290, 300, 240, Color.YELLOW));
	}
}
