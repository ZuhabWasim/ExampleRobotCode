package oi;

import oi.F310Controller.Button;
import oi.F310Controller.Axis;

public class OI {
	
	private F310Controller controller = new F310Controller(0);
	
	public double getSpeedSetPoint() {
		return controller.getAxisValue(Axis.LY);
	}
	
	public double getTurnSetPoint() {
		return controller.getAxisValue(Axis.RX);
	}
	
	public boolean isIntakeButtonPressed() {
		return controller.isButtonPressed(Button.RIGHT_BUMPER);
	}
	
	public boolean isShootButtonPreesed() {
		return controller.isButtonPressed(Button.B);
	}
	
	public boolean isCancelButtonPressed() {
		return controller.isButtonPressed(Button.X);
	}
	
	public boolean isArmButtonPressed() {
		return controller.isButtonPressed(Button.LEFT_BUMPER);
	}
	
}

