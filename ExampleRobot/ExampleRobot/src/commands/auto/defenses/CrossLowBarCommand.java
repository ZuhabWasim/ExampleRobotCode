package commands.auto.defenses;

import commands.LowerArmCommand;
import commands.RaiseArmCommand;
import commands.auto.DriveDistanceCommand;
import commands.auto.DriveToProximity;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossLowBarCommand extends CommandGroup {

	public CrossLowBarCommand() {
		
		//Lower arm
		addSequential(new LowerArmCommand());
		
		//drive to the platform
		addSequential(new DriveToProximity());
		
		// cross the defense
		addSequential(new DriveDistanceCommand(50, 1.0));
		
		//raise arm
		addSequential(new RaiseArmCommand());
	}
}
