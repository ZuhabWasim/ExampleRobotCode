package commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class DriveDistanceCommand extends Command {

	double distance;
	double speed;
	
	double initialDistance;
	
	public DriveDistanceCommand(double distance, double speed) {
		this.distance = distance;
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		//You can't put this in the constructor because when you set a distance
		//in the constructor, its not going to be run at the same time when
		//it started to execute.
		initialDistance = Robot.chassisSubsystem.getDistance();
	}

	@Override
	protected void execute() {
		Robot.chassisSubsystem.setSpeed(speed, speed);
	}

	@Override
	protected boolean isFinished() {
		return Robot.chassisSubsystem.getDistance() >= initialDistance + distance;
	}

	@Override
	protected void end() {
		Robot.chassisSubsystem.setSpeed(0.0, 0.0);
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
