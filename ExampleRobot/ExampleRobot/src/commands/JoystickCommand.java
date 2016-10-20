package commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import robot.Robot;

public class JoystickCommand extends Command {

	@Override
	protected void initialize() {
		// Do nothing.
	}

	@Override
	protected void execute() {
		//set the speed of the robot.
		double speed = Robot.oi.getSpeedSetPoint();
		double turn = Robot.oi.getTurnSetPoint();
		
		double leftSpeed = (turn > 0) ? speed : speed * (1.0 + turn);
		double rightSpeed = (turn > 0) ? speed * (1.0 - turn) : speed;
		
		Robot.chassisSubsystem.setSpeed(leftSpeed, rightSpeed);
		
		// shoot if needed
		if (Robot.oi.isShootButtonPreesed() && Robot.shooterSubsystem.isBallLoaded()) {
			// shoot.
			Scheduler.getInstance().add(new ShootCommand(1.0));
		}
		
		// move if needed
		if (Robot.oi.isArmButtonPressed()) {
			if (Robot.armSubsystem.isArmAtLowerLimit()) {
				Scheduler.getInstance().add(new RaiseArmCommand());
			} else {
				Scheduler.getInstance().add(new LowerArmCommand());
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// unreachable.
	}

	@Override
	protected void interrupted() {
		// do nothing.
	}
	
}
