package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class LiliPads implements Drawable {

	private double posX;
	private double posY;
	private double width;
	private double height;
	private Color color;
	private boolean isActive;

	public LiliPads(double posX, double posY, double width, double height, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.color = color;
		this.isActive = true;
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

	public boolean isActive(){
		return isActive;
	}

	public void deactivation(){
		this.color = Color.black;
		this.isActive = false;
	}

	public void reactivate(){
		this.color = Color.magenta;
		this.isActive = true;
	}

	@Override

	public void draw() {

	if(isActive){

	StdDraw.picture(posX, posY, "labs/lab10/activeGoal.jpg");

	}

	else{

	StdDraw.setPenColor(Color.BLACK);

	StdDraw.filledRectangle(posX, posY, width/2.0, height/2.0);

	}

	}

		public static void main(String[] args) {
			LiliPads home1 = new LiliPads(0, 1, 0.1, 0.3, Color.magenta);
			while (true){
				StdDraw.clear();
				home1.draw();
				home1.isActive();
				StdDraw.show(40);
			}

		}

	}
