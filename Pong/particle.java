package Pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class particle {
	
	public particle () {
	}
	
	public void contrail (Graphics2D win) {
		double xvelocity = PongRunner.xvelocity;
		double yvelocity = PongRunner.yvelocity;
		int xball = PongRunner.xball;
		int yball = PongRunner.yball;
		if (PongRunner.particle) {
			if (xvelocity > 0 && yvelocity <0) {
				win.setColor(Color.RED);
				win.drawRect(xball+38, yball+14, 4, 4);
				win.drawRect(xball+36, yball+16, 4, 4);
			} else if (xvelocity > 0 && yvelocity > 0) {
				win.setColor(Color.RED);
				win.drawRect(xball+40, yball-16, 4, 4);
				win.drawRect(xball+38, yball-18, 4, 4);
			} else if (xvelocity < 0 && yvelocity < 0) {
				win.setColor(Color.CYAN);
				win.drawRect(xball+70, yball+13, 4, 4);
				win.drawRect(xball+72, yball+15, 4, 4);
			} else {
				win.setColor(Color.CYAN);
				win.drawRect(xball+70, yball-15, 4, 4);
				win.drawRect(xball+72, yball-17, 4, 4);
			}
		}
	}
}
