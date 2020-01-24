/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.MoveLauncher;
import frc.robot.commands.MoveCollector;
import frc.robot.commands.autonomous;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Launcher;

public class Robot extends TimedRobot {
	XboxController xbox = RobotMap.xboxController;
	Joystick leftstick = RobotMap.leftJoystick;
	Joystick rightstick = RobotMap.rightJoystick;
	public static DriveTrain driveTrain;
	public static Collector collector;
	public static Launcher launcher;
	public static OI m_oi;
	boolean Xon = false;
	boolean toggle = false;
	boolean GreenLED_ON = false;

	@Override
	public void robotInit() {

		//CameraServer.getInstance().startAutomaticCapture();
		driveTrain = new DriveTrain();
		collector = new Collector();
		launcher = new Launcher();
		m_oi = new OI();
		GreenLED_ON = false;
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
		// Init OI
		OICommands();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {

		// Left trigger pressed, end OI commands and start tape script
		if (leftstick.getTriggerPressed() && toggle == false) {
			Scheduler.getInstance().removeAll();
			Scheduler.getInstance().add(new autonomous(1));
			toggle = true;
		}

		// Right trigger pressed, end OI commands and start ball script
		if (rightstick.getTriggerPressed() && toggle == false) {
			Scheduler.getInstance().removeAll();
			Scheduler.getInstance().add(new autonomous(2));
			toggle = true;
		}

		// Both triggers released, end autonomous scripts and start OI scripts
		if (leftstick.getTriggerReleased() && rightstick.getTriggerReleased() && toggle) {
			DriverStation.reportError("TRIGGER", false);
			Scheduler.getInstance().add(new autonomous(0));
			OICommands();
			toggle = false;
		}

		Scheduler.getInstance().run();

	}

	//Adds commands to scheduler after leaving vision system control
	void OICommands() {
		Scheduler.getInstance().add(new autonomous(0));
		Scheduler.getInstance().add(new DriveWithJoysticks());
		Scheduler.getInstance().add(new MoveCollector());
		Scheduler.getInstance().add(new MoveLauncher());
	}

	@Override
	public void testPeriodic() {
	}
}
