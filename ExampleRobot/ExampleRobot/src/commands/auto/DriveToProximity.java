package commands.auto;

import commands.LowerArmCommand;
import commands.RaiseArmCommand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import robot.Robot;

public class DriveToProximity extends Command{

	@Override
	protected void initialize() {
		Scheduler.getInstance().add(new LowerArmCommand());
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
		Scheduler.getInstance().add(new RaiseArmCommand());
	}

	@Override
	protected void interrupted() {
		// Do nothing.
	}

}
