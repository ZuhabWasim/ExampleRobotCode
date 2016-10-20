package commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class ShootCommand extends Command{

	double speed;
	
	boolean cancelled;
	
	public ShootCommand(double speed) {
		requires(Robot.shooterSubsystem);
		
		this.speed = speed;
		this.cancelled = false;
	}
	
	@Override
	protected void initialize() {
		// Do nothing.
	}

	@Override
	protected void execute() {
		if(Robot.oi.isCancelButtonPressed()) {
			cancelled = true;
		}
		Robot.shooterSubsystem.setShooterSpeed(speed);
	}

	@Override
	protected boolean isFinished() {
		return !Robot.shooterSubsystem.isBallLoaded() || cancelled;
	}

	@Override
	protected void end() {
		
		if (cancelled) {
			Robot.shooterSubsystem.setShooterSpeed(-1.0);
			Robot.shooterSubsystem.runIntakeReverse();
		}
		Robot.shooterSubsystem.setShooterSpeed(0.0);
		Robot.shooterSubsystem.stopIntake();
	}

	@Override
	protected void interrupted() {
		// Do nothing.
	}
	
}
