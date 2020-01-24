package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

public class Launcher extends Subsystem {
	OI oi;

	//Moves winch motor based on speed values from OI
	public void moveLauncher(double speed) {
		//get speed with OI input
		//oi.getLauncherSpeed()
	}

	public void stop() {
		RobotMap.Launcher.set(0.0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MoveElevator());
	}
}
