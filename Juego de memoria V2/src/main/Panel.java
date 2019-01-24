package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.Mouse;

public class Panel extends JPanel{

	public static final int WIDTH = Window.WIDTH;
	public static final int HEIGHT = Window.HEIGHT;
	private BufferedImage paintBox;
	private Mouse mouseController;
	private Game game;
	private Menu menu;
	public static boolean visiblePanel; //False: Menu; True: Game;
	
	public Panel() {
		this.setSize(WIDTH, HEIGHT);
		paintBox = new BufferedImage(Panel.WIDTH, Panel.HEIGHT, BufferedImage.TYPE_INT_RGB);
		game = new Game();
		menu = new Menu();
		mouseController = new Mouse();
		this.addMouseListener(mouseController);
		visiblePanel = false;
	}
	
	public void render() {
		Graphics graphicsFromPanel = getGraphics();
		if(graphicsFromPanel != null) {
			Graphics graphicsFromBox = paintBox.getGraphics();
            if(graphicsFromBox != null){
            	
            	fillInBlack(graphicsFromBox);
            	
            	if(!visiblePanel) {
            		menu.checkForMouseEvents(mouseController);
            		menu.paintMenu();
            		graphicsFromBox.drawImage(menu.mainMenuImage, 0, 0, null);
            		
            	} else {
            		game.checkForUserEvents(mouseController);
            		game.paintBoxes(graphicsFromBox);
            	}
            	
            	graphicsFromBox.dispose();
            }
            graphicsFromPanel.drawImage(paintBox, 0, 0, null);
		}
	}
	
	public static void fillInBlack(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
	
	public static void fillInGivenColor(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
}
