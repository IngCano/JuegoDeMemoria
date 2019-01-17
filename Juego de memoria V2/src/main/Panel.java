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
	
	public Panel() {
		this.setSize(WIDTH, HEIGHT);
		paintBox = new BufferedImage(Panel.WIDTH, Panel.HEIGHT, BufferedImage.TYPE_INT_RGB);
		game = new Game();
		mouseController = new Mouse();
		this.addMouseListener(mouseController);
		
	}
	
	public void render() {
		Graphics graphicsFromPanel = getGraphics();
		if(graphicsFromPanel != null) {
			Graphics graphicsFromBox = paintBox.getGraphics();
            if(graphicsFromBox != null){
            	fillInBlack(graphicsFromBox);
            	if(mouseController.mouseReleased) {
            		mouseController.mouseReleased = false;
            		for(ClickableBox b : game.boxes) {
            			if((mouseController.x > b.xPos && mouseController.x < (b.xPos+b.xSize)) &&
            					(mouseController.y > b.yPos && mouseController.y < (b.yPos+b.ySize))) {
            				b.clicked = !b.clicked;
            			}
            		}
            	}
            	game.paintBoxes(graphicsFromBox);
            	graphicsFromBox.dispose();
            }
            graphicsFromPanel.drawImage(paintBox, 0, 0, null);
		}
	}
	
	public static void fillInBlack(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
	
}
