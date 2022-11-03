package Pong;
import java.awt.event.KeyEvent;

import utilities.GDV5;

import java.awt.Rectangle;

public class Ball extends Rectangle{
	
	int timecount = 120;
	boolean KeysPressed[];
	int xv = -4;
	int yv = 4;
	
	public Ball (int length) {
		super(540,400, length, length);
	}
	
	public void move(double xvelocity, double yvelocity) {
		if (timecount>=120) {
			this.x += xvelocity;
			this.y += yvelocity;
			PongRunner.particle = true;
			PongRunner.xball+=xvelocity;
			PongRunner.yball+=yvelocity;
		} else {
			timecount++;
		} if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
			PongRunner.display = 2;
			PongRunner.score1 = 0;
			PongRunner.score2 = 0;
			PongRunner.xvelocity = -4;
			PongRunner.yvelocity = 4;
		}
	}
	
	
	public void origin() {
		//update score
		//reset velocities
		if (this.x<=12.0) {
			PongRunner.score2 ++;
			PongRunner.xvelocity = -xv;
		} if (this.x+PongRunner.ball.getWidth()>=1185.0) {
			PongRunner.score1 ++;
			PongRunner.xvelocity = xv;
		}
		if (PongRunner.yvelocity <0) PongRunner.yvelocity = -4;
		if (PongRunner.yvelocity >0) PongRunner.yvelocity = 4;
		//center the ball @ origin
		this.x = 590;
		this.y = 390;
		//reset particles
		PongRunner.xball = 540;
		PongRunner.yball = 400;
		if (PongRunner.score2 == 0 && PongRunner.score1==0) {
			PongRunner.paddle1.y=350;
			PongRunner.paddle2.y=350;
		}
		PongRunner.particle = false;
		//reset timer
		timecount = 0;
		PongRunner.color = 1;
	}
	
	public void speedUp() {
		if(PongRunner.xvelocity<0) {
			PongRunner.xvelocity -= .75;
		}if(PongRunner.xvelocity>0) {
			PongRunner.xvelocity += .75;
		}if(PongRunner.yvelocity<0) {
			PongRunner.yvelocity -= .75;
		}if(PongRunner.yvelocity>0) {
			PongRunner.yvelocity += .75;
		}
	}
	
	public void Bounce() {
		//check for bounce on paddle
		if (PongRunner.ball.intersects(PongRunner.paddle1) || PongRunner.ball.intersects(PongRunner.paddle2)) { 
			PongRunner.xvelocity= -PongRunner.xvelocity;
			PongRunner.color = (int)(Math.random() * 7) + 1;
			speedUp();
		} else if ((PongRunner.ball.getY()<= 0.0 || PongRunner.ball.getY()+20>=800.0)) { 
			PongRunner.yvelocity = -PongRunner.yvelocity;
		} 
	}
	public void checkStart() {
		if(PongRunner.display==2) {
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				PongRunner.display = 1;
				origin();
			} if (GDV5.KeysPressed[KeyEvent.VK_2]) {
				PongRunner.display = 3;
				origin();
			}
		}
	}
	public void checkWin() {
		if (PongRunner.score1==PongRunner.winscore || PongRunner.score2==PongRunner.winscore) {
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
				PongRunner.score1 = 0;
				PongRunner.score2 = 0;
				PongRunner.xvelocity = -4;
				PongRunner.yvelocity = 4;
				PongRunner.display = 1;
				origin();
			} if (GDV5.KeysPressed[KeyEvent.VK_1]) {
				PongRunner.score1 = 0;
				PongRunner.score2 = 0;
				PongRunner.xvelocity = -4;
				PongRunner.yvelocity = 4;
				PongRunner.display = 2;
			}
		}
	}
	
}
	
