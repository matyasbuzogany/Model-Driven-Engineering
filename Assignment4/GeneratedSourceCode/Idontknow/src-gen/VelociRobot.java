
package sample;

import robocode.RangeControlRobot;
import robocode.ScannedRobotEvent;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;

import java.awt.*;

public class VelociRobot extends RangeControlRobot {
	public void run() {
		setGunRotationRate(15);
		
		while (true) {
			// "Straighten out, if we were hit by a bullet and are turning"
			if (turnCounter%64 == 0) {
				setTurnRate(0);
			}
			// "Go forward, velocity of 4"
			if (turnCounter%64 == 0) {
				setVelocityRate(4);
			}
			// "Go backwards, faster"
			if (turnCounter%64 == 32) {
				setVelocityRate(-6);
			}
			execute();
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		setTurnRate(4);
	}
	
	public void onHitWall(HitWallEvent e) {
		setVelocityRate("-1 * getVelocityRate()");
	}
	
}
