package oi;

import edu.wpi.first.wpilibj.Joystick;

public class F310Controller extends Joystick{
	
	// constructor
	public F310Controller(int port) {
		super(port);
	}
	
	// methods
	public enum Button {
		A(0), B(1), X(2), Y(3), LEFT_BUMPER(4), RIGHT_BUMPER(5), BACK(6), START(7);
		
		private int number;
		
		Button(int number) {
			this.number = number;
		}
		
		public int getNumber() {
			return number;
		}
	}
	
	public enum Axis {
		LX(0), LY(1), RX(4), RY(5);
		
		private int number;
		
		Axis(int number) {
			this.number = number;
		}
		
		public int getNumber() {
			return number;
		}
	}
	
	public enum Trigger {
		LEFT(2), RIGHT(3);
		
		private int number;
		
		Trigger(int number) {
			this.number = number;
		}
		
		public int getNumber() {
			return number;
		}
	}
	
	public boolean isButtonPressed(Button button) {
		return this.getRawButton(button.getNumber());
	}
	
	public double getAxisValue(Axis axis) {
		return this.getRawAxis(axis.getNumber());
	}
	
	public double getTriggerValue(Trigger trigger) {
		return this.getRawAxis(trigger.getNumber());
	}
}
