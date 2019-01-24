package main;

import java.awt.image.BufferedImage;

public class ClickableBoxImage extends Clickable{

	public BufferedImage image;
	
	public ClickableBoxImage() {
		xPos = 0;
		yPos = 0;
		clicked = false;
		image = null;
	}
	
	public ClickableBoxImage(BufferedImage img) {
		xPos = 0;
		yPos = 0;
		clicked = false;
		image = img;
	}
	
}
