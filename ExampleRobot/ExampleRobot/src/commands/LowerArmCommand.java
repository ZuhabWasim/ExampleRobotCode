package commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class LowerArmCommand extends Command {
	
	public LowerArmCommand() {
		requires(Robot.armSubsystem);
	}

	@Override
	protected void initialize() {
		//Do nothing.
	}

	@Override
	protected void execute() {
		Robot.armSubsystem.moveArmDown();
	}

	@Override
	protected boolean isFinished() {
		return Robot.armSubsystem.isArmAtLowerLimit();
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
