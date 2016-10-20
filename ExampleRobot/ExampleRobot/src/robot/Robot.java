
package robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import oi.OI;
import subsytems.ArmSubsystem;
import subsytems.BaseSubsystem;
import subsytems.ChassisSubsystem;
import subsytems.ShooterSubsystem;

public class Robot extends IterativeRobot {
	
	// subsystems
	public static ChassisSubsystem chassisSubsystem;
	public static ShooterSubsystem shooterSubsystem;
	public static ArmSubsystem armSubsystem;
	
	//oi
	public static OI oi;
	
	// subsystem list
	BaseSubsystem[] subsystemList;
    
	// robot initialization when the robot object is created
	// tells coders that this method will override the already existing method
	@Override
	public void robotInit() {
		chassisSubsystem = new ChassisSubsystem();
		shooterSubsystem = new ShooterSubsystem();
		armSubsystem = new ArmSubsystem();
		
		subsystemList = new BaseSubsystem[] {chassisSubsystem, shooterSubsystem, armSubsystem};
		
		oi = new OI();
	}
	
	public void autonomousInit() {
		//get the auto command and schedule it
		Command autoCommand = null;
		
		//Schedule the command.CrossChavelDeFriseCommand.java
		Scheduler.getInstance().add(autoCommand);
		
		updateDashboard();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		updateDashboard();
	}
	
	public void teleopInit() {
		updateDashboard();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		updateDashboard();
	}
	
	public void disabledInit() {
		// do nothing
	}
	
	public void disabledPeriodic() {
		// do nothing
	}
	
	public void updateDashboard() {
		
		for (BaseSubsystem subsystem : subsystemList) {
			subsystem.updateDashboard();
		}
		/*chassisSubsystem.updateDashboard();
		shooterSubsystem.updateDashboard();
		armSubsystem.updateDashboard();*/
	}
}
