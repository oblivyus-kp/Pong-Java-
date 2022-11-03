package Pong;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import utilities.GDV5;

public class Paddle extends Rectangle{
	
	boolean KeysPressed[];

	public Paddle (int x, int y) {
		super (x,y,15,140);
	}
	
	public void p1Move() {
		if ( GDV5.KeysPressed[KeyEvent.VK_W]) {
			if (this.y>-50) {
				this.y -= 10;}
		} if ( GDV5.KeysPressed[KeyEvent.VK_S]) {
			if (this.y<750) {
				this.y += 10;}
		}
		this.y += 0;
	 }
	 
	 public void p2Move() {
		if (GDV5.KeysPressed[KeyEvent.VK_UP] ) {
			if (this.y>-50) {
				this.y -= 10;}
		} if (GDV5.KeysPressed[KeyEvent.VK_DOWN] ) {
			if (this.y<750) {
				this.y += 10;}
		}
		this.y += 0;
	}
	
	public void auto() {
		this.y = (int)(PongRunner.ball.getY()-70.0);
	}
	
	
}
