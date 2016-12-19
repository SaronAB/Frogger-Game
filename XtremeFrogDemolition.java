package lab10;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sedgewick.StdDraw;

public class XtremeFrogDemolition implements FroggerGame{
	private Froggie shook;
	private Froggie lu;
	private Cars lightningMcQueen;
	private Cars mater;
	private Cars hudson;
	private LiliPads goals1;
	private LiliPads goals2;
	private LiliPads goals3;
	private LiliPads goals4;
	private AntiGoalPit pit;

	public XtremeFrogDemolition() {
		super();
		this.shook = new Froggie(0.3, 0.1, 0.1, 0.1, Color.GREEN, 9);
		this.lu = new Froggie(0.8, 0.1, 0.1, 0.1, Color.PINK, 9);
		this.lightningMcQueen = new Cars(0.1, 0.75, 0.25, 0.12, 0.01, Color.red);
		this.mater = new Cars (0.7, 0.30, 0.25, 0.12, 0.01, Color.orange);
		this.hudson = new Cars(0.2, 0.51, 0.25, 0.12,-0.01, Color.blue);
		this.goals1 = new LiliPads(0.125, 1, 0.1, 0.1, Color.magenta);
		this.goals2 = new LiliPads(0.375, 1, 0.1, 0.1, Color.magenta);
		this.goals3 = new LiliPads(0.625, 1, 0.1, 0.1, Color.magenta);
		this.goals4 = new LiliPads(0.875, 1, 0.1, 0.1, Color.magenta);
		this.pit = new AntiGoalPit(0.5, 1, 1, 0.05);
	}
	public void onePlayer(int player){
		while(shook.getLives() > 0){
			StdDraw.clear();
			if (shook.collide(lightningMcQueen) || shook.collide(mater) ||
					shook.collide(hudson) || shook.collide(pit)){
				shook.die1Player();
			}
			if ((shook.collide(goals1)) && (goals1.isActive())){
				shook.increaseScore();
				goals1.deactivation();
				shook.resetPos(0);
			}
			if ((shook.collide(goals2)) && (goals2.isActive())) {
				shook.increaseScore();
				goals2.deactivation();
				shook.resetPos(0);
			}
			if ((shook.collide(goals3)) && (goals3.isActive())) {
				shook.increaseScore();
				goals3.deactivation();
				shook.resetPos(0);
			}
			if ((shook.collide(goals4)) && (goals4.isActive())) {
				shook.increaseScore();
				goals4.deactivation();
				shook.resetPos(0);
			}
			//reactivate goals if all met, increase speed by one level
			if (!goals1.isActive() && !goals2.isActive() && !goals3.isActive() &&
					!goals4.isActive()){
				goals1.reactivate();
				goals2.reactivate();
				goals3.reactivate();
				goals4.reactivate();
				lightningMcQueen.increaseVelocity();
				mater.increaseVelocity();
				hudson.increaseVelocity();
				//
				//add a screen saying "next level"
				//
			}
			shook.draw();
			shook.move(player);
			lightningMcQueen.draw();
			lightningMcQueen.move();
			mater.draw();
			mater.move();
			hudson.draw();
			hudson.move();
			pit.draw();
			goals1.draw();
			goals2.draw();
			goals3.draw();
			goals4.draw();
			shook.drawScore(0);
			shook.drawLives(0);
			StdDraw.show(40);
		}
	}
	public void twoPlayer(int player1, int player2){
		int counter = 0;
		while(shook.getLives() > 0 && lu.getLives() > 0 && counter < 10){
			StdDraw.clear();
			//
			//first shook die/goal codes
			//
			if (shook.collide(lightningMcQueen) || shook.collide(mater) ||
					shook.collide(hudson) || shook.collide(pit)){
				shook.die2Player(0);
			}
			if ((shook.collide(goals1)) && (goals1.isActive())){
				shook.increaseScore();
				goals1.deactivation();
				shook.resetPos(0);
			}
			if ((shook.collide(goals2)) && (goals2.isActive())) {
				shook.increaseScore();
				goals2.deactivation();
				shook.resetPos(0);
			}
			if ((shook.collide(goals3)) && (goals3.isActive())) {
				shook.increaseScore();
				goals3.deactivation();
				shook.resetPos(0);
			}
			if ((shook.collide(goals4)) && (goals4.isActive())) {
				shook.increaseScore();
				goals4.deactivation();
				shook.resetPos(0);
			}
			//now for lu die/goal codes
			if (lu.collide(lightningMcQueen) || lu.collide(mater) ||
					lu.collide(hudson) || lu.collide(pit)){
				lu.die2Player(1);
			}
			if ((lu.collide(goals1)) && (goals1.isActive())){
				lu.increaseScore();
				goals1.deactivation();
				lu.resetPos(1);
			}
			if ((lu.collide(goals2)) && (goals2.isActive())) {
				lu.increaseScore();
				goals2.deactivation();
				lu.resetPos(1);
			}
			if ((lu.collide(goals3)) && (goals3.isActive())) {
				lu.increaseScore();
				goals3.deactivation();
				lu.resetPos(1);
			}
			if ((lu.collide(goals4)) && (goals4.isActive())) {
				lu.increaseScore();
				goals4.deactivation();
				lu.resetPos(1);
			}
			if (!goals1.isActive() && !goals2.isActive() && !goals3.isActive() &&
					!goals4.isActive()){
				goals1.reactivate();
				goals2.reactivate();
				goals3.reactivate();
				goals4.reactivate();
				lightningMcQueen.increaseVelocity();
				mater.increaseVelocity();
				hudson.increaseVelocity();
				shook.resetPos(0);
				lu.resetPos(1);
				counter++;
			}
			shook.draw();
			shook.bounceBack(player1, lu);
			shook.move(player1);
			lu.draw2();
			lu.bounceBack(player2, shook);
			lu.move(player2);
			lightningMcQueen.draw();
			lightningMcQueen.move();
			mater.draw();
			mater.move();
			hudson.draw();
			hudson.move();
			pit.draw();
			goals1.draw();
			goals2.draw();
			goals3.draw();
			goals4.draw();
			shook.drawScore(player1);
			shook.drawLives(player1);
			lu.drawScore(player2);
			lu.drawLives(player2);
			StdDraw.show(40);
		}
	}

