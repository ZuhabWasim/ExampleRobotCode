package sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensor extends AnalogInput{

	private double inchesPerVolt;
	
	public UltrasonicSensor(int channel, double inchesPerVolt) {
		super(channel);
		
		this.inchesPerVolt = inchesPerVolt;
	}

	public double getDistance() {
		return this.getVoltage() * inchesPerVolt;
	}
	
}
