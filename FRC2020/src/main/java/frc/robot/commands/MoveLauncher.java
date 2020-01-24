package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveLauncher extends Command {
    OI oi = Robot.m_oi;

    public MoveLauncher() {
        requires(Robot.collector);
    }

    protected void initialize() {
    }

    protected void execute() {
        // Passes OI into elevator
        //set speed
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
