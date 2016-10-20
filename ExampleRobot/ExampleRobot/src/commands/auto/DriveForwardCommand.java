package commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class DriveForwardCommand extends Command{

	@Override
	protected void initialize() {
		// Do nothing.
	}

	@Override
	protected void execute() {
		Robot.chassisSubsystem.setSpeed(1.0, 1.0);
	}

	@Override
	protected boolean isFinished() {
		return Robot.chassisSubsystem.isWithinProximity();
	}

	@Override
	protected void end() {
		Robot.chassisSubsystem.setSpeed(0.0, 0.0);
	}

	@Override
	protected void interrupted() {
		//Do nothing
	}
	
	
}
