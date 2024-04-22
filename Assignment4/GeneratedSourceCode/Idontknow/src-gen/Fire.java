
	package sample;
	
	import robocode.Robot;
	import robocode.ScannedRobotEvent;
	import robocode.HitByBulletEvent;
	import robocode.HitRobotEvent;
	
	import java.awt.*;
	
	public class Fire extends Robot {
		public void run() {
			// "Set colors"
			setbodyColor(Color.red);
			setGunColor(Color.red);
			setRadarColor(Color.red);
			setScanColor(Color.red);
			setBulletColor(Color.red);
			
			while (true) {
				turnGunRight(5);
			}
		}
		
		public void onScannedRobot(ScannedRobotEvent e) {
			// "If the other robot is close by, and we have plenty of life, fire hard!"
			if (e.getDistance() < 50 && getEnergy() > 50) {
				fire(3);
			}
			// "Otherwise fire 1"
			if (e.getDistance() > 50 && getEnergy() < 50) {
				fire(1);
			}
			scan();
		}
		
		public void onHitByBullet(HitByBulletEvent e) {
			turnRight("90 - (getHeading() - e. getHeading())");
			ahead(dist);
			scan();
		}
		
		public void onHitRobot(HitRobotEvent e) {
			turnGunRight(turnGunAmt);
			fire(3);
		}
		

	}
