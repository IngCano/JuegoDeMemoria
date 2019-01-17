package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Menu {
	
	private final String title = "Memory Game";
	private ArrayList<ClickableBox> menuBoxes;
	private final String[] menuOptions = {
			"Start New Game",
			"Exit",
			"View Scores"};
	public BufferedImage mainMenuImage;
	
	public Menu() {
		mainMenuImage = new BufferedImage(Panel.WIDTH, Panel.HEIGHT, BufferedImage.TYPE_INT_RGB);
		menuBoxes = new ArrayList<>();
	}
	
	public void paintMenu() {
		Graphics g = mainMenuImage.getGraphics();
		if(g != null) {
			Panel.fillInBlack(g);
			g.setColor(Color.GREEN);
			g.drawChars(title.toCharArray(), 0, 5, 100, 100);
			
		}
	}
}
