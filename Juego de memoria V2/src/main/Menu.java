package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import controller.Mouse;

public class Menu {
	
	private ClickableBoxImage menuTitle;
	private ClickableBox menuStart;
	private ClickableBox menuExit;
	private ClickableBox menuScore;
	
	public BufferedImage mainMenuImage;
	
	public Menu() {
		mainMenuImage = new BufferedImage(Panel.WIDTH, Panel.HEIGHT, BufferedImage.TYPE_INT_RGB);
		try {
			menuTitle = new ClickableBoxImage(ImageIO.read(new File("src/images/crackman.regular.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//menuStart = new ClickableBoxImage();
		//menuExit = new ClickableBoxImage();
		//menuScore = new ClickableBoxImage();
	}
	
	public void paintMenu() {
		Graphics g = mainMenuImage.getGraphics();
		if(g != null) {
			Panel.fillInGivenColor(g, Color.WHITE);
			g.drawImage(menuTitle.image, menuTitle.xPos, menuTitle.yPos, null);
			g.dispose();
		}
	}
	
	public void checkForMouseEvents(Mouse mouseController) {
		if(mouseController.mouseReleased) {
			mouseController.mouseReleased = false;
			
			if((mouseController.x > menuTitle.xPos && mouseController.x < (menuTitle.xPos + menuTitle.image.getWidth())) &&
					(mouseController.y > menuTitle.yPos && mouseController.y < (menuTitle.yPos + menuTitle.image.getHeight()))) {
				menuTitle.clicked =! menuTitle.clicked;
				Panel.visiblePanel = true;
			}
		}
	}
}
