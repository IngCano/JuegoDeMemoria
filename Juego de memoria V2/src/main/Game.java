package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import controller.Mouse;

public class Game {
	
	public ArrayList<ClickableBox> boxes;
	public ArrayList<ClickableBox> clickSteps;
	public int score, scorePosX, scorePosY;
	public boolean isClickEnabled;
	public int currentStep;
	public boolean loss;
	public boolean cycleDone;
	public boolean generateStep;
	private int counter;
	private int index;
	
	public ClickableBoxImage youLoseButton;
	
	public Game() {
		
		try {
			youLoseButton = new ClickableBoxImage(ImageIO.read(new File("src/images/youlosemessage.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		generateStep = true;
		index = 0;
		counter = 0;
		loss = false;
		cycleDone = true;
		currentStep = 0;
		score = 0;
		scorePosX = 200;
		scorePosY = 40;
		isClickEnabled = false;
		clickSteps = new ArrayList<>();
		boxes = new ArrayList<>();
		boxes.add(new ClickableBox(100, 50, 300, 240, Color.BLUE));
		boxes.add(new ClickableBox(400, 50, 300, 240, Color.RED));
		boxes.add(new ClickableBox(100, 290, 300, 240, Color.GREEN));
		boxes.add(new ClickableBox(400, 290, 300, 240, Color.YELLOW));
	}
	
	public void paintBoxes(Graphics g) {
		for(ClickableBox b : boxes) {
			if(b.isVisible)
				g.setColor(b.defaultColor);
			else
				g.setColor(Color.BLACK);
			g.fillRect(b.xPos, b.yPos, b.xSize, b.ySize);
		}
	}
	
	public void paintScore(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, scorePosX, scorePosY);
	}
	
	public void showBox(ClickableBox box) {
		box.isVisible = true;
	}
	
	public void hideBox(ClickableBox box) {
		box.isVisible = false;
	}
	
	public void checkForUserEvents(Mouse mouseController) {
		if(mouseController.mouseReleased) {
    		mouseController.mouseReleased = false;
    		
    		if(isClickEnabled) {
    			if(loss) {
        			if((mouseController.x > youLoseButton.xPos && mouseController.x < (youLoseButton.xPos + youLoseButton.image.getWidth())) &&
        				(mouseController.y > youLoseButton.yPos && mouseController.y < (youLoseButton.yPos + youLoseButton.image.getHeight()))) {
        				youLoseButton.clicked =! youLoseButton.clicked;
        				Panel.visiblePanel = false;
        			}
    			} else
    				for(ClickableBox b : boxes) {
    					if((mouseController.x > b.xPos && mouseController.x < (b.xPos+b.xSize)) &&
    							(mouseController.y > b.yPos && mouseController.y < (b.yPos+b.ySize))) {
        			
    						b.clicked = !b.clicked;
    						b.calculateVisibility();
    						if(b.equals(clickSteps.get(currentStep))) {
    							score++;
    							b.clicked = !b.clicked;
    							b.calculateVisibility();
            					currentStep++;
            					if(currentStep >= clickSteps.size()) {
            						cycleDone = true;
            						generateStep = true;
            					}
    						} else {
    							System.out.println("You lose");
    							loss = true;
    							return ;
    						}
    					}
    				}
    		}
    	}
	}
	
	public void calculateNewStep() {
		int choice = (int)(Math.random() * 4) + 1;
		switch(choice) {
			case 1:
				clickSteps.add(boxes.get(0));
				break;
			case 2:
				clickSteps.add(boxes.get(1));
				break;
			case 3:
				clickSteps.add(boxes.get(2));
				break;
			case 4:
				clickSteps.add(boxes.get(3));
				break;
		}
		generateStep = false;
	}
	
	public void showAnimationCycle() {
		clickSteps.get(index).clicked = true;
		clickSteps.get(index).calculateVisibility();
		
		try { Thread.sleep(25);	} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter++;
		if(counter > 5) {
			clickSteps.get(index).clicked = false;
			clickSteps.get(index).calculateVisibility();
			index++;
			counter = 0;
		}
		if(index > clickSteps.size()-1) {
			index = 0;
			counter = 0;
			cycleDone = false;
			isClickEnabled = true;
			currentStep = 0;
		}
	}
	
	public void showYouLoseButton(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 100);
		g.drawImage(youLoseButton.image, youLoseButton.xPos, youLoseButton.yPos, null);
	}
	
	
}
