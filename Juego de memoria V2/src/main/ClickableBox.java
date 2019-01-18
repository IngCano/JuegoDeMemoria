package main;

import java.awt.Color;

public class ClickableBox extends Clickable{
	
	public Color defaultColor;
	
	public ClickableBox() {
		xPos = 0;
		yPos = 0;
		xSize = 0;
		ySize = 0;
		clicked = false;
	}
	
	public ClickableBox(int x, int y) {
		xPos = 0;
		yPos = 0;
		xSize = x;
		ySize = y;
		clicked = false;
	}
	
	public ClickableBox(int x, int y, Color c) {
		xPos = 0;
		yPos = 0;
		xSize = x;
		ySize = y;
		this.defaultColor = c;
		clicked = false;
	}
	
	public ClickableBox(int xPos, int yPos, int xSize, int ySize, Color c) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.defaultColor = c;
		clicked = false;
	}
}
