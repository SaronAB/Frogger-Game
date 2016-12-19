package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Cars implements Drawable {
	private double posX;
	private double posY;
	private double width;
	private double height;
	private double velocity;
	private Color color;

	public Cars(double posX, double posY, double width, double height, double velocity,Color color) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.velocity = velocity;
		this.color = color;
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
		if (velocity > 0) {
			StdDraw.picture(posX, posY, "labs/lab10/carRight.jpg", width, height);
		}
		if (velocity < 0) {
			StdDraw.picture(posX, posY, "labs/lab10/carLeft.jpg", width, height);
		}
		//StdDraw.filledRectangle(posX, posY, width/2.0, length/2.0);
	}


	public void move(){
		posX = posX + this.velocity;

		if ((velocity > 0) && (posX - (this.getWidth()/2) > 1)){
			posX = 0;
		}

		if ((velocity < 0) && (posX + (this.getWidth()/2) < 0)){
			posX = 1;
		}
	}

	public void increaseVelocity() {
		this.velocity = velocity * 1.2;
	}

	public static void main(String[] args) {
		Cars lightningMcQueen = new Cars(0.1, 0.75, 0.13, 0.23, 0.01, Color.red);
		while (true){
			StdDraw.clear();
			lightningMcQueen.draw();
			lightningMcQueen.move();
			StdDraw.show(70);
		}

	}

}
