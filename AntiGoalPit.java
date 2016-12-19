package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class AntiGoalPit implements Drawable {
	private double posX;
	private double posY;
	private double width;
	private double height;
	private Color color;
	
	public AntiGoalPit(double posX, double posY, double width, double height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.color = Color.BLACK;
	}

	@Override
	public double getPosX() {
		return posX;
	}

	@Override
	public double getPosY() {
		return posY;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(posX, posY, width, height);
	}
	
	public static void main(String[] args) {
		AntiGoalPit abc = new AntiGoalPit(.5, 1, 1, .05);
		abc.draw();
	}

}
