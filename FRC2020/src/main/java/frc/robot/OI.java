/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

//Sets controls. Will update once mechanisms are testable

public class OI {

	boolean grabberState = true;
	Joystick leftStick = RobotMap.leftJoystick;
	Joystick rightStick = RobotMap.rightJoystick;
	XboxController xbox = RobotMap.xboxController;

	Button leftBumper = new JoystickButton(xbox, 5);
	Button rightBumper = new JoystickButton(xbox, 6);


	//Gets position inputs from the xbox sticks
	public double getCollectorSpeed() {
		if (xbox.getRawAxis(5) > 0.1 || xbox.getRawAxis(5) < -0.1) {
			return xbox.getRawAxis(5);
		} else {
			return 0.0;
		}
	}

	public double getLauncherSpeed() {
		if (xbox.getRawAxis(1) > 0.1 || xbox.getRawAxis(1) < -0.1) {
			return xbox.getRawAxis(1);
		} else {
			return 0.0;
		}
	}

	//Sticks for drive motors
	public double getLeftSpeed() {
		if (leftStick.getY() > 0.1 || leftStick.getY() < -0.1) {
			return leftStick.getY();
		} else {
			return 0.0;
		}
	}

	public double getRightSpeed() {
		if (rightStick.getY() > 0.1 || rightStick.getY() < -0.1) {
			return -1.0 * rightStick.getY();
		} else {
			return 0.0;
		}
	}
}
