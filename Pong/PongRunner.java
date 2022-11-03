package Pong;
import java.awt.Color;
import java.awt.Graphics2D;

import utilities.GDV5;

public class PongRunner extends GDV5{
	
	static Ball ball = new Ball(20);
	static int xball = (int)ball.getX();
	static int yball = (int)ball.getY();
	static Paddle paddle1 = new Paddle(10,350);
	static Paddle paddle2 = new Paddle(1175,350);
	static double yvelocity = 4;
	static double xvelocity = -4;
	static int score1 = 0;
	static int score2 = 0;
	static int display = 2;
	static int color = 1;
	static boolean particle = false;
	static int winscore= 5;
	static int colorCount = 0;
	int game = 0;
	particle Contrail = new particle();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PongRunner p1 = new PongRunner();
		p1.start();
	}
	
	@Override
	public void update() {  //refreshes at 60 fps
		ball.checkStart();
		if (display ==1 || display == 3) ball.move(xvelocity,yvelocity);
		if (display ==1) paddle1.p1Move();
		if (display ==3) paddle1.auto();
		paddle2.p2Move();
		ball.checkWin();
		ball.Bounce();
		if (ball.getX()+ball.getWidth()>=1185 || ball.getX()<=12.0) ball.origin();
	}

	@Override
	public void draw(Graphics2D win) {//refresh at the processor speed ~3000fps
		if (display ==1 || display==3) { //main game
			if (color==1) {
				win.setColor(Color.WHITE);
				win.draw(ball);
				win.fill(ball);
			} if (color==2) {
				win.setColor(Color.CYAN);
				win.draw(ball);
				win.fill(ball);
			} if (color==3) {
				win.setColor(Color.MAGENTA);
				win.draw(ball);
				win.fill(ball);
			} if (color==4) {
				win.setColor(Color.RED);
				win.draw(ball);
				win.fill(ball);
			} if (color==5) {
				win.setColor(Color.ORANGE);
				win.draw(ball);
				win.fill(ball);
			} if (color==6) {
				win.setColor(Color.GREEN);
				win.draw(ball);
				win.fill(ball);
			} if (color==7) {
				win.setColor(Color.PINK);
				win.draw(ball);
				win.fill(ball);
			}
			win.setColor(Color.cyan);
			win.draw(paddle2);
			win.fill(paddle2);
			win.setColor(Color.red);
			win.draw(paddle1);
			win.fill(paddle1);
			win.setFont(win.getFont().deriveFont(32.0f));
			win.setColor(Color.white);
			//scoreboard
			win.drawString(score1 + "  " + score2, 573, 70);
			win.drawRect(598, -10, 4, 820);
			Contrail.contrail(win);
		}
		if (score1==winscore) { //win screen
			win.setColor(Color.red);
			win.setFont(win.getFont().deriveFont(48.0f));
			win.drawString("Player 1 Wins!", 460, 300);
			win.setColor(Color.white);
			win.setFont(win.getFont().deriveFont(32.0f));
			win.drawString("Press 1 to Go to Home Screen", 390, 420);
			win.drawString("Press Enter to Play Again", 425, 500);
			xvelocity=0;
			yvelocity=0;
			display= 0;
		} if (score2==winscore) { //win screen
			win.setColor(Color.cyan);
			win.setFont(win.getFont().deriveFont(48.0f));
			win.drawString("Player 2 Wins!", 460, 300);
			win.setColor(Color.white);
			win.setFont(win.getFont().deriveFont(32.0f));
			win.drawString("Press 1 to Go to Home Screen", 390, 420);
			win.drawString("Press Enter to Play Again", 425, 500);
			xvelocity=0;
			yvelocity=0;
			display = 0;
		} if (display == 2) { //start screen
			win.setFont(win.getFont().deriveFont(80f));
			colorChange(win);
			win.drawString("P", 490, 150);
			win.drawString("O", 535, 150);
			win.drawString("N", 585, 150);
			win.drawString("G", 630, 150);
			win.setFont(win.getFont().deriveFont(32.0f));
			win.setColor(Color.white);
			win.drawString("By Kenny Pham", 475, 200);
			win.setColor(Color.red);
			win.drawString("<-- Player 1 use W and S to move paddle", 295, 380);
			win.setColor(Color.cyan);
			win.drawString("Player 2 use UP and DOWN arrows -->", 345, 450);
			win.setColor(Color.white);
			win.setFont(win.getFont().deriveFont(44.0f));
			colorChange(win);
			win.drawRect(525, 580, 133, 50);
			win.setColor(Color.white);
			win.drawString("Press Space to Start", 405, 620);
			colorChange(win);
			win.drawRect(490, 680, 35, 50);
			win.setColor(Color.white);
			win.drawString("Press 2 for Single Player", 370, 720);
		}
		
		if (score1==4 || score2==4) {
				game++;
				if (game<=250 && game>=100) {
				win.setColor(Color.red);
				win.setFont(win.getFont().deriveFont(44.0f));
				win.drawString("GAME POINT", 464, 150);
				} if (game>250) {
					game = 0;
				}
		}
	}
	
	public void colorChange(Graphics2D magic) {
		colorCount++;
		if (colorCount <= 30) {
			magic.setColor(Color.PINK);
		} else if (colorCount <= 50) {
			magic.setColor(Color.orange);
		} else if (colorCount <= 100) {
			magic.setColor(Color.yellow);
		} else if (colorCount <= 150) {
			magic.setColor(Color.green);
		} else if (colorCount <= 200) {
			magic.setColor(Color.blue);
		} else if (colorCount <= 250) {
			magic.setColor(Color.MAGENTA);
		} else {
			colorCount = 0;
		}
		
		
	}

}
