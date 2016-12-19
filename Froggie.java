package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Froggie implements Drawable, Movable{
	private double posX;
	private double posY;
	private double width;
	private double height;
	private Color color;
	private int lives;
	private int score;

	public Froggie(double posX, double posY, double width, double height, Color color, int lives){  //might not need to initialize lives/speed
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.color = color;
		this.lives = lives;
		this.score = 0;
	}

	public void resetPos(int player){
		if (player == 0){
			posX = 0.3;
			posY = 0.0;
			StdDraw.pause(20);
		}
		if (player == 1){
			posX = 0.7;
			posY = 0.0;
			StdDraw.pause(20);
		}
	}
	
	public void die1Player(){
		lives--;
		posX = 0.5;
		posY = 0.0;
		StdDraw.pause(20);
	}

	public void die2Player(int player){
		lives--;
		score--;
		if (player == 0) this.resetPos(0);
		if (player == 1) this.resetPos(1);
	}

	public boolean collide(Drawable object){
		//
		//has the frog collided or not???
		//check boundaries of frog and object and see of they collide
		//approach from all corners and see of the two objects overlap or not
		//		
		double X1 = this.getPosX();
		double X2 = object.getPosX();
		double Y1 = this.getPosY();
		double Y2 = object.getPosY();

		if (((Y1 + (this.getHeight()/2) > Y2 - (object.getHeight()/2)) && 
				
				(Y1 + (this.getHeight()/2) < Y2 + (object.getHeight()/2))) && 
				
					((X1 + (this.getWidth()/2) > X2 - (object.getWidth()/2) && 
							
							(X1 + (this.getWidth()/2) < X2 + (object.getWidth()/2))))){
			return true;
		}

		if (((Y1 + (this.getHeight()/2) > Y2 - (object.getHeight()/2)) && 
				
				(Y1 + (this.getHeight()/2) < Y2 + (object.getHeight()/2))) && 
				
					((X1 - (this.getWidth()/2) < X2 + (object.getWidth()/2) && 
							
							(X1 - (this.getWidth()/2) > X2 - (object.getWidth()/2))))){
			return true;
		}

		if (((Y1 - (this.getHeight()/2) < Y2 + (object.getHeight()/2)) && 
				
				(Y1 - (this.getHeight()/2) > Y2 - (object.getHeight()/2))) && 
				
					((X1 + (this.getWidth()/2) > X2 - (object.getWidth()/2) && 
							
							(X1 + (this.getWidth()/2) < X2 + (object.getWidth()/2))))){
			return true;
		}

		if (((Y1 - (this.getHeight()/2) < Y2 + (object.getHeight()/2)) && 
				
				(Y1 - (this.getHeight()/2) > Y2 - (object.getHeight()/2))) && 
				
					((X1 - (this.getWidth()/2) < X2 + (object.getWidth()/2) && 
						
						(X1 - (this.getWidth()/2) > X2 - (object.getWidth()/2))))){
			return true;
		}

		else{
			return false;
		}
	}

	public void bounceBack(int player, Froggie otherplayer){

		if(this.collide(otherplayer)){

			double X1 = this.getPosX();

			double X2 = otherplayer.getPosX();

			double Y1 = this.getPosY();

			double Y2 = otherplayer.getPosY();

			if (((Y1 + (this.getHeight()/2) > Y2 - (otherplayer.getHeight()/2)) && 
					
					(Y1 + (this.getHeight()/2) < Y2 + (otherplayer.getHeight()/2))) && 
					
						((X1 + (this.getWidth()/2) > X2 - (otherplayer.getWidth()/2) && 
							
							(X1 + (this.getWidth()/2) < X2 + (otherplayer.getWidth()/2)))) && 
							
								(posY - (this.getHeight()/2) > 0) && (posX - (this.getWidth()/2) > 0)){

				posY = posY - 0.03;

				posX = posX - 0.03;

			}

			if (((Y1 + (this.getHeight()/2) > Y2 - (otherplayer.getHeight()/2)) && 
					
					(Y1 + (this.getHeight()/2) < Y2 + (otherplayer.getHeight()/2))) && 
					
						((X1 - (this.getWidth()/2) < X2 + (otherplayer.getWidth()/2) && 
							
								(X1 - (this.getWidth()/2) > X2 - (otherplayer.getWidth()/2)))) && 
									
									(posY - (this.getHeight()/2) > 0) && (posX + (this.getWidth()/2) < 1)){

				posY = posY - 0.03;

				posX = posX + 0.03;

			}

			if (((Y1 - (this.getHeight()/2) < Y2 + (otherplayer.getHeight()/2)) && (Y1 -

					(this.getHeight()/2) > Y2 - (otherplayer.getHeight()/2))) && ((X1 +

							(this.getWidth()/2) > X2 - (otherplayer.getWidth()/2) && (X1 +

									(this.getWidth()/2) < X2 + (otherplayer.getWidth()/2)))) &&

									(posY + (this.getHeight()/2) < 1) && (posX - (this.getWidth()/2) > 0)){

				posY = posY + 0.03;

				posX = posX - 0.03;

			}

			if (((Y1 - (this.getHeight()/2) < Y2 + (otherplayer.getHeight()/2)) && (Y1 -

					(this.getHeight()/2) > Y2 - (otherplayer.getHeight()/2))) && ((X1 -

							(this.getWidth()/2) < X2 + (otherplayer.getWidth()/2) && (X1 -

									(this.getWidth()/2) > X2 - (otherplayer.getWidth()/2)))) &&

									(posY + (this.getHeight()/2) < 1) && (posX + (this.getWidth()/2) < 1)){

				posY = posY + 0.03;

				posX = posX + 0.03;

			}

		}

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

	public int getLives() {
		return lives;
	}

	public void increaseScore() {
		score++;
	}

	public int getScore(){
		return score;
	}


	@Override
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.picture(posX, posY, "labs/lab10/Frogpixel1.jpg", width, height);
		//StdDraw.filledRectangle(posX, posY, width/2.0, length/2.0);
	}
	
	public void draw2() {
		StdDraw.setPenColor(color);
		StdDraw.picture(posX, posY, "labs/lab10/Frogpixel2.jpg", width, height);
		//StdDraw.filledRectangle(posX, posY, width/2.0, length/2.0);
	}

	public void drawScore(int player) {

		StdDraw.setPenColor(color);

		if (player == 0)

			StdDraw.text(0.05, 0.05, "P1 Score: " + score);

		else

			StdDraw.text(0.05, 0.01, "P2 Score: " + score);

	}

	public void drawLives(int player) {

		StdDraw.setPenColor(color);

		if (player == 0)

			StdDraw.text(0.95, 0.05, "P1 Lives: " + lives);

		else

			StdDraw.text(0.95, 0.01, "P2 Lives: " + lives);

	}

	@Override
	public void move(int player) { 
		//
		//update posX and posY depending on speed if isKeyPressed is true
		//
		if (player == 0){
			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_UP) == true) && (posY + (this.getHeight()/2) < 1)){
				posY = posY + 0.03; 
			}

			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_DOWN) == true) && (posY - (this.getHeight()/2) > 0)) {
				posY = posY - 0.03; 
			}

			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_LEFT) == true) && (posX - (this.getWidth()/2) > 0)){
				posX = posX - 0.03; 
			}

			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_RIGHT) == true) && (posX + (this.getWidth()/2) < 1)){
				posX = posX + 0.03; 
			}
		}

		if (player == 1){
			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_UP) == true) && (posY + (this.getHeight()/2) < 1)){
				posY = posY + 0.03;
			}

			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_DOWN) == true) && (posY - (this.getHeight()/2) > 0)){
				posY = posY - 0.03;
			}

			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_LEFT) == true) && (posX - (this.getWidth()/2) > 0)) {
				posX = posX - 0.03;
			}

			if ((ArcadeKeys.isKeyPressed(player, ArcadeKeys.KEY_RIGHT) == true) && (posX + (this.getWidth()/2) < 1)) {
				posX = posX + 0.03; 
			}
		}

	}

	public static void main(String[] args) {
		Froggie jimmy = new Froggie(0.5, 0.5, 0.1, 0.1, Color.GREEN, 7);
		while (true){
			StdDraw.clear();
			jimmy.draw();
			jimmy.move(0);
			StdDraw.show(40);
		}

	}
}

