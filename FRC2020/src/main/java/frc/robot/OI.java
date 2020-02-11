package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

public class OI {

	Joystick leftStick = RobotMap.leftJoystick;
	Joystick rightStick = RobotMap.rightJoystick;
	public XboxController xbox = RobotMap.xboxController;

	boolean grabberState = true;
	double shooterspeed = 10;
	//status of flap; false => closed, true => open
	boolean flapState = false; 

	Button leftbutton1 = new JoystickButton(leftStick, 1), leftbutton2 = new JoystickButton(leftStick, 2);
	Button leftbutton3 = new JoystickButton(leftStick, 3), leftbutton4 = new JoystickButton(leftStick, 4);
	Button leftbutton5 = new JoystickButton(leftStick, 5), leftbutton6 = new JoystickButton(leftStick, 6);
	Button rightbutton1 = new JoystickButton(rightStick, 1), rightbutton2 = new JoystickButton(rightStick, 2);
	Button rightbutton3 = new JoystickButton(rightStick, 3), rightbutton4 = new JoystickButton(rightStick, 4);
	Button rightbutton5 = new JoystickButton(rightStick, 5), rightbutton6 = new JoystickButton(rightStick, 6);

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

	public boolean grabberState() {
		if (grabberState == false) {
			grabberState = true;
			return true;
		} else {
			grabberState = false;
			return false;
		}
	}

	public boolean shoot() {
		return xbox.getAButton();
	}

	public boolean flap(){
		return xbox.getYButton();
	}

	public boolean cycle() {
		if (xbox.getXButton() == true) {
			return true;
		} else {
			return false;
		}
	}

	public int shootspeed() { 
		if (xbox.getPOV() == 1) {
			return 1;
		} if else (xbox.getPOV() == 2) {
			return 2 ;
		} else {
			return 0;
		}
	}

	/*
	 * public double shootSpeed() { if (xbox.getTriggerAxis() == ) }
	 */
}