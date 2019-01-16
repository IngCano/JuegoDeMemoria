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
	private ClickableBoxesList clickableBoxesList;
	private Mouse mouseController;
	
	public Panel() {
		this.setSize(WIDTH, HEIGHT);
		paintBox = new BufferedImage(Panel.WIDTH, Panel.HEIGHT, BufferedImage.TYPE_INT_RGB);
		clickableBoxesList = new ClickableBoxesList();
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
            		for(ClickableBox b : clickableBoxesList.boxes) {
            			if((mouseController.x > b.xPos && mouseController.x < (b.xPos+b.xSize)) &&
            					(mouseController.y > b.yPos && mouseController.y < (b.yPos+b.ySize))) {
            				b.clicked = !b.clicked;
            			}
            		}
            	}
            	paintBoxes(graphicsFromBox);
            	graphicsFromBox.dispose();
            }
            graphicsFromPanel.drawImage(paintBox, 0, 0, null);
		}
	}
	
	public void fillInBlack(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
	
	public void paintBoxes(Graphics g) {
		for(ClickableBox b : clickableBoxesList.boxes) {
			if(b.clicked)
				g.setColor(b.defaultColor);
			else
				g.setColor(Color.BLACK);
			g.fillRect(b.xPos, b.yPos, b.xSize, b.ySize);
		}
	}
}
