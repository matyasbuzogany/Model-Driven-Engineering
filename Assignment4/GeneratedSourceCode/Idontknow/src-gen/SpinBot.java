
	package sample;
	
	import robocode.AdvancedRobot;
	import robocode.ScannedRobotEvent;
	import robocode.HitRobotEvent;
	
	import java.awt.*;
	
	public class SpinBot extends AdvancedRobot {
		public void run() {
			// "Set color"
			setbodyColor(Color.blue);
			setgunColor(Color.blue);
			setradarColor(Color.black);
			setscanColor(Color.yellow);
			
			while (true) {
				// "Tell the game that when we take move, we'll also want to turn right... a lot."
				setturnRight(10000);
				// "Limit our speed to 5"
				setmaxVelocity(5);
				// "Start moving (and turning)"
				ahead(10000);
			}
		}
		
		public void onScannedRobot(ScannedRobotEvent e) {
			// "onScannedRobot: Fire hard!"
			fire(3);
		}
		
		public void onHitRobot(HitRobotEvent e) {
			// "onHitRobot:  If it's our fault, we'll stop turning and moving, so we need to turn again to keep spinning."
			if (e.getBearing() > -10 && e.getBearing() < 10) {
				fire(3);
			}
			if (e.isMyFault()  ) {
				turnRight(10);
			}
		}
		
	}
