package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class MoveCollector extends Command {

    public MoveCollector() {
        requires(Robot.collector);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        //set motor speed
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.collector.stop();
    }

    protected void interrupted() {
        end();
    }
}
