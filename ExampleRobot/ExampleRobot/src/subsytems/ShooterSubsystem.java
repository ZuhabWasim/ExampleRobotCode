package subsytems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSubsystem extends BaseSubsystem{
	
	// components
	private Victor intakeMotor = new Victor(2);
	private Victor shooterMotor = new Victor(3);
	
	private DigitalInput ballSensor = new DigitalInput(6);
	
	//functions
	public void runIntakeForward() {
		intakeMotor.set(1.0);
	}
	
	public void runIntakeReverse() {
		intakeMotor.set(-1.0);
	}
	
	public void stopIntake() {
		intakeMotor.set(0);
	}
	
	public void setShooterSpeed(double speed) {
		shooterMotor.set(speed);
	}
	
	public boolean isBallLoaded() {
		return ballSensor.get();
	}

	@Override
	protected void initDefaultCommand() {
		// Do nothing.
	}
	
	@Override
	public void updateDashboard() {

		SmartDashboard.putBoolean("Ball Loaded", isBallLoaded());
		
	}
	
}
