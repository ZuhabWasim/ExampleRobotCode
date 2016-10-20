package commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class RaiseArmCommand extends Command {
	
	public RaiseArmCommand() {
		requires(Robot.armSubsystem);
	}

	@Override
	protected void initialize() {
		//Do nothing.
	}

	@Override
	protected void execute() {
		Robot.armSubsystem.moveArmUp();
	}

	@Override
	protected boolean isFinished() {
		return Robot.armSubsystem.isArmAtUpperLimit();
	}

	@Override
	protected void end() {
		Robot.armSubsystem.stopArm();
	}

	@Override
	protected void interrupted() {
		//Do nothing
	}

}
