package commands.auto.defenses;

import commands.LowerArmCommand;
import commands.RaiseArmCommand;
import commands.auto.DriveDistanceCommand;
import commands.auto.DriveToProximity;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossPortcullisCommand extends CommandGroup {
	
	public CrossPortcullisCommand() {	
		// lowers the arm
		addSequential(new LowerArmCommand());
		
		// drive to platform
		addSequential(new DriveToProximity());
				
		// drive forward l'.
		addSequential(new DriveDistanceCommand(12, 1.0));
		
		// raise the arm
		addSequential(new RaiseArmCommand());

		// drive forward and raise the arm
		addSequential(new DriveDistanceCommand(50, 1.0));
	}
	
}