	@Override
	public void playGame() {
		boolean flag = true;
		boolean a = true;
		while (flag){
			//frame 1
			StdDraw.clear();
			StdDraw.setPenColor(Color.magenta);
			StdDraw.text(0.5, 0.60, "ONE PLAYER (Press A)");
			StdDraw.text(0.5, 0.45, "TWO PLAYERS (Press D)");
			StdDraw.text(0.5, 0.30, "INSTRUCTIONS (Press S)");
			StdDraw.setPenRadius(10);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(0.5, 0.72, "X-TREME FROG DEMOLITION");
			StdDraw.picture(0.1, 0.7, "labs/lab10/bouncyFrog1 frame 1.jpg");
			StdDraw.picture(0.9, 0.7, "labs/lab10/bouncyFrog2 frame 1.jpg");
			StdDraw.show(50);
			StdDraw.pause(100);
			//frame 2
			StdDraw.clear();
			StdDraw.setPenColor(Color.magenta);
			StdDraw.text(0.5, 0.60, "ONE PLAYER (Press A)");
			StdDraw.text(0.5, 0.45, "TWO PLAYERS (Press D)");
			StdDraw.text(0.5, 0.30, "INSTRUCTIONS (Press S)");
			StdDraw.setPenRadius(10);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.text(0.5, 0.72, "X-TREME FROG DEMOLITION");
			StdDraw.picture(0.1, 0.7, "labs/lab10/bouncyFrog1 frame 2.jpg");
			StdDraw.picture(0.9, 0.7, "labs/lab10/bouncyFrog2 frame 2.jpg");
			StdDraw.show(50);
			StdDraw.pause(100);
			if ((ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT))) {
				flag = false;
				boolean flag1 = true;
				while(flag1){
					StdDraw.clear();
					StdDraw.setPenRadius(10);
					StdDraw.setPenColor(Color.magenta);
					StdDraw.text(0.5, 0.5, "START GAME (Press W)");
					StdDraw.show(50);
					StdDraw.pause(100);
					a = false;
					if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
						flag1 = false;
					}
				}
			}
			if  (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)) {
				flag = false;
				boolean flag2 = true;
				while(flag2){
					StdDraw.clear();
					StdDraw.setPenColor(Color.magenta);
					StdDraw.text(0.5, 0.5, "START GAME (Press W)");
					StdDraw.show(50);
					StdDraw.pause(100);
					a = true;
					if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
						flag2 = false;
					}
				}
			}
			if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN)) {
				boolean flag3 = true;
				while(flag3){
					//let's have more bouncy frogs b/c why not. frame 1:
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.text(0.5, 0.9, "Avoid cars and pits. Reach as many lilypads as you can!");
					StdDraw.setPenColor(Color.GREEN);
					StdDraw.text(0.2, 0.8, "P1 CONTROLS");
					StdDraw.text(0.2, 0.75, "UP - W");
					StdDraw.text(0.2, 0.7, "LEFT - A");
					StdDraw.text(0.2, 0.65, "RIGHT - D");
					StdDraw.text(0.2, 0.6, "DOWN - S");
					StdDraw.setPenColor(Color.magenta);
					StdDraw.text(0.8, 0.8, "P2 CONTROLS");
					StdDraw.text(0.8, 0.75, "UP - UP ARROW");
					StdDraw.text(0.8, 0.7, "LEFT - LEFT ARROW");
					StdDraw.text(0.8, 0.65, "RIGHT - RIGHT ARROW");
					StdDraw.text(0.8, 0.6, "DOWN - DOWN ARROW");
					StdDraw.picture(0.2, 0.4, "labs/lab10/bouncyFrog1 frame 1.jpg");
					StdDraw.picture(0.8, 0.4, "labs/lab10/bouncyFrog2 frame 1.jpg");
					StdDraw.text(0.5, 0.2, "GO BACK (Press S)");
					StdDraw.show(50);
					StdDraw.pause(100);
					//frame 2
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.text(0.5, 0.9, "Avoid cars and pits. Reach as many lilypads as you can!");
					StdDraw.setPenColor(Color.GREEN);
					StdDraw.text(0.2, 0.8, "P1 CONTROLS");
					StdDraw.text(0.2, 0.75, "UP - W");
					StdDraw.text(0.2, 0.7, "LEFT - A");
					StdDraw.text(0.2, 0.65, "RIGHT - D");
					StdDraw.text(0.2, 0.6, "DOWN - S");
					StdDraw.setPenColor(Color.magenta);
					StdDraw.text(0.8, 0.8, "P2 CONTROLS");
					StdDraw.text(0.8, 0.75, "UP - UP ARROW");
					StdDraw.text(0.8, 0.7, "LEFT - LEFT ARROW");
					StdDraw.text(0.8, 0.65, "RIGHT - RIGHT ARROW");
					StdDraw.text(0.8, 0.6, "DOWN - DOWN ARROW");
					StdDraw.picture(0.2, 0.4, "labs/lab10/bouncyFrog1 frame 2.jpg");
					StdDraw.picture(0.8, 0.4, "labs/lab10/bouncyFrog2 frame 2.jpg");
					StdDraw.text(0.5, 0.2, "GO BACK (Press S)");
					StdDraw.show(50);
					StdDraw.pause(100);
					a = true;
					if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN)) {
						flag3 = false;
					}
				}
			}
		}

		if (a == false){
			this.onePlayer(0);
			boolean tryagain = true;
			while(tryagain){
				//frame 1
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.3, "GAME OVER!");
				StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
				StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press W) OR QUIT? (Press S)");
				StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 1.jpg");
				StdDraw.show(70);
				//frame 2
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.3, "GAME OVER!");
				StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
				StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press W) OR QUIT? (Press S)");
				StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 2.jpg");
				StdDraw.show(70);
				//frame 3
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.3, "GAME OVER!");
				StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
				StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press W) OR QUIT? (Press S)");
				StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 3.jpg");
				StdDraw.show(70);
				//back to frame 2
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.3, "GAME OVER!");
				StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
				StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press W) OR QUIT? (Press S)");
				StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 2.jpg");
				StdDraw.show(70);
				if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
					tryagain = false;
				}
				else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN)){
					System.exit(0);
				}
			}
		}
		else {
			//
			//once game is over, you need to restart it
			//
			this.twoPlayer(0, 1);
			boolean tryagain = true;
			while(tryagain){
				StdDraw.clear();
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
				StdDraw.setPenColor(Color.WHITE);
				if (shook.getScore() > lu.getScore()) {
					//frame 1
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER1 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP2 frame 1.jpg");
					StdDraw.show(70);
					//frame 2
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER1 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP2 frame 2.jpg");
					StdDraw.show(70);
					//frame 3
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER1 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP2 frame 3.jpg");
					StdDraw.show(70);
					//back to frame 2
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER1 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + shook.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP2 frame 2.jpg");
					StdDraw.show(70);
				}
				else if (lu.getScore() > shook.getScore()) {
					//frame 1
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER2 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + lu.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 1.jpg");
					StdDraw.show(70);
					//frame 2
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER2 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + lu.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 2.jpg");
					StdDraw.show(70);
					//frame 3
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER2 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + lu.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 3.jpg");
					StdDraw.show(70);
					//back to frame 2
					StdDraw.clear();
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
					StdDraw.setPenColor(Color.WHITE);
					StdDraw.text(0.5, 0.3, "PLAYER2 WINS!");
					StdDraw.text(0.5, 0.2, "FINAL SCORE: " + lu.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
					StdDraw.picture(0.5, 0.6, "labs/lab10/FroggydeathP1 frame 2.jpg");
					StdDraw.show(70);

				}
				else{
					StdDraw.text(0.5, 0.5, "PLAYERS TIE!!!");
					StdDraw.text(0.5, 0.3, "FINAL SCORE: " + shook.getScore());
					StdDraw.text(0.5, 0.1, "PLAY AGAIN? (Press UP/W) OR QUIT? (Press DOWN/S)");
				}
				StdDraw.show(40);
				if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP) || ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_UP)) {
					tryagain = false;
				}
				else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN) || ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_DOWN)){
					System.exit(0);
				}
			}
		}
		this.newGame();
	}

	public void newGame() {
		FroggerGame restart = new XtremeFrogDemolition();
		restart.playGame();
	}


	@Override
	public String getGameName() {
		return "Xtreme Frog Demolition";
	}

	@Override
	public String[] getTeamMembers() {
		String[] members = { "Scoobie", "Shaggy" };
		return members;
	}

}