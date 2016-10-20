package subsytems;

import commands.JoystickCommand;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import sensors.UltrasonicSensor;

public class ChassisSubsystem extends BaseSubsystem{
	
	//components
	private Victor leftMotor = new Victor(0);
	private Victor rightMotor = new Victor(1);
	
	private Encoder leftEncoder = new Encoder(0, 1);
	private Encoder rightEncoder = new Encoder(2, 3);
	
	private double k = 0;
	private UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(0, k);
	
	private DigitalInput leftProximitySensor = new DigitalInput(4);
	private DigitalInput rightProximitySensor = new DigitalInput(5);
	
	//functions
	public void setSpeed(double leftSpeed, double rightSpeed) {
		leftMotor.set(leftSpeed);
		rightMotor.set(rightSpeed);
	}
	
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) * 0.5;
	}
	
	public double getDistanceFromObject() {
		return ultrasonicSensor.getDistance();
	}
	
	public boolean isWithinProximity() {
		return leftProximitySensor.get() || rightProximitySensor.get();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickCommand());
	}
	
	@Override
	public void updateDashboard() {
		double leftSpeed = leftEncoder.getRate();
		double rightSpeed = rightEncoder.getRate();
		
		SmartDashboard.putNumber("Left Motor Speed", leftSpeed);
		SmartDashboard.putNumber("Right Motor Speed", rightSpeed);

		SmartDashboard.putNumber("Ultrasonic Distance", ultrasonicSensor.getDistance());
		
		SmartDashboard.putBoolean("Left Proximity", leftProximitySensor.get());
		SmartDashboard.putBoolean("Right Proximity", rightProximitySensor.get());
	}
}
